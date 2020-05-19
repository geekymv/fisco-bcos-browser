package org.bcos.browser.service;

import lombok.extern.slf4j.Slf4j;
import org.bcos.browser.base.ConstantCode;
import org.bcos.browser.base.GasConstants;
import org.bcos.browser.chain.Archives;
import org.bcos.browser.entity.base.BaseResponse;
import org.bcos.browser.entity.req.ReqArchivesUplink;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.precompile.cns.CnsService;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Slf4j
@Service
public class BlockChainService {

    @Autowired
    private Web3j web3j;

    @Autowired
    private ArchivesService archivesService;

    /**
     * 档案馆信息上链
     * @param param
     * @throws Exception
     */
    public BaseResponse archivesUplink(ReqArchivesUplink param) {
        org.bcos.browser.entity.dto.Archives archives = new org.bcos.browser.entity.dto.Archives();
        BeanUtils.copyProperties(param, archives);
        archives = archivesService.addArchives(archives);

        //通过指定外部账户私钥使用指定的外部账户
        Credentials credentials = GenCredential.create(archives.getArchivesPrivate());
        //准备部署和调用合约的参数
        StaticGasProvider staticGasProvider = new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT);

        CnsService cnsService = new CnsService(web3j, credentials);
        String contractAddress = cnsService.getAddressByContractNameAndVersion("Archives");
        Archives load = Archives.load(contractAddress, web3j, credentials, staticGasProvider);

        try {
            TransactionReceipt result = load.archivesUp(param.getArchivesId(), param.getArchivesName(), archives.getArchivesAddress()).send();
            Tuple1<BigInteger> output = load.getArchivesUpOutput(result);
            BigInteger value1 = output.getValue1();
            log.info("archivesUplink result = " + value1.intValue());

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return new BaseResponse(ConstantCode.SUCCESS, archives.getArchivesAddress());
    }

}

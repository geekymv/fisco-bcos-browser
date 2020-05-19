package org.bcos.browser.service;

import lombok.extern.slf4j.Slf4j;
import org.bcos.browser.base.ConstantCode;
import org.bcos.browser.base.exception.BaseException;
import org.bcos.browser.entity.base.BaseResponse;
import org.bcos.browser.entity.dto.Archives;
import org.bcos.browser.entity.dto.User;
import org.bcos.browser.mapper.ArchivesMapper;
import org.bcos.browser.mapper.UserMapper;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.EncryptType;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ArchivesService {

    @Autowired
    private ArchivesMapper archivesMapper;

    @Transactional
    public Archives addArchives(Archives param) {
        Archives archives = archivesMapper.getArchivesById(param.getArchivesId());
        if(archives == null) {
            //创建普通外部账户
            EncryptType.encryptType = 0;
            //创建国密外部账户，向国密区块链节点发送交易需要使用国密外部账户
            // EncryptType.encryptType = 1;
            Credentials credentials = GenCredential.create();
            //账户地址
            String address = credentials.getAddress();
            //账户私钥
            String privateKey = credentials.getEcKeyPair().getPrivateKey().toString(16);
            //账户公钥
            String publicKey = credentials.getEcKeyPair().getPublicKey().toString(16);

            param.setArchivesAddress(address);
            param.setArchivesPrivate(privateKey);
            param.setArchivesPublic(publicKey);
            archivesMapper.addArchives(param);

            return param;
        }

        return archives;
    }


}

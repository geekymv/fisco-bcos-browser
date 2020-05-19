package org.bcos.browser.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.bcos.browser.base.BaseController;
import org.bcos.browser.base.ConstantCode;
import org.bcos.browser.base.exception.BaseException;
import org.bcos.browser.entity.base.BaseResponse;
import org.bcos.browser.entity.dto.User;
import org.bcos.browser.entity.req.ReqApplyForUplink;
import org.bcos.browser.entity.req.ReqArchivesUplink;
import org.bcos.browser.entity.req.ReqExamineUplink;
import org.bcos.browser.entity.req.ReqFilesUplink;
import org.bcos.browser.entity.req.ReqHandleUplink;
import org.bcos.browser.entity.req.ReqReplyUplink;
import org.bcos.browser.entity.req.ReqStaffMember;
import org.bcos.browser.entity.rsp.RspBlockChain;
import org.bcos.browser.service.BlockChainService;
import org.bcos.browser.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/blockChain")
public class BlockChainController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlockChainService blockChainService;

    /**
     * 工作人员信息上链接口（工作人员登录时信息上链）
     * @param param
     * @param result
     * @return
     * @throws BaseException
     */
    @PostMapping("/staffMemberInformUplink")
    public BaseResponse staffMemberInformUplink(@Valid @RequestBody ReqStaffMember param, BindingResult result)
            throws BaseException {
        log.info("staffMemberInformUplink param {}", JSON.toJSONString(param));
        checkParamResult(result);
        User user = new User();
        BeanUtils.copyProperties(param, user);
        return userService.addUser(user);
    }

    /**
     * 公众申请上链接口
     * @param param
     * @return
     */
    @PostMapping("/applyForUplink")
    public BaseResponse applyForUplink(@RequestBody ReqApplyForUplink param) {
        log.info("applyForUplink param {}", JSON.toJSONString(param));

        RspBlockChain rsp = new RspBlockChain();
        return new BaseResponse(ConstantCode.SUCCESS, rsp);
    }

    /**
     * 国家馆审核上链接口
     * @param param
     * @return
     */
    @PostMapping("/examineUplink")
    public BaseResponse examineUplink(@RequestBody ReqExamineUplink param) {
        log.info("examineUplink param {}", JSON.toJSONString(param));

        RspBlockChain rsp = new RspBlockChain();
        return new BaseResponse(ConstantCode.SUCCESS, rsp);
    }

    /**
     * 地方馆处理上链接口
     * @param param
     * @return
     */
    @PostMapping("/handleUplink")
    public BaseResponse handleUplink(@RequestBody ReqHandleUplink param) {
        log.info("handleUplink param {}", JSON.toJSONString(param));

        RspBlockChain rsp = new RspBlockChain();
        return new BaseResponse(ConstantCode.SUCCESS, rsp);
    }

    /**
     * 国家馆批复上链接口
     * @param param
     * @return
     */
    @PostMapping("/replyUplink")
    public BaseResponse replyUplink(@RequestBody ReqReplyUplink param) {
        log.info("replyUplink param {}", JSON.toJSONString(param));

        RspBlockChain rsp = new RspBlockChain();
        return new BaseResponse(ConstantCode.SUCCESS, rsp);
    }

    /**
     * 档案馆信息上链接口
     * @param param
     * @return
     */
    @PostMapping("/archivesUplink")
    public BaseResponse archivesUplink(@Valid @RequestBody ReqArchivesUplink param, BindingResult result)
            throws BaseException {
        log.info("archivesUplink param {}", JSON.toJSONString(param));
        checkParamResult(result);
        return blockChainService.archivesUplink(param);
    }

    /**
     * 档案信息上链
     * @param param
     * @return
     */
    @PostMapping("/filesUplink")
    public BaseResponse filesUplink(@RequestBody ReqFilesUplink param) {
        log.info("filesUplink param {}", JSON.toJSONString(param));

        RspBlockChain rsp = new RspBlockChain();
        return new BaseResponse(ConstantCode.SUCCESS, rsp);
    }



}

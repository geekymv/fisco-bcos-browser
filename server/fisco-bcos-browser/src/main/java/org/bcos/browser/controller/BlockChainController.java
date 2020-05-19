package org.bcos.browser.controller;

import lombok.extern.slf4j.Slf4j;
import org.bcos.browser.base.BaseController;
import org.bcos.browser.base.exception.BaseException;
import org.bcos.browser.entity.base.BaseResponse;
import org.bcos.browser.entity.dto.User;
import org.bcos.browser.entity.req.ReqStaffMember;
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

    /**
     * 工作人员信息上链接口（工作人员登录时信息上链）
     */
    @PostMapping("/staffMemberInformUplink")
    public BaseResponse staffMemberInformUplink(@Valid @RequestBody ReqStaffMember param, BindingResult result)
            throws BaseException {
        checkParamResult(result);
        User user = new User();
        BeanUtils.copyProperties(param, user);
        return userService.addUser(user);
    }


}

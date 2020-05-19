package org.bcos.browser.entity.rsp;

import lombok.Data;

@Data
public class RspStaffMember {
    // 链上地址
    private String userAddress;
    // 私钥
    private String userPrivate;
    // 公钥
    private String userPublic;
}

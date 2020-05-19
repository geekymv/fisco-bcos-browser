package org.bcos.browser.entity.req;

import lombok.Data;

@Data
public class ReqApplyForUplink {
    // 登记号
    private String registrationNo;
    // 身份证号
    private String cardNo;
    // 利用目的
    private String useObjective;
    // 查单内容
    private String checkContent;
    // 登记时间
    private String registrationTime;
    // 操作者私钥(公共私钥)
    private String privateKey;
    // 发送用户Id
    private String fromId;
    // 发送用户名称
    private String fromName;
    // 接受档案馆Id
    private String toId;
    // 接受档案馆名称
    private String toName;
}

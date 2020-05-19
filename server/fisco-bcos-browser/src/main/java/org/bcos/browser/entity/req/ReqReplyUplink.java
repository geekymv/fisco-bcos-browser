package org.bcos.browser.entity.req;

import lombok.Data;

@Data
public class ReqReplyUplink {
    // 登记号
    private String registrationNo;
    // 批复人
    private String approvedBy;
    // 批复时间
    private String approvalTime;
    // 批复状态（通过/不通过）
    private String approvalStatus;
    // 备注
    private String remarks;
    // 操作者私钥
    private String privateKey;
    // 发送档案者Id
    private String fromId;
    // 发送档案馆名称
    private String fromName;
    // 接受用户Id
    private String toId;
    // 接受用户名称
    private String toName;
}

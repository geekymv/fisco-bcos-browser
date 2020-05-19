package org.bcos.browser.entity.req;

import lombok.Data;

@Data
public class ReqExamineUplink {

    // 登记号
    private String registrationNo;
    // 流水号
    private String serialNo;
    // 审核人
    private String reviewedName;
    // 审核状态（通过/不通过）
    private String auditStatus;
    // 备注
    private String remarks;
    // 手机号
    private String telephone;
    // 审核时间
    private String auditTime;
    // 操作者私钥
    private String privateKey;
    // 发送档案馆Id
    private String fromId;
    // 发送档案馆名称
    private String fromName;
    // 接受档案馆Id
    private String toId;
    // 接受档案馆名称
    private String toName;
}

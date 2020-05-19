package org.bcos.browser.entity.req;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReqHandleUplink {
    // 登记号
    private String registrationNo;
    // 处理人
    private String handler;
    // 处理状态（通过/不通过）
    private String processState;
    // 附件	(同档案信息上链接口)
    private List<ReqFilesUplink> annex = new ArrayList<>();
    // 备注
    private String remarks;
    // 处理时间
    private String processTime;
    // 借阅截止时间
    private String deadline;
    // 操作者私钥
    private String privateKey;
    // 发送档案馆Id
    private String fromId;
    // 发送档案馆名称
    private String fromName;
    // 接受档案馆Id
    private String toId;
    //  接受档案馆名称
    private String toName;
}

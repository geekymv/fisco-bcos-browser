package org.bcos.browser.entity.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReqFilesUplink implements Serializable  {
    // MD5码
    private String mdCode;
    // 文件名称
    private String filename;
    // 文件类型
    private String filetype;
    // 文档分类
    private String docclass;
    // 大小
    private String filesize;
    // 操作者私钥
    private String privateKey;
    // 档案馆名称
    private String sharepersion;
    // 共享时间
    private String sharetime;
    // 查看权限
    private String viewpermissions;
    // 失效时间
    private String expirationtime;
}

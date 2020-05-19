package org.bcos.browser.entity.req;

import lombok.Data;
import org.bcos.browser.base.ConstantCode;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class ReqArchivesUplink {
    // 档案馆Id
    @NotBlank(message = ConstantCode.ARCHIVES_ID_IS_EMPTY)
    private String archivesId;
    // 档案馆名称
    private String archivesName;
}

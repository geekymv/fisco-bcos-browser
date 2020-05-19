package org.bcos.browser.entity.req;

import lombok.Data;
import org.bcos.browser.base.ConstantCode;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class ReqStaffMember {
    // 人员名称
    private String userName;

    // 人员id
    @NotBlank(message = ConstantCode.USER_ID_IS_EMPTY)
    private String userId;
}

package org.bcos.browser.entity.dto;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String userName;
    private String userAddress;
    private String userPrivate;
    private String userPublic;
}

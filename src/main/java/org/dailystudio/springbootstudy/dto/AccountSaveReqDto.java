package org.dailystudio.springbootstudy.dto;

import lombok.Getter;

@Getter
public class AccountSaveReqDto {
    private String accountEmail;
    private String accountPasswd;
    private String accountName;
}

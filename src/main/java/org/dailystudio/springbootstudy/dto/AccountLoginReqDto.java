package org.dailystudio.springbootstudy.dto;

import lombok.Getter;

@Getter
public class AccountLoginReqDto {
    private String accountEmail;
    private String accountPassword;
}

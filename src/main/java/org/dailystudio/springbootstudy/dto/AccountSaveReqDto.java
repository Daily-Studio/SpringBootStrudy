package org.dailystudio.springbootstudy.dto;

import lombok.Getter;

@Getter
public class AccountSaveReqDto {
    private String name;
    private String pass;
    private String email;
}

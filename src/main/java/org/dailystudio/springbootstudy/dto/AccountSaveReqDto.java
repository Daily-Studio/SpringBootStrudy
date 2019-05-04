package org.dailystudio.springbootstudy.dto;

import lombok.Getter;

@Getter
public class AccountSaveReqDto {

    private String email;
    private String password;
    private String name;

}

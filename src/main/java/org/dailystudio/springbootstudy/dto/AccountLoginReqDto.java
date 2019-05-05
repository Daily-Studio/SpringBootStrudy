package org.dailystudio.springbootstudy.dto;

import lombok.Getter;

@Getter
public class AccountLoginReqDto {
    private String email;
    private String pass;

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}

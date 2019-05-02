package org.dailystudio.springbootstudy.dto;

import lombok.Getter;

@Getter
public class AccountResDto {
    private String email;
    private String name;

    public AccountResDto(String email, String name){
        this.email = email;
        this.name = name;
    }
}

package org.dailystudio.springbootstudy.dto;

import lombok.Getter;

@Getter
public class AccountSignUpReqDto {
    private Long id;
    private String email;
    private String name;
    private String pass;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}

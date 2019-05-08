package org.dailystudio.springbootstudy.dto;

import lombok.Getter;

@Getter
public class AccountSignUpReqDto {
    private Long id;
    private String email;
    private String name;
    private String pass;

}

package org.dailystudio.springbootstudy.domain;

import lombok.Getter;

@Getter
public class User {
    private Long userIdx;
    private String email;
    private String name;
    private String pass;
    private String phone;
    private String auth;
}

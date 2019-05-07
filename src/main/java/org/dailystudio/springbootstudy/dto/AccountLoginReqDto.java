package org.dailystudio.springbootstudy.dto;

import lombok.Getter;

@Getter
public class AccountLoginReqDto { //로그인할 때는 2개의 정보만 필요하기에 두개만 받는다.
    private String email;
    private String pass;
}

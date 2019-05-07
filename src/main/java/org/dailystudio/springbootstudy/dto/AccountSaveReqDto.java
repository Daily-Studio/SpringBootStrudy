package org.dailystudio.springbootstudy.dto;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Account;

@Getter
public class AccountSaveReqDto {
    private String name;
    private String pass;
    private String email;

    public Account toEntity(){
        return new Account(email, pass, name);
    }
}

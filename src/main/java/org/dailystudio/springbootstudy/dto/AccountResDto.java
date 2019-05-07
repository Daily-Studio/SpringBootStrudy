package org.dailystudio.springbootstudy.dto;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Account;

@Getter
public class AccountResDto {
    private String email;
    private String name;

    public AccountResDto(String email, String name){
        this.email = email;
        this.name = name;
    }

    public AccountResDto(Account account){
        this.email = account.getEmail();
        this.name = account.getName();
    }
}

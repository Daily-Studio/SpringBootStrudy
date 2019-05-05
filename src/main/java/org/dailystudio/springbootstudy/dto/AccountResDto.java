package org.dailystudio.springbootstudy.dto;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Account;

@Getter
public class AccountResDto {
    private String accountEmail;
    private String accountName;

    public AccountResDto(String email, String name){
        this.accountEmail = email;
        this.accountName = name;
    }

    public AccountResDto(Account account){
        this.accountEmail = account.getEmail();
        this.accountName = account.getName();
    }
}

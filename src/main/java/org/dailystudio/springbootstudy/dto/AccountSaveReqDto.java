package org.dailystudio.springbootstudy.dto;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Account;

@Getter
public class AccountSaveReqDto {
    private String accountEmail;
    private String accountPasswd;
    private String accountName;

    public Account toEntity(){
        return new Account(accountEmail, accountPasswd, accountName);
    }
}

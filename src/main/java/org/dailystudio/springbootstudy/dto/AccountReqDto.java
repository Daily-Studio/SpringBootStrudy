package org.dailystudio.springbootstudy.dto;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Account;

@Getter
public class AccountReqDto {
    private String email;
    private String password;

    public AccountReqDto(Account account){
        this.email = account.getEmail();
        this.password = account.getPassword();
    }
}

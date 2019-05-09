package org.dailystudio.springbootstudy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.dailystudio.springbootstudy.domain.Account;

@Data
@NoArgsConstructor
public class AccountReq {
    private String email;
    private String password;
    private String name;

    public AccountReq(Account account) {
    }

    public AccountReq(String email, String name, String password){
        this.email = email;
        this.password = password;
        this.name = name;
    }
}

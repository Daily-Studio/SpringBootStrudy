package org.dailystudio.springbootstudy.service;

import lombok.Getter;
import lombok.Setter;
import org.dailystudio.springbootstudy.dto.AccountSaveReqDto;
import org.dailystudio.springbootstudy.repository.AccountRepository;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
public class AccountService {

    private final AccountRepository accountRepository;

    public boolean singUp(@RequestBody AccountSaveReqDto accountSaveReqDto){
        String email = accountSaveReqDto.getAccountEmail();
        String password = accountSaveReqDto.getAccountPasswd();
        String name = accountSaveReqDto.getAccountName();

        if (accountSaveReqDto)

    }

}

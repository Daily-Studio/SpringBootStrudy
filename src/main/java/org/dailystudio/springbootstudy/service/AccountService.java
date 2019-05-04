package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Account;
import org.dailystudio.springbootstudy.dto.AccountSaveReqDto;
import org.dailystudio.springbootstudy.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    /* 이게 @RequiredArgsConstructor랑 같은 역활을 함!
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    */

    public Boolean signUp(AccountSaveReqDto accountSaveReqDto){
        String email = accountSaveReqDto.getEmail();
        String password = accountSaveReqDto.getPassword();
        String name = accountSaveReqDto.getName();

        if (accountRepository.findByEmail(email) != null){
            return false;
        }

        Account account = new Account(email, password, name);




    }
}

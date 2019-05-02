package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.AccountSaveReqDto;
import org.dailystudio.springbootstudy.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public boolean signUp(AccountSaveReqDto accountSaveReqDto){
        String email = accountSaveReqDto.getEmail();
        String password = accountSaveReqDto.getPass();
        String name = accountSaveReqDto.getName();

        if(accountRepository.findByEmail(email) != null)
    }



}

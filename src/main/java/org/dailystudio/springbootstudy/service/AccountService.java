package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Account;
import org.dailystudio.springbootstudy.dto.AccountLoginReqDto;
import org.dailystudio.springbootstudy.dto.AccountResDto;
import org.dailystudio.springbootstudy.dto.AccountSaveReqDto;
import org.dailystudio.springbootstudy.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public boolean signUp(AccountSaveReqDto accountSaveReqDto){

        String email = accountSaveReqDto.getEmail();
        String password = accountSaveReqDto.getPassword();
        String name = accountSaveReqDto.getName();

        if(accountRepository.findByEmail(email) !=null){
            return false;
        }

        Account account = new Account(email, password, name);

        accountRepository.save(account);
        return true;
    }
    public Account login(AccountLoginReqDto accountLoginReqDto){
     String email = accountLoginReqDto.getEmail();
     String password = accountLoginReqDto.getPassword();
     Account account = accountRepository.findByEamil(email);

     if(account == null){
         return null;
     }
     if (account.getPassword() != password){
         return null;
     }
        AccountResDto accountResDto = new AccountResDto(account.getEmail(), account.getName()) ;
        return accountResDto;
    }

}

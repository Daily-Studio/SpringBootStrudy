package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Account;
import org.dailystudio.springbootstudy.dto.AccountLoginReqDto;
import org.dailystudio.springbootstudy.dto.AccountResDto;
import org.dailystudio.springbootstudy.dto.AccountSaveReqDto;
import org.dailystudio.springbootstudy.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.Null;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public boolean singUp(@RequestBody AccountSaveReqDto accountSaveReqDto){
        String email = accountSaveReqDto.getAccountEmail();
        if (accountRepository.findByEmail(email)!=null)
            return false;

        Account account = accountSaveReqDto.toEntity();

        accountRepository.save(account);
        return true;
    }

    public AccountResDto login(AccountLoginReqDto accountLoginReqDto){
        String email = accountLoginReqDto.getAccountEmail();
        String password = accountLoginReqDto.getAccountPassword();

        Account account =  accountRepository.findByEmail(email);
        if( account == null){
            throw new NoSuchElementException("none");
        }
        if(!account.getPasswd().equals(password)){
            throw new IllegalArgumentException("password Error");
        }
        AccountResDto accountResDto = new AccountResDto(account);

        return accountResDto;
    }

}

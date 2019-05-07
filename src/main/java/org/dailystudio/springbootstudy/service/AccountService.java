package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dailystudio.springbootstudy.domain.Account;
import org.dailystudio.springbootstudy.dto.AccountLoginReqDto;
import org.dailystudio.springbootstudy.dto.AccountResDto;
import org.dailystudio.springbootstudy.dto.AccountSaveReqDto;
import org.dailystudio.springbootstudy.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;

    public boolean signUp(AccountSaveReqDto accountSaveReqDto){
        String email = accountSaveReqDto.getEmail();
        String password = accountSaveReqDto.getPass();
        String name = accountSaveReqDto.getName();

        if(accountRepository.findByEmail(email) != null){
            return false;
        }
        Account account = accountSaveReqDto.toEntity();

        accountRepository.save(account);
        return true;
    }

    public AccountResDto login(AccountLoginReqDto accountLoginReqDto) throws IllegalAccessException {
        String email = accountLoginReqDto.getEmail();
        String pass = accountLoginReqDto.getPass();

        Account account = accountRepository.findByEmail(email);
        if(account == null){
            throw new NoSuchElementException("일치하는 계정 없음.");
        }

        if(!account.getPassword().equals(pass)){
            throw new IllegalAccessException("비밀번호가 맞지 않음.");
        }

        AccountResDto accountResDto = new AccountResDto(account);

        return accountResDto;
    }



}

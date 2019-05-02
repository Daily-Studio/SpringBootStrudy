package org.dailystudio.springbootstudy.service;


import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Account;
import org.dailystudio.springbootstudy.dto.AccountReqDto;
import org.dailystudio.springbootstudy.dto.LogInReqDto;
import org.dailystudio.springbootstudy.dto.LogInResDto;
import org.dailystudio.springbootstudy.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    public boolean SignUpAccount(AccountReqDto accountReqDto){


        String email = accountReqDto.getEmail();
        String pass = accountReqDto.getPass();
        String name = accountReqDto.getName();

        if (accountRepository.findByEmail(email) != null)
            return false;


        Account account = new Account(pass,email,name);
        accountRepository.save(account);

        return true;
    }

    public ResponseEntity<LogInResDto> SignInAccount(LogInReqDto logInReqDto){

        String email = logInReqDto.getEmail();
        String pass = logInReqDto.getPass();

        if (accountRepository.findByEmail(email) != null)
            return false;
        if (accountRepository.findByPass(pass) != null)
            return false;
        LogInResDto logInResDto = new LogInResDto(email);

        return logInResDto;
    }
}

package org.dailystudio.springbootstudy.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Account;
import org.dailystudio.springbootstudy.dto.AccountLoginReqDto;
import org.dailystudio.springbootstudy.dto.AccountResDto;
import org.dailystudio.springbootstudy.dto.AccountSignUpReqDto;
import org.dailystudio.springbootstudy.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
    public class AccountService {

    private final AccountRepository accountRepository;


    @Transactional
    public boolean signUp(AccountSignUpReqDto accountSignUpReqDto)
    {

        String email = accountSignUpReqDto.getEmail();
        String pass = accountSignUpReqDto.getPass();
        String name = accountSignUpReqDto.getName();

        //
        if(accountRepository.findByEmail(email) != null)
        {
            return false;
        }
        Account account = new Account(email,pass,name);
        accountRepository.save(account);
                return true;

    }

    @Transactional
    public AccountResDto login(AccountLoginReqDto accountLoginReqDto) {

        String email = accountLoginReqDto.getEmail();
        String pass = accountLoginReqDto.getPass();

        Account account = accountRepository.findByEmail(email);
        if (account == null) {
            return null;
        }
        if (!account.getPass().equals(pass)) {
            return null;
        }

        AccountResDto accountResDto = new AccountResDto(account.getEmail(), account.getName());

        return accountResDto;
    }


}

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
@Slf4j
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public boolean signUp(AccountSaveReqDto accountSaveReqDto) {
        String email = accountSaveReqDto.getEmail();

        if (accountRepository.findByEmail(email) != null) {
            return false;
        }

        Account account = accountSaveReqDto.toEntity();

        accountRepository.save(account);
        return true;
    }

    public AccountResDto login(AccountLoginReqDto accountLoginReqDto) {
        String email = accountLoginReqDto.getEmail();
        String password = accountLoginReqDto.getPassword();

        Account account = accountRepository.findByEmail(email);
        if (account == null) {
            throw new NoSuchElementException("계정이 존재하지 않음.");
        }
        if (!account.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호 틀림");
        }

        AccountResDto accountResDto = new AccountResDto(account);

        return accountResDto;
    }
}

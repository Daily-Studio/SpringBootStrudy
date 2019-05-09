package org.dailystudio.springbootstudy.service;


import org.dailystudio.springbootstudy.domain.Account;
import org.dailystudio.springbootstudy.dto.AccountReq;
import org.dailystudio.springbootstudy.dto.LoginReq;
import org.dailystudio.springbootstudy.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean singUp(AccountReq accountReq){
        Account account = new Account(accountReq.getEmail(), accountReq.getPassword(), accountReq.getName());

        accountRepository.save(account);
        return true;
    }

    public AccountReq login(LoginReq loginReq) throws NoSuchFieldException {
        String email = loginReq.getEmail();
        String password = loginReq.getPassword();

        Account account = accountRepository.findByEmail(email);
        if(account == null){
            throw new NoSuchFieldException("none");
        }
        if(!account.getPassword().equals(password)){
            throw new IllegalArgumentException("password Error");
        }
        AccountReq accountReq = new AccountReq(account);

        return accountReq;
    }
}

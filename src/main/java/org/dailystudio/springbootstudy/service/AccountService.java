package org.dailystudio.springbootstudy.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public HashMap<String, String> signup(){

        HashMap<String,String> result = new HashMap<>();

        return result;
    }
}

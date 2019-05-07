package org.dailystudio.springbootstudy.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Account;
import org.dailystudio.springbootstudy.dto.LoginRequestDTO;
import org.dailystudio.springbootstudy.dto.SignupRequestDTO;
import org.dailystudio.springbootstudy.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public HashMap<String, String> signup(SignupRequestDTO signupRequestDTO) {

        HashMap<String, String> result = new HashMap<>();

        String email = signupRequestDTO.email;
        String name = signupRequestDTO.name;
        String password = signupRequestDTO.password;

        if (accountRepository.findByEmail(email) == null) {

            Account account = new Account(email, password, name);
            accountRepository.save(account);

            result.put("message", "회원가입 성공");
        } else {
            result.put("message", "중복된 이메일 존재");
        }

        return result;
    }

    public HashMap<String, String> login(LoginRequestDTO loginRequestDTO) {

        HashMap<String, String> result = new HashMap<>();

        String email = loginRequestDTO.email;
        String password = loginRequestDTO.password;

        Account userAccount = accountRepository.findByEmail(email);

        if (userAccount == null) {
            result.put("message", "로그인 실패 아이디 없음");
        } else {
            if (userAccount.password.equals(password)) {
                result.put("message", "로그인 성공");
            } else {
                result.put("message", "로그인 실패 비밀번호 틀림");
            }
        }
        return result;
    }

}

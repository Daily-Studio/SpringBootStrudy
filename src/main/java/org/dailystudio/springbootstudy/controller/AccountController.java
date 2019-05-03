package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.SignupRequestDTO;
import org.dailystudio.springbootstudy.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/login")
    public HashMap<String, String> postLogin(){
        HashMap<String,String> result = new HashMap<>();
        result.put("name","holy");
        result.put("family","shit signup");

        return result;
    }

    @PostMapping("/signup")
    public HashMap<String, String> postSignup(@RequestBody SignupRequestDTO signupRequestDTO){
        HashMap<String,String> result = accountService.signup(signupRequestDTO);

        return result;
    }
}

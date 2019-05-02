package org.dailystudio.springbootstudy.controller;


import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.AccountReqDto;
import org.dailystudio.springbootstudy.dto.AccountResDto;
import org.dailystudio.springbootstudy.dto.LogInReqDto;
import org.dailystudio.springbootstudy.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("api/signUp")
    public ResponseEntity<Boolean> SignUpAccount(@RequestBody AccountReqDto accountReqDto){

        boolean flag = accountService.SignUpAccount(accountReqDto);
        return ResponseEntity.ok(flag);
    }

    @GetMapping("api/signIn")
    public ResponseEntity<Boolean> SignInAccount(@RequestBody LogInReqDto logInReqDto){
        boolean flag = accountService.SignInAccount(logInReqDto);
        return ResponseEntity.ok(flag);
    }
}

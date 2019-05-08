package org.dailystudio.springbootstudy.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.AccountLoginReqDto;
import org.dailystudio.springbootstudy.dto.AccountResDto;
import org.dailystudio.springbootstudy.dto.AccountSignUpReqDto;
import org.dailystudio.springbootstudy.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")     //경로
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<AccountResDto> loginAccount(@RequestBody AccountLoginReqDto accountLoginReqDto) {
        AccountResDto accountResDto = accountService.login(accountLoginReqDto);
        return ResponseEntity.ok().body(accountResDto);
    }


    @PostMapping("/signUp")
    public ResponseEntity<Boolean> signAccount(@RequestBody AccountSignUpReqDto accountSignUpReqDto) {

        boolean flag = accountService.signUp(accountSignUpReqDto);
        return ResponseEntity.ok(flag);
    }


}

package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.AccountLoginReqDto;
import org.dailystudio.springbootstudy.dto.AccountResDto;
import org.dailystudio.springbootstudy.dto.AccountSaveReqDto;
import org.dailystudio.springbootstudy.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> signUp(@RequestBody AccountSaveReqDto accountSaveReqDto){

        boolean flag = accountService.singUp(accountSaveReqDto);

        return ResponseEntity.ok(flag);
    }

    @PostMapping("/login")
    public ResponseEntity<AccountResDto> login(@RequestBody AccountLoginReqDto accountLoginReqDto){
        AccountResDto accountResDto = accountService.login(accountLoginReqDto);
        return ResponseEntity.ok().body(accountResDto);
    }

}

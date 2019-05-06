package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.AccountReqDto;
import org.dailystudio.springbootstudy.dto.AccountSaveReqDto;
import org.dailystudio.springbootstudy.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")

public class AccountController {
    private final AccountService accountService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> signUp(@RequestBody AccountSaveReqDto accountSaveReqDto){
        boolean flag = accountService.signUp(accountSaveReqDto);
        return ResponseEntity.ok(flag);
    }
    /*
    @PostMapping("/login")
    public ResponseEntity<Boolean> logIn(@RequestBody AccountReqDto accountReqDto){

        return ResponseEntity.ok().build();
    }

     */


}

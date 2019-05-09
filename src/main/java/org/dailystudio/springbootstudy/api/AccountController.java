package org.dailystudio.springbootstudy.api;


import lombok.NoArgsConstructor;
import org.dailystudio.springbootstudy.domain.Account;
import org.dailystudio.springbootstudy.dto.AccountReq;
import org.dailystudio.springbootstudy.dto.LoginReq;
import org.dailystudio.springbootstudy.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/singUp")
    public ResponseEntity<Boolean> SignUp(
            @RequestBody AccountReq accountReq) {
        boolean flag = accountService.singUp(accountReq);
        return ResponseEntity.ok(flag);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginReq> login(
            @RequestBody LoginReq loginReq) throws NoSuchFieldException {
        accountService.login(loginReq);
        return ResponseEntity.ok(loginReq);
    }
}

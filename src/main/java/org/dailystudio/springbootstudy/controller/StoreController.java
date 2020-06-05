package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.auth.jwt.JwtAuth;
import org.dailystudio.springbootstudy.auth.jwt.JwtInfo;
import org.dailystudio.springbootstudy.repository.StoreRepository;
import org.dailystudio.springbootstudy.repository.querydsl.StoreRepositorySupport;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/test")
public class StoreController {

    private final StoreRepository storeRepository;
    private final StoreRepositorySupport storeRepositorySupport;

    @GetMapping("/get")
    @JwtAuth
    public void getMapping(@RequestHeader(JwtInfo.HEADER_NAME) String token) {

        System.out.println(token);
    }

    @PostMapping("/post")
    public void postMapping(int i) {

    }

}

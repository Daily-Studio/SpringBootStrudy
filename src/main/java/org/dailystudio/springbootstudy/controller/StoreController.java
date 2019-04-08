package org.dailystudio.springbootstudy.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.auth.jwt.JwtInfo;
import org.dailystudio.springbootstudy.repository.StoreRepository;
import org.dailystudio.springbootstudy.repository.querydsl.StoreRepositorySupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/test")
public class StoreController {

    private final StoreRepository storeRepository;
    private final StoreRepositorySupport storeRepositorySupport;
    private final HttpServletRequest request;

    @GetMapping("/get")
    @ApiImplicitParams({@ApiImplicitParam(name = "JWT", value = "JWT Token", required = true, dataType = "string", paramType = "header")})
    public void getMapping(){
        String token = request.getHeader(JwtInfo.HEADER_NAME);
        System.out.println(token);
    }

    @PostMapping("/post")
    public void postMapping(int i){

    }

}

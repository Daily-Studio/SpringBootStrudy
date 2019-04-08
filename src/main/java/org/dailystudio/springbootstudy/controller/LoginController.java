package org.dailystudio.springbootstudy.controller;

import org.dailystudio.springbootstudy.auth.jwt.JwtFactory;
import org.dailystudio.springbootstudy.auth.jwt.JwtInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/login")
public class LoginController {

    @PostMapping
    public String createToken(HttpServletResponse res, Long idx) {
        final String token = JwtFactory.create(idx);

        res.addHeader(JwtInfo.HEADER_NAME, token);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json");

        return token;
    }
}

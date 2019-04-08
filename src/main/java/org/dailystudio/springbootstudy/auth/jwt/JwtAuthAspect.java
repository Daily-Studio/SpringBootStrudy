package org.dailystudio.springbootstudy.auth.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@RequiredArgsConstructor
public class JwtAuthAspect {

    private final HttpServletRequest httpServletRequest;


    @Around("@annotation(org.dailystudio.springbootstudy.auth.jwt.JwtAuth)")
    public Object around(final ProceedingJoinPoint pjp) throws Throwable {
        final String token = httpServletRequest.getHeader(JwtInfo.HEADER_NAME);
        //토큰 존재 여부 확인
        if (token == null) {
            throw new RuntimeException("토큰없음.");
        }
        //토큰 검사
        if (!JwtFactory.isValid(token)) {
            throw new RuntimeException("유효성 작살.");
        }
        //토큰 해독
        final DecodedJWT decodedJWT = JwtFactory.decode(token);

        //토큰기반 디비에서 사용자 불러오기
        //
        //사용자 제대로됨?
//            if (user == null) return RES_RESPONSE_ENTITY;
        return pjp.proceed(pjp.getArgs());

    }
}
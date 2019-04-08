package org.dailystudio.springbootstudy.auth.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.dailystudio.springbootstudy.util.LogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@RequiredArgsConstructor
public class JwtAuthAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    private final HttpServletRequest httpServletRequest;


    @Around("@annotation(org.dailystudio.springbootstudy.auth.jwt.JwtAuth)")
    public Object validateJWT(final ProceedingJoinPoint pjp) throws Throwable {
        final String token = httpServletRequest.getHeader(JwtInfo.HEADER_NAME);
        //토큰 존재 여부 확인
        checkToken(token);
        //토큰 검사
        validateToken(token);
        //토큰 해독
        final DecodedJWT decodedJWT = JwtFactory.decode(token);
        logger.info("Authorized Token Access - " + decodedJWT.getClaim(JwtInfo.USER_IDX).asString());
        return pjp.proceed(pjp.getArgs());

    }

    private void checkToken(String token) {
        if (token == null) {
            logger.info("비어있는 토큰 접근.");
            throw new RuntimeException("토큰없음");
        }
    }

    private void validateToken(String token) {
        if (!JwtFactory.isValid(token)) {
            logger.info("유효하지 않은 토큰 접근.");
            throw new RuntimeException("유효성 작살.");
        }
    }
}
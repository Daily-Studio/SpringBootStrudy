package org.dailystudio.springbootstudy.util;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.dailystudio.springbootstudy.auth.jwt.JwtFactory;
import org.dailystudio.springbootstudy.auth.jwt.JwtInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/*
@Component로 이 클래스를 Bean으로 등록한다.
@Aspect로 해당 빈이 Aspect로 동작하게 한다.
@Order로 @Aspect 빈간의 우선순위를 정할 수 있다. 가장 낮을 레벨로 설정했다.
int값을 우선순위로 가지는데 값이 낮을 수록 우선순위가 높아진다.
 */
@Component
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private final HttpServletRequest httpServletRequest;

    public LogAspect(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
    /*

    이제 Advice 메소드를 작성할 수 있다.
    Advice 메소드는 빈이 호출에 끼어드는 시기를 정해줄 수 있다.
    @Before : 메소드 실행 전에 끼어든다.
    @After : 메소드 실행 후 끼어든다.
    @AfterThrowing : 메소드의 실행 후 값을 반환할 때 끼어든다.
    @Around : 실행 전후 어느 시점에든 끼어들 수 있다.

     */

    /*

    Advice메소드의 파라미터는 PointCut이라 불리우며
    끼어들 메소드의 범위를 지정해 줄 수 있다.

    execution(* org.dailystudio.spingbootstudy.*.*(..))
    앞에서 부터 각각의 의미를 설명하면

    * : 모든 리턴 타입을 의미한다.
    org.dailystudio.spingbootstudy : 특정 패키지
    * : 모든 클래스
    * : 모든 메소드
    (..) : 모든 Argument

    를 의미한다.

     */

    //    @Before("execution(* org.dailystudio.spingbootstudy.*.*(..))")
    //    public void doSomethingBefore(ProceedingJoinPoint joinPoint){
    //
    //    }
    @Pointcut("execution(public * org.dailystudio.springbootstudy.controller.StoreController.*(..))")
    public void controllerClassMethod() {
    }

    @Before(value = "controllerClassMethod()")
    public void logStartController(JoinPoint joinPoint) {
        logger.info("start - " + joinPoint.getSignature().getDeclaringTypeName() + " / " + joinPoint.getSignature().getName());
        String token = httpServletRequest.getHeader(JwtInfo.HEADER_NAME);
        if (!JwtFactory.isValid(token)) {
            throw new RuntimeException();
        } else {
            DecodedJWT decodedJWT = JwtFactory.decode(token);
            logger.info(decodedJWT.getClaims().toString());
            logger.info("Payload - " + decodedJWT.getPayload());
            String idx = decodedJWT.getClaim("idx").asString();
            logger.info("get Claim - " + idx);
        }
    }

    @After(value = "controllerClassMethod()")
    public void logEndController(JoinPoint joinPoint) {
        logger.info("finished - " + joinPoint.getSignature().getDeclaringTypeName() + " / " + joinPoint.getSignature().getName());
    }


}

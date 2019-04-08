package org.dailystudio.springbootstudy.auth.jwt;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface JwtAuth {
}

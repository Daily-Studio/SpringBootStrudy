package org.dailystudio.springbootstudy.auth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class JwtFactory {

    private static final LocalDateTime NOW = LocalDateTime.now();

    public static String create(final Long idx) {
        final Date expiredDate = Date.from(NOW.plusDays(JwtInfo.EXPIRES_LIMIT).toInstant(ZoneOffset.ofHours(9)));
        return create(idx, expiredDate);
    }

    public static String create(final Long idx, final Date expiredDate) throws JWTCreationException {
        return JWT.create()
                .withClaim(JwtInfo.USER_IDX, idx.toString())
                .withIssuer(JwtInfo.ISSUER)
                .withExpiresAt(expiredDate)
                .sign(JwtInfo.getAlgorithm());
    }

    public static Boolean isValid(final String token) {
        try {
            JWTVerifier jwtVerifier = JWT.require(JwtInfo.getAlgorithm()).build();
            jwtVerifier.verify(token);

            return true;
        } catch (JWTVerificationException verificationException) {

            return false;
        }
    }

    public static DecodedJWT decode(final String token) {
        try {
            return JWT.decode(token);
        } catch (JWTDecodeException decodeException) {
            return null;
        }
    }
}

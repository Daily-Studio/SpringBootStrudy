package org.dailystudio.springbootstudy.dto;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Member;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
public class MemberSaveReqDto {
    private String email;

    private String pass;

    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(this.email)
                .pass(passwordEncoder.encode(this.pass))
                .build();
    }
}

package org.dailystudio.springbootstudy.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "member")
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String pass;

    @Builder
    public Member(@NotNull String email, @NotNull String pass) {
        this.email = email;
        this.pass = pass;
    }
}

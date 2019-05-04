package org.dailystudio.springbootstudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ACCOUNT")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID")
    private Long id;

    @NotNull
    // 테이블에 이 key는 단일 값을 가져야 함!
    @Column(name="ACCOUNT_EMAIL", unique = true)
    private String email;

    @NotNull
    @Column(name="ACCOUNT_PASS", unique = true)
    private String password;

    @NotNull
    @Column(name="ACCOUNT_NAME", unique = true)
    private String name;

    @Builder
    public Account(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }

}

package org.dailystudio.springbootstudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ACCOUNT")
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID")
    private Long id;

    // 테이블에 이 key는 단일 값을 가져야 함!
    @Column(name="ACCOUNT_EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name="ACCOUNT_PASS", unique = true, nullable = false)
    private String password;

    @Column(name="ACCOUNT_NAME", unique = true, nullable = false)
    private String name;


    public Account(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }

}

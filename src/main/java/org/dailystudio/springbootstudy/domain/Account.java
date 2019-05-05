package org.dailystudio.springbootstudy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@Table(name = "account")
@Getter
public class Account {

    @Id //프라이머리 키
    @GeneratedValue(strategy = GenerationType.AUTO) //전략을 정해주는거
    @Column(name = "account_id") //데이터베이스에 저장되는이름
    private Long id;

    @Column(name = "account_email", unique = true, nullable =  false)
    private String email;

    @Column(name = "account_name", nullable =  false)
    private String name;

    @Column(name = "account_pass", nullable =  false)
    private String pass;

    public Account(String email, String name, String pass) {
        this.email = email;
        this.name = name;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

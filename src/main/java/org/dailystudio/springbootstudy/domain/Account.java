package org.dailystudio.springbootstudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID")
    private String id;

    @Column(name="ACCOUNT_EMAIL")
    private String email;

    @Column(name="ACCOUNT_PASSWORD")
    private String passwd;

    @Column(name="ACCOUNT_NAME")
    private String name;

    public Account(String email, String password, String name){
        this.email = email;
        this.passwd = password;
        this.name = name;
    }
}

package org.dailystudio.springbootstudy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
@Getter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(name= "ACCOUNT_EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "ACCOUNT_PASSWORD", nullable = false)
    private String password;

    @Column(name = "ACCOUNT_NAME", nullable=false)
    private String name;

    public Account(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }
}

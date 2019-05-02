package org.dailystudio.springbootstudy.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "account")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private String id;

    @NotNull
    private String email;
    private String pass;
    private String name;

    public Account(String pass, String email, String name){
        this.email = email;
        this.pass = pass;
        this.name = name;
    }
}

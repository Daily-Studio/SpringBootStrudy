package org.dailystudio.springbootstudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPass")
    private String userPass;

    @Column(name = "userPhone")
    private String userPhone;

    @Column(name = "userAuth")
    private String userAuth;

    @Builder
    public User(String userEmail, String userPass, String userName, String userPhone, String userAuth) {
        this.userEmail = userEmail;
        this.userAuth = userAuth;
        this.userName = userName;
        this.userPass = userPass;
        this.userPhone = userPhone;
    }

    public void setName(String name) {
        this.userName = name;
    }
}

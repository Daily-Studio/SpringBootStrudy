package org.dailystudio.springbootstudy.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dailystudio.springbootstudy.dto.user.UserNameReqDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany
    @JoinColumn(name = "userIdx")
    private List<UserImg> userImgs = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamIdx", insertable = false, updatable = false)
    @JsonManagedReference
    Team team;

    @Builder
    public User(String userEmail, String userPass, String userName, String userPhone, String userAuth) {
        this.userEmail = userEmail;
        this.userAuth = userAuth;
        this.userName = userName;
        this.userPass = userPass;
        this.userPhone = userPhone;
    }

    public void updateName(UserNameReqDto userNameReqDto) {
        this.userName = userNameReqDto.getUserName();
    }
}

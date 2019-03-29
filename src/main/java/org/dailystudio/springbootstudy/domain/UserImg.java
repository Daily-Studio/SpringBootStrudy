package org.dailystudio.springbootstudy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "userimg")
@NoArgsConstructor
public class UserImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userImgIdx;

    private Long userIdx;

    @Column
    private String userImgUrl = "default URL";

    public UserImg(User user) {
        this.userIdx = user.getUserIdx();
    }

    public UserImg(User user, String url) {
        this.userIdx = user.getUserIdx();
        this.userImgUrl = url;
    }

}

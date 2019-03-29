package org.dailystudio.springbootstudy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {
    private Long userIdx;
    private String userEmail;
    private String userName;
    private String userPass;
    private String userPhone;
    private String userAuth;
}

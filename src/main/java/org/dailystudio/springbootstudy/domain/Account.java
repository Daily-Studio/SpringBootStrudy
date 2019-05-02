package org.dailystudio.springbootstudy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// entity class 라고 함 이걸
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT")
@Getter
public class Account {

    @Id //primary key 를 의미함
    @GeneratedValue(strategy = GenerationType.AUTO) //id 값은 자동으로 생성해 되야하니 그걸 해주는거 GenerationType.AUTO 를 하면 디비에 알맞게 지정해준대
    @Column(name = "ACCOUNT_ID")
    public long id;

    @Column(name = "ACCOUNT_EMAIL", nullable = false) //unique = true 라는 조건을 주면 동일한 이메일을 가진 애들이 디비에 들어가는걸 방지하겠다는거임.
    //프라이머리 키는 아니지만 그래도 중복값은 존재하면 안되므로.
    public String email;

    @Column(name = "ACCOUNT_PASSWORD", nullable = false)
    public String password;

    @Column(name = "ACCOUNT_NAME", nullable = false)
    public String name;
}

//내장디비 들어가는 주소
//

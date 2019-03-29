package org.dailystudio.springbootstudy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamIdx")
    private Long teamIdx;

    @Column
    private String teamName;

    //@JoinColumn(name = "teamIdx")  //순환참조 문제가 발생한다.
    @OneToMany(mappedBy = "team")
    @JsonBackReference
    private List<User> users = new ArrayList<>();

}

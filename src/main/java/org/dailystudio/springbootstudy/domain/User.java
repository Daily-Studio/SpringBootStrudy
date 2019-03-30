package org.dailystudio.springbootstudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String pass;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public User(String email, String name, String pass, Team team){
        this.email=email;
        this.name=name;
        this.pass=pass;
        this.team=team;
    }
}

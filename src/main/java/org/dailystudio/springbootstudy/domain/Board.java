package org.dailystudio.springbootstudy.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOARD")
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String content;

    public String getContent() {
        return content;
    }

    public Board(@NotNull String content) {
        this.content = content;
    }
}

package org.dailystudio.springbootstudy.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clerk")
@Getter
public class Clerk {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clerk_id")
    private Long id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "store_id")
    private Store store;
}

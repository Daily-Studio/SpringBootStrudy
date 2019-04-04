package org.dailystudio.springbootstudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@NoArgsConstructor
public class Store {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @OneToMany(mappedBy = "store")
    private List<Clerk> clerks = new ArrayList<>();

    @Builder
    public Store(String name, String phone){
        this.name=name;
        this.phone=phone;
    }
}

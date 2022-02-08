package cus.study.jpa.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Team(String name) {
        this.name = name;
    }
}

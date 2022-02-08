package cus.study.jpa.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "member")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String name, Team team) {
        this.name = name;
        this.team = team;
    }
}

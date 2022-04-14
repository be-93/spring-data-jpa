package cus.study.jpa.application;

import cus.study.jpa.domain.Member;
import cus.study.jpa.domain.MemberRepository;
import cus.study.jpa.domain.Team;
import cus.study.jpa.domain.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TeamRepository teamRepository;

    @BeforeEach
    void setUp() {
        Team team = teamRepository.save(new Team("백엔드"));
        memberRepository.save(new Member("devA", team));
    }

    @Test
    public void noConstructor() {
        // given
        Member findMember = memberRepository.getByName("devA")
                .orElseThrow(IllegalAccessError::new);

        // when
        Team team = findMember.getTeam();

        log.info("findMember Member.getName() : {}", findMember.getName());
        log.info("team team.getName() : {}", team.getName());

        assertThat(findMember.getName()).isEqualTo("devA");
        assertThat(findMember.getTeam().getName()).isEqualTo("백엔드");
    }
}
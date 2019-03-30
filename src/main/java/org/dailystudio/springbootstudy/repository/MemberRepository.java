package org.dailystudio.springbootstudy.repository;


import org.dailystudio.springbootstudy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

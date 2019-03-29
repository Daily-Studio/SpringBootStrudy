package org.dailystudio.springbootstudy.repository;

import org.dailystudio.springbootstudy.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}

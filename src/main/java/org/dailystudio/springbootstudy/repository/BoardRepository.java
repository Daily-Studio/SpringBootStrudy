package org.dailystudio.springbootstudy.repository;

import org.dailystudio.springbootstudy.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

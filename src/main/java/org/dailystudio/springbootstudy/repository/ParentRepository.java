package org.dailystudio.springbootstudy.repository;

import org.dailystudio.springbootstudy.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}

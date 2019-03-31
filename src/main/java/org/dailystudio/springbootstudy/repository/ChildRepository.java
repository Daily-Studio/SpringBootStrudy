package org.dailystudio.springbootstudy.repository;

import org.dailystudio.springbootstudy.domain.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child,Long> {
}

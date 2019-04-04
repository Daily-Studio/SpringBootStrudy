package org.dailystudio.springbootstudy.repository;

import org.dailystudio.springbootstudy.domain.Clerk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClerkRespository extends JpaRepository<Clerk,Long> {
}

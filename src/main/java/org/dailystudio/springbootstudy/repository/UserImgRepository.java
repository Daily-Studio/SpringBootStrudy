package org.dailystudio.springbootstudy.repository;

import org.dailystudio.springbootstudy.domain.UserImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserImgRepository extends JpaRepository<UserImg, Long> {
}

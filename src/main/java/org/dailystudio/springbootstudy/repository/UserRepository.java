package org.dailystudio.springbootstudy.repository;


import org.dailystudio.springbootstudy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserIdx(Long idx);
}

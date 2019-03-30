package org.dailystudio.springbootstudy.repository;


import org.dailystudio.springbootstudy.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserIdx(Long idx);

//    @EntityGraph(attributePaths = "userImgs")
//    @Query("SELECT a FROM users a")
//    List<User> findAllEntityGraph();
}

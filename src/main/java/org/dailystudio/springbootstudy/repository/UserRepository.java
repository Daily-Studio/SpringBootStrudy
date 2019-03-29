package org.dailystudio.springbootstudy.repository;


import org.dailystudio.springbootstudy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserIdx(Long idx);

    @Modifying
    @Query("UPDATE User u SET u.userName = :name WHERE u.userIdx = :idx")
    void updateUserName(@Param("idx") Long userIdx, @Param("name") String userName);
}

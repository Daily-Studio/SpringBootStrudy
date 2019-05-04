package org.dailystudio.springbootstudy.repository;

import org.dailystudio.springbootstudy.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // String 자료형 email을 사용해서 database에서 Account를 가져옴.
    Account findByEmail(String email);
}

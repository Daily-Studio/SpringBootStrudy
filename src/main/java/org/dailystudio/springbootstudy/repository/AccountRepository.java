package org.dailystudio.springbootstudy.repository;

import org.dailystudio.springbootstudy.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String email);
}

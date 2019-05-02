package org.dailystudio.springbootstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.dailystudio.springbootstudy.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
    Account findByEmail(String Email);
}
package org.dailystudio.springbootstudy.repository;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String Email);

}

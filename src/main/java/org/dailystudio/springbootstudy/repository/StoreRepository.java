package org.dailystudio.springbootstudy.repository;

import org.dailystudio.springbootstudy.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
}

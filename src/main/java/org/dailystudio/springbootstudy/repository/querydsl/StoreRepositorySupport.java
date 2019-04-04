package org.dailystudio.springbootstudy.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.dailystudio.springbootstudy.domain.QClerk;
import org.dailystudio.springbootstudy.domain.QStore;
import org.dailystudio.springbootstudy.domain.Store;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.dailystudio.springbootstudy.domain.QStore.store;

@Repository
public class StoreRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public StoreRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(Store.class);
        this.jpaQueryFactory=jpaQueryFactory;
    }

    public List<Store> findByName(String name){
        return jpaQueryFactory
                .selectFrom(store)
                .where(store.name.eq(name))
                .fetch();
    }

    public List<Store> findAllEager(){
        QStore store = QStore.store;
        QClerk clerk = QClerk.clerk;

        return from(store)
                .leftJoin(store.clerks,clerk).fetchJoin()
                .distinct()
                .fetch();
    }
}

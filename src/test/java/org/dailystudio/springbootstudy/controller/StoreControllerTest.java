package org.dailystudio.springbootstudy.controller;

import org.dailystudio.springbootstudy.domain.Store;
import org.dailystudio.springbootstudy.repository.StoreRepository;
import org.dailystudio.springbootstudy.repository.querydsl.StoreRepositorySupport;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreControllerTest {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreRepositorySupport storeRepositorySupport;

    @After
    public void tearDown() throws Exception {
        storeRepository.deleteAllInBatch();
    }

    @Test
    public void 쿼리디에셀_작동테스트() {
        //given
        String name = "김밥천국";
        String phone = "010-1234-5678";

        String name1 = "천국김밥";
        String phone1 = "010-5678-1234";
        storeRepository.save(new Store(name, phone));
        storeRepository.save(new Store(name1, phone1));

        //when
        List<Store> stores = storeRepositorySupport.findByName(name);

        //then
        assertThat(stores.size()).isEqualTo(1);
        assertThat(stores.get(0).getName()).isEqualTo(name);
    }

}
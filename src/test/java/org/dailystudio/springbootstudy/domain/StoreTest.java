package org.dailystudio.springbootstudy.domain;

import org.dailystudio.springbootstudy.dto.ClerkNameDto;
import org.dailystudio.springbootstudy.repository.ClerkRespository;
import org.dailystudio.springbootstudy.repository.StoreRepository;
import org.dailystudio.springbootstudy.repository.querydsl.StoreRepositorySupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreTest {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ClerkRespository clerkRespository;

    @Autowired
    private StoreRepositorySupport storeRepositorySupport;


    @Before
    public void setUp() throws Exception {

    }

    @Test
    @Transactional
    public void 상점에서_점원들_불러오기_엔플러스일문제발생() {
        List<Store> stores = storeRepository.findAll();


        List<String> names = new ArrayList<>();

        for(Store store : stores){
            List<String> eachNames = store.getClerks()
                    .stream()
                    .map(Clerk::getName)
                    .collect(Collectors.toList());
            names.addAll(eachNames);
        }


        int size = names.size();

        assertThat(size).isEqualTo(360);
    }

    @Test
    @Transactional
    public void 상점에서_점원들_불러오기() {
        List<Store> stores = storeRepositorySupport.findAllEager();
//        Store store = storeRepository.getOne(1L);

        List<String> names = new ArrayList<>();

        for(Store store : stores){
            List<String> eachNames = store.getClerks()
                    .stream()
                    .map(Clerk::getName)
                    .collect(Collectors.toList());
            names.addAll(eachNames);
        }


        int size = names.size();

        assertThat(size).isEqualTo(360);
    }

    @After
    public void tearDown() throws Exception {
        clerkRespository.deleteAllInBatch();
        storeRepository.deleteAllInBatch();
    }
}
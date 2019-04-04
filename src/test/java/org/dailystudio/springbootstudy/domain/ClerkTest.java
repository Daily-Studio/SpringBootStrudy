package org.dailystudio.springbootstudy.domain;

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

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClerkTest {


    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreRepositorySupport storeRepositorySupport;

    @Autowired
    private ClerkRespository clerkRespository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void 모든_점원정보_가져오기() {
        List<Clerk> clerks = clerkRespository.findAll();
        int size = clerks.size();
        assertThat(size).isEqualTo(400);
    }

    @After
    public void tearDown() throws Exception {
        clerkRespository.deleteAllInBatch();
        storeRepository.deleteAllInBatch();
    }
}
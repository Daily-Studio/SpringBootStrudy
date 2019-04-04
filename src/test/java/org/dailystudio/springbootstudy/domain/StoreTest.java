package org.dailystudio.springbootstudy.domain;

import org.dailystudio.springbootstudy.repository.StoreRepository;
import org.dailystudio.springbootstudy.repository.querydsl.StoreRepositorySupport;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreTest {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreRepositorySupport storeRepositorySupport;


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }
}
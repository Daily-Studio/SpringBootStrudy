package org.dailystudio.springbootstudy.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceTest {

    private static final String DEFAULT_CONTENT = "default";

    @Autowired
    private BoardService boardService;

    private List<String> contents;

    @After
    public void tearDown() throws Exception {
        log.info(contents.toString());
    }

    @Test
    public void 캐시0() {
        boardService.saveContent(DEFAULT_CONTENT);
        contents = boardService.fetchContents();
    }

    @Test
    public void 캐시1() {
        contents = boardService.fetchContents();
    }

    @Test
    public void 캐시2() {
        contents = boardService.fetchContents();
    }

    @Test
    public void 캐시3() {
        boardService.saveContent("캐시3");
        contents = boardService.fetchContents();
    }

    @Test
    public void 캐시4() {
        contents = boardService.fetchContents();
    }
}
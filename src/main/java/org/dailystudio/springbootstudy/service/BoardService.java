package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dailystudio.springbootstudy.domain.Board;
import org.dailystudio.springbootstudy.repository.BoardRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @CacheEvict(value = "contents", allEntries = true)
    public void saveContent(String content) {
        Board board = new Board(content);
        boardRepository.save(board);
    }

    @Cacheable(value = "contents")
    public List<String> fetchContents() {
        logCache();
        return boardRepository.findAll().stream()
                .map(Board::getContent)
                .collect(Collectors.toList());
    }

    private void logCache() {
        log.info("new cache.");
    }
}

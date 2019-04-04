package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.repository.StoreRepository;
import org.dailystudio.springbootstudy.repository.querydsl.StoreRepositorySupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/test")
public class StoreController {

    private final StoreRepository storeRepository;
    private final StoreRepositorySupport storeRepositorySupport;

}

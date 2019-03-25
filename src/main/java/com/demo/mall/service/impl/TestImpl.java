package com.demo.mall.service.impl;

import com.demo.mall.entities.Test;
import com.demo.mall.mapper.TestDao;
import com.demo.mall.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestImpl implements TestService {

    @Resource
    private TestDao testDao;

    @Override
    public Test queryTest(int id) {
        return testDao.queryTest(id);
    }
}

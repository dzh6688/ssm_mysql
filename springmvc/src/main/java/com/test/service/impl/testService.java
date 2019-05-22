package com.test.service.impl;

import com.test.dao.TestMapper;
import com.test.model.User;
import com.test.service.ItestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testService implements ItestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public User test() {
       return testMapper.select();
    }
}

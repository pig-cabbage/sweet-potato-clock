package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.entity.GoalComplete;
import com.sweetpotatoclock.service.GoalCompleteService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoalCompleteServiceImplTest {

    @Autowired
    private GoalCompleteService goalCompleteService;
    @Test
    @Ignore
    public void queryGoalByUserId() {
        List<GoalComplete> list=goalCompleteService.queryGoalByUserId("1");
        assertEquals(1,list.size());
        System.out.print(list.get(0).toString());
    }
}
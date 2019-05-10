package com.sweetpotatoclock.web;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoalListControllerTest {

    @Autowired
    private GoalListController goalListController;
    @Ignore
    @Test
    public void displayGoal() {
        Map<String,Object> map = goalListController.displayGoal("1");
        assertEquals(1,map.size());
        System.out.print(map.values().toString());
    }
}
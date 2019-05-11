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
public class RankListControllerTest {
    @Autowired
    private RankListController rankListController;

    @Test
    public void getrankingroupday() {
        Map<String,Object> returnmap=rankListController.getrankingroupday(9);
        assertEquals(2,returnmap.size());
    }

    @Test
    @Ignore
    public void getrankingroupweek() {
    }
}
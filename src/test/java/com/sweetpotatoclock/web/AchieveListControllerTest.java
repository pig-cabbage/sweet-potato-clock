package com.sweetpotatoclock.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AchieveListControllerTest {

    @Autowired
    private AchieveListController achieveListController;

    @Test
    public void getAchieveListByUserId() {
        Map<String,Object>returnmap =achieveListController.getAchieveListByUserId("1");
        assertEquals(1,returnmap.size());

    }
}
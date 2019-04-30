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
public class GroupControllerTest {

    @Autowired
    GroupController groupController;

    @Test
    public void getGroupByGroupId() {
        Map<String,Object> groupMap = groupController.getGroupByGroupId(1);
        System.out.print(groupMap.toString());
    }
}
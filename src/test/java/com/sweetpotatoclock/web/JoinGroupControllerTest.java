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
public class JoinGroupControllerTest {
    @Autowired
    private JoinGroupController joinGroupController;


    @Test
    public void joinGroup() {
        Integer groupId=7;
        String userId="1";
        Map<String,Integer> res=joinGroupController.joinGroup(groupId,userId);
        System.out.print(res);
    }
}
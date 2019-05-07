package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateGroupControllerTest {

    @Autowired
    private CreateGroupController createGroupController;

    @Test
    public void createGroupTest() {
        Group group = new Group();
        group.setTag("英语");
        group.setDays(7);
        group.setMinutes(30);
        group.setCaptainId("1");
        group.setIsPrivate((byte) 0);
        Map<String,Object> result = new HashMap<>();
        result = createGroupController.createGroup(group);
        System.out.print(result);
    }
}
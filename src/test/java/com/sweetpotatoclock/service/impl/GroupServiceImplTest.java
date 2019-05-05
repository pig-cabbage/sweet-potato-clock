package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.GroupMapper;
import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupServiceImplTest {

    @Autowired
    GroupService groupService;

    @Test
    public void addGroup() {
        Group group = new Group();
        group.setTag("英语");
        group.setDays(7);
        group.setMinutes(30);
        group.setCaptainId("1");
        group.setIsPrivate((byte) 0);
        groupService.addGroup(group);
    }
}
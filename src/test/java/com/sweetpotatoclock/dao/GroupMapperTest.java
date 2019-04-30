package com.sweetpotatoclock.dao;

import com.sweetpotatoclock.entity.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupMapperTest {
    @Autowired
    private GroupMapper groupMapper;

    @Test
    public void selectByPrimaryKey(){
        Group group=groupMapper.selectByPrimaryKey(1);
        System.out.print(group.toString());
    }

}
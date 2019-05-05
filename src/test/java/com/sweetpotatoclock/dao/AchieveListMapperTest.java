package com.sweetpotatoclock.dao;

import com.sweetpotatoclock.entity.AchieveList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AchieveListMapperTest {
    @Autowired
    private  AchieveListMapper achieveListMapper;
    @Test
    public void selectAchieveListByUserId() {
        List<AchieveList> returnlist=achieveListMapper.selectAchieveListByUserId("1");
        assertEquals(2,returnlist.size());
        System.out.print(returnlist.size());
    }
}
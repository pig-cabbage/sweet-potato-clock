package com.sweetpotatoclock.dao;

import com.sweetpotatoclock.entity.AchieveInfo;
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
public class AchieveInfoMapperTest {
    @Autowired
    private AchieveInfoMapper achieveInfoMapper;

    @Ignore
    @Test
    public void selectAchieveNameByAchieveId() {
        String result = achieveInfoMapper.selectByPrimaryKey(1).getAchieveName();

        System.out.print(result);
    }
    @Ignore
    @Test
    public void selectAll() {
        List<AchieveInfo> returnlist=achieveInfoMapper.selectAll();
        assertEquals(2,returnlist.size());
    }
}
package com.sweetpotatoclock.dao;

import com.sweetpotatoclock.entity.UserInformation;
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
public class UserInformationMapperTest {
    @Autowired
    private UserInformationMapper userInformationMapper;
    @Test
    @Ignore
    public void deleteByPrimaryKey() {
    }

    @Test
    @Ignore
    public void insert() {
    }

    @Test
    @Ignore
    public void selectByPrimaryKey() {

    }

    @Test
    public void selectAll() {
        List<UserInformation> userInformationList= userInformationMapper.selectAll();
        assertEquals(1,userInformationList.size());
    }

    @Test
    @Ignore
    public void updateByPrimaryKey() {
    }
}
package com.sweetpotatoclock.dao;

import com.sweetpotatoclock.entity.UserInformation;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
    @Ignore
    @Test
    public void selectByPrimaryKey() {
        UserInformation userInformation = userInformationMapper.selectByPrimaryKey("2");
        System.out.print(userInformation.toString());
    }

    @Ignore
    @Test
    public void selectAll() {
        List<UserInformation> userInformationList = userInformationMapper.selectAll();
        assertEquals(1, userInformationList.size());
    }

    @Test
    @Ignore
    public void updateByPrimaryKey() {
    }

}
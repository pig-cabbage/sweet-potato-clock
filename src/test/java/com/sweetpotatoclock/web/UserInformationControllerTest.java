package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.UserInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInformationControllerTest {

    @Autowired
    private UserInformationController userInformationController;
    @Test
    public void getUserInformationByUserId() {
        Map<String,Object> map= userInformationController.getUserInformationByUserId("1");
        assertEquals(1,map.size());
        System.out.print(map.values().toString());
    }

}
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
public class MakeTreesControllerTest {

    @Autowired
    private  MakeTreesController makeTreesController;
    @Test
    public void getMakeTreesByUserId() {
        Map<String,Object> map=makeTreesController.getMakeTreesByUserId("oAYW15Aei5xRSbr0V-rEllEMsPt8");
        assertEquals(1,map.size());
    }
}
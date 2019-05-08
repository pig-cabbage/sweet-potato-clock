package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.Record;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordControllerTest {

    @Autowired
    private RecordController recordController;

    @Test
    public void completeGoal() {
        Record record=new Record();
        record.setMinutes(30);
        record.setGroupId(7);
        record.setUserId("1");
        System.out.print(record.getUserId()+"\n");
        Map<String,Object> res=recordController.completeGoal(record);
        System.out.print(res);
    }
}
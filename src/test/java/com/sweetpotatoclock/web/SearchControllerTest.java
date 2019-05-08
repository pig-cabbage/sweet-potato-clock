package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchControllerTest {


        @Autowired
        private  SearchController searchController;

        @Test
        public void getGroupListByGroupName( ){
            Map<String,Object> map=searchController.searchByGroupName("新小组");

            assertEquals(1,map.size());
        }

}
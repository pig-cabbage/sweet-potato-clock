package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.MakeTrees;
import com.sweetpotatoclock.service.MakeTreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ranktrees")
public class RankTreesController {
    @Autowired
    private MakeTreesService makeTreesService;


    @RequestMapping(value = "/ranktrees",method = RequestMethod.GET)
    public Map<String,Object> rankTrees(){
        Map<String,Object>returnMap=new HashMap<String,Object>();

        returnMap.put("list",makeTreesService.rankTrees());
        returnMap.put("nameList",makeTreesService.returnNameList());
            return returnMap;
    }
}

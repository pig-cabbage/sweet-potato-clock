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
        makeTreesService.rankTrees();
        List<MakeTrees>list=makeTreesService.getList();
        List<String>nameList=makeTreesService.returnNameList();
        returnMap.put("list",list);
        returnMap.put("nameList",nameList);
            return returnMap;
    }
}

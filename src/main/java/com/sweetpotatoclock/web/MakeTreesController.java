package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.MakeTrees;
import com.sweetpotatoclock.service.MakeTreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/maketrees")
public class MakeTreesController {
    @Autowired
    private MakeTreesService makeTreesService;

    @RequestMapping(value = "/maketrees" ,method = RequestMethod.GET)
    public Map<String,Object>getMakeTreesByUserId(@RequestParam("userid") String userId){
        Map<String,Object>result=new HashMap<String,Object>();
        result.put("list",makeTreesService.rankTrees());
        result.put("namelist",makeTreesService.returnNameList());
        return result;
    }
}

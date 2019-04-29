package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.AchieveList;
import com.sweetpotatoclock.service.AchieveListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/achievelist")
public class AchieveListController {
    @Autowired
    private AchieveListService achieveListService;

    /**
     * 通过userId获取对应用户获得的称号信息
     *
     * @return
     */
    @RequestMapping(value = "/getachievelistbyuserid",method = RequestMethod.GET)
    public Map<String,Object>getAchieveListByUserId(String userId){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        //获取对应用户的成就列表
        List<String> achieveList=achieveListService.getAchieveListInformationByUserId(userId);
        modelMap.put("achieveList",achieveList);
        return modelMap;
    }

}

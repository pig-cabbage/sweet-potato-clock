package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.RankBetweenGroup;
import com.sweetpotatoclock.entity.RankInGroup;
import com.sweetpotatoclock.service.RankBetweenGroupService;
import com.sweetpotatoclock.service.RankInGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ranklist")
public class RankListController {
    @Autowired
    private RankInGroupService rankInGroupService;

    @Autowired
    private RankBetweenGroupService rankBetweenGroupService;


    /**
     * 获取组内排行（每日）
     *
     * @return
     */
    @RequestMapping(value = "/getrankingroupday", method = RequestMethod.GET)
    public Map<String, Object> getrankingroupday(@RequestParam("groupid") Integer groupId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RankInGroup> list = new ArrayList<>();
        rankInGroupService.getRankInGroupListByGroupId(groupId);
        rankInGroupService.rankByDayMinutes();
        list = rankInGroupService.getList();
        List<String>nameList=rankInGroupService.returnNameList();
        modelMap.put("list", list);
        modelMap.put("nameList",nameList);
        System.out.println(nameList.toString());
        System.out.println(list.toString());
        return modelMap;

    }

    /**
     * 获取组内排行（每周）
     *
     * @return
     */
    @RequestMapping(value = "/getrankingroupweek", method = RequestMethod.GET)
    public Map<String, Object> getrankingroupweek(@RequestParam("groupid") Integer groupId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RankInGroup> list = new ArrayList<>();
        rankInGroupService.getRankInGroupListByGroupId(groupId);
        rankInGroupService.rankByWeekMinutes();
        list = rankInGroupService.getList();
        List<String>nameList=rankInGroupService.returnNameList();
        modelMap.put("list", list);
        modelMap.put("nameList",nameList);
        System.out.println(nameList.toString());
        System.out.println(list.toString());
        return modelMap;
    }


}

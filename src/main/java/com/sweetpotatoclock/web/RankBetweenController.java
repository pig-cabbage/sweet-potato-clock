package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.RankBetweenGroup;
import com.sweetpotatoclock.service.RankBetweenGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/newranklist")
public class RankBetweenController {
    @Autowired
    private RankBetweenGroupService rankBetweenGroupService;

    /**
     * 获取组间排行（每日）
     *
     * @return
     */
    @RequestMapping(value = "/getrankbetweengroupday", method = RequestMethod.GET)
    public Map<String, Object> getrankbetweengroupday( ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RankBetweenGroup> list = new ArrayList<>();
        rankBetweenGroupService.getRankBetweenGroupList();
        rankBetweenGroupService.rankByDayAverageMinutes();
        list = rankBetweenGroupService.getList();
        List<String>nameList=rankBetweenGroupService.returnNameList();
        modelMap.put("list", list);
        modelMap.put("nameList",nameList);
        return modelMap;

    }

    /**
     * 获取组间排行（每周）
     *
     * @return
     */
    @RequestMapping(value = "/getrankbetweengroupweek", method = RequestMethod.GET)
    public Map<String, Object> getrankbetweengroupweek() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RankBetweenGroup> list = new ArrayList<>();
        rankBetweenGroupService.getRankBetweenGroupList();
        rankBetweenGroupService.rankByWeekAverageMinutes();
        list = rankBetweenGroupService.getList();
        List<String>nameList=rankBetweenGroupService.returnNameList();
        modelMap.put("list", list);
        modelMap.put("nameList",nameList);
        return modelMap;

    }
}

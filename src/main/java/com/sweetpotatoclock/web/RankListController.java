package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.RankInGroup;
import com.sweetpotatoclock.service.RankBetweenGroupService;
import com.sweetpotatoclock.service.RankInGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
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
    private Map<String, Object> getrankingroupday(Integer groupId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RankInGroup> list = new ArrayList<>();
        rankInGroupService.getRankInGroupListByGroupId(groupId);
        rankInGroupService.rankByDayMinutes();
        list = rankInGroupService.getList();
        modelMap.put("list", list);
        return modelMap;

    }

    /**
     * 获取组内排行（每周）
     *
     * @return
     */
    @RequestMapping(value = "/getrankingroupweek", method = RequestMethod.GET)
    private Map<String, Object> getrankingroupweek(Integer groupId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RankInGroup> list = new ArrayList<>();
        rankInGroupService.getRankInGroupListByGroupId(groupId);
        rankInGroupService.rankByWeekMinutes();
        list = rankInGroupService.getList();
        modelMap.put("list", list);
        return modelMap;
    }

    /**
     * 获取组间排行（每日）
     *
     * @return
     */
    @RequestMapping(value = "/getrankbetweengroupday", method = RequestMethod.GET)
    private Map<String, Object> getrankbetweengroupday(Integer groupId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RankInGroup> list = new ArrayList<>();
        rankBetweenGroupService.getRankBetweenGroupList();
        rankBetweenGroupService.rankByDayAverageMinutes();
        list = rankInGroupService.getList();
        modelMap.put("list", list);
        return modelMap;

    }

    /**
     * 获取组间排行（每周）
     *
     * @return
     */
    @RequestMapping(value = "/getrankbetweengroupweek", method = RequestMethod.GET)
    private Map<String, Object> getrankbetweengroupweek(Integer groupId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RankInGroup> list = new ArrayList<>();
        rankBetweenGroupService.getRankBetweenGroupList();
        rankBetweenGroupService.rankByWeekAverageMinutes();
        list = rankInGroupService.getList();
        modelMap.put("list", list);
        return modelMap;

    }
}

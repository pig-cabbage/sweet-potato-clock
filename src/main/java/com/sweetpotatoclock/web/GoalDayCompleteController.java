package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.GoalDayComplete;
import com.sweetpotatoclock.service.GoalDayCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goaldaycomplete")
public class GoalDayCompleteController {
    @Autowired
    private GoalDayCompleteService goalDayCompleteService;

    /**
     * 根据userId获取GoalDayCompltete列表信息
     *
     * @return
     */
    @RequestMapping(value = "/getgoaldaycompletelistbyuserid", method = RequestMethod.GET)
    private Map<String, Object> getgoaldatecompletelistbyuserid(@RequestParam("userid") String userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<GoalDayComplete> list = new ArrayList<>();
        //获取得到的列表
        list = goalDayCompleteService.getGoalDayCompleteByUserId(userId);
        modelMap.put("goaldaycompletelist", list);
        return modelMap;
    }
}

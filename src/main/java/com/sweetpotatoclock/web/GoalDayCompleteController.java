package com.sweetpotatoclock.web;

import com.sweetpotatoclock.dao.GoalCompleteMapper;
import com.sweetpotatoclock.entity.GoalDayComplete;
import com.sweetpotatoclock.service.GoalCompleteService;
import com.sweetpotatoclock.service.GoalDayCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    private GoalCompleteService goalCompleteService;

    /**
     * 根据userId获取GoalDayCompltete列表信息
     *
     * @return
     */
    @RequestMapping(value = "/getgoaldaycompletelistbyuserid", method = RequestMethod.GET)
    public Map<String, Object> getgoaldatecompletelistbyuserid(@RequestParam("userid") String userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<GoalDayComplete> list = new ArrayList<>();
        //获取得到的列表
        list = goalDayCompleteService.getGoalDayCompleteByUserId(userId);
        modelMap.put("goaldaycompletelist", list);
        return modelMap;
    }

    @RequestMapping(value = "/goalDayCompltete",method = RequestMethod.POST)
    public Map<String,Object> addGoalDayComplete(@RequestBody GoalDayComplete goalDayComplete){
        Map<String,Object> result = new HashMap<>();
        if(goalDayCompleteService.addGoalDayComplete(goalDayComplete)){
            goalCompleteService.deleteGoalComplete(goalDayComplete.getGroupId(),goalDayComplete.getUserId());
            result.put("success",1);
            return result;
        }
        result.put("success",0);
        return result;
    }
}

package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.GoalComplete;
import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.service.GoalCompleteService;
import com.sweetpotatoclock.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goalcomplete")
public class GoalListController {
    @Autowired
    private GoalCompleteService goalCompleteService;
    @Autowired
    private GroupService groupService;
    /**
     * 根据userId查找对应的目标
     * @param userId
     * @return
     */
    @RequestMapping("/displaygoal")
    public Map<String, Object> displayGoal (String userId){
        Map<String,Object> returnMap=new HashMap<>();
        List<GoalComplete> goalList= goalCompleteService.queryGoalByUserId(userId);
        List<Group> groupList = new ArrayList<>();
        for(int i=0;i<goalList.size();i++){
            Group item = groupService.getGroupByGroupId(goalList.get(i).getGroupId());
            groupList.add(item);
        }
        returnMap.put("groupList",groupList);
        returnMap.put("goalList",goalList);
        return returnMap;
    }

}

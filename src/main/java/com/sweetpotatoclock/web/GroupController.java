package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.GoalComplete;
import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.service.GoalCompleteService;
import com.sweetpotatoclock.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("group")
@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private GoalCompleteService goalCompleteService;

    /**
     * 通过groupId查找对应的Group信息
     * @param groupId
     * @return
     */
    @RequestMapping("getgroupbygroupid")
    public Map<String,Object> getGroupByGroupId(@RequestParam("groupid") Integer groupId){
        Map<String,Object> result=new HashMap<>();
        Group group = groupService.getGroupByGroupId(groupId);
        List<GoalComplete> goalCompleteList = goalCompleteService.queryGoalByGroupId(groupId);
        result.put("groupInfo",group);
        result.put("groupMember",goalCompleteList);
        return result;
    }
}

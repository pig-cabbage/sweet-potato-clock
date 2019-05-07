package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.GoalComplete;
import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.entity.UserInformation;
import com.sweetpotatoclock.service.GoalCompleteService;
import com.sweetpotatoclock.service.GroupService;
import com.sweetpotatoclock.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    private UserInformationService userInformationService;

    /**
     * 通过groupId查找对应的Group信息
     * @param groupId
     * @return
     */
    @RequestMapping("getgroupbygroupid")
    public Map<String,Object> getGroupByGroupId(@RequestParam("groupid") Integer groupId, @RequestParam("userid") String userId){
        Map<String,Object> result=new HashMap<>();
        Group group = groupService.getGroupByGroupId(groupId);
        List<GoalComplete> goalCompleteList = goalCompleteService.queryGoalByGroupId(groupId);
        UserInformation userInformation = userInformationService.getUserInformationByUserId(group.getCaptainId());
        List<String> memberName=new ArrayList<>();
        int isMember=0;
        //System.out.print(userId+"\n");
        for(int i=0;i<goalCompleteList.size();i++){
            //获取对应userId的UserInformation的nickName及其Id
            memberName.add(userInformationService.getUserInformationByUserId(goalCompleteList.get(i).getUserId()).getUserNickname());
            System.out.print(goalCompleteList.get(i).getUserId()+"\n");
            if(userId.equals(goalCompleteList.get(i).getUserId())){
                isMember=1;
            }
        }
        result.put("groupInfo",group);
        result.put("groupMember",memberName);
        result.put("isGroupMember",isMember);
        result.put("captain",userInformation.getUserNickname());
        return result;
    }

    @RequestMapping("findgroupbyconditions")
    public Map<String,Object> findGroupByConditions(@RequestParam("tag") String tag,@RequestParam("minutes") Integer minutes,@RequestParam("days")Integer days){
        Map<String,Object> result = new HashMap<>();
        result.put("groupListByConditions",groupService.getGroupByCondition(tag,minutes,days));
        return result;
    }


}


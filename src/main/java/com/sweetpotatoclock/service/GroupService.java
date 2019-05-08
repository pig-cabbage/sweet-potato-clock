package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.Group;

import java.util.List;


public interface GroupService {

    Group getGroupByGroupId(Integer groupId);

    List<Group> getGroupByCondition(String tag,Integer minutes,Integer days);

    Boolean addNewGroup(Group group);

    List<Group> getAllGroup();

    Group updateGroupMemberNumber(Integer groupId);
}

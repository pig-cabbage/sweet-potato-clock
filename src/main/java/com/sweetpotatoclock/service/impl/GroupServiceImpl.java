package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.GroupMapper;
import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public Group getGroupByGroupId(Integer groupId) {
        return groupMapper.selectByPrimaryKey(groupId);
    }
}

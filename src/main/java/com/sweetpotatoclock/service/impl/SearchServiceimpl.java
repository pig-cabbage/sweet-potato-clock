package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.GroupMapper;
import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceimpl implements SearchService {
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public List<Group> searchGroupByGroupName(String groupName){
        List<Group>result=new ArrayList<>();
        List<Group>list_1=groupMapper.selectAll();
        for(int i=0;i<list_1.size();++i){
            Group item=list_1.get(i);
            if(item.getGroupName().equals(groupName)&&item.getIsPrivate()==0){
                result.add(item);
            }
        }

        return result;
    }
}

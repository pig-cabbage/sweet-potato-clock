package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.Group;

import java.util.List;

public interface SearchService {

    List<Group> searchGroupByGroupName(String groupName);

}

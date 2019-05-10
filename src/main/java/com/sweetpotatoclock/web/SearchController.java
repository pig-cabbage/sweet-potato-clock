package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.service.SearchService;
import com.sweetpotatoclock.service.impl.SearchServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @RequestMapping(value="/searchbygroupname")
    public Map<String,Object> searchByGroupName(@RequestParam("groupName") String groupName){
        Map<String, Object> modelMap =new HashMap<>();

        modelMap.put("groupList", searchService.searchGroupByGroupName(groupName));
        return modelMap;
    }

}

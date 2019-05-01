package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.RankInGroup;
import com.sweetpotatoclock.entity.Record;
import com.sweetpotatoclock.service.RankBetweenGroupService;
import com.sweetpotatoclock.service.RankInGroupService;
import com.sweetpotatoclock.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("record")
public class RecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private RankInGroupService rankInGroupService;
    @Autowired
    private RankBetweenGroupService rankBetweenGroupService;
    //暂未完成
    @RequestMapping("completegoal")
    public Map<String,Object> completeGoal(@RequestBody Record record){
        if(recordService.addRecord(record)==true){
            try {
                RankInGroup rankInGroup = new RankInGroup();
                Integer dayMinutes=record.getMinutes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

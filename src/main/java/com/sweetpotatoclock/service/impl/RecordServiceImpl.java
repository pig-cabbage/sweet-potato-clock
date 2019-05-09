package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.RecordMapper;
import com.sweetpotatoclock.entity.Record;
import com.sweetpotatoclock.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public Boolean addRecord(Record record) {
        java.util.Date date = new  Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        record.setDate(date1);
        try {
            if(recordMapper.insert(record)==1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteRecord(Integer groupId) {

        if(recordMapper.deleteByGroupId(groupId)==1){
            return true;
        }
        return false;
    }

    @Override
    public List<Record> getRecordByUserId(String userId) {
        List<Record> allRecord=recordMapper.selectAll();
        List<Record> recordList=new ArrayList<>();
        //倒序添加元素保证时间靠后的在前
        try {
            for(int i=allRecord.size();i>0;i--){
                if(allRecord.get(i-1).getUserId().equals(userId)){
                    recordList.add(allRecord.get(i-1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordList;
    }
}

package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.RecordMapper;
import com.sweetpotatoclock.entity.Record;
import com.sweetpotatoclock.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}

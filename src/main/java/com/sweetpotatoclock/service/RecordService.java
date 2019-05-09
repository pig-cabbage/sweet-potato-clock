package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.Record;

import java.util.List;

public interface RecordService {

    Boolean addRecord(Record record);

    Boolean deleteRecord(Integer groupId);

    List<Record> getRecordByUserId(String userId);
}

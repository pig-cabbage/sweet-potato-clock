package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.Record;

public interface RecordService {

    Boolean addRecord(Record record);

    Boolean deleteRecord(Integer groupId);
}

package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.RankBetweenGroupMapper;
import com.sweetpotatoclock.dao.RankInGroupMapper;
import com.sweetpotatoclock.entity.RankBetweenGroup;
import com.sweetpotatoclock.service.ClearDayRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@EnableScheduling
@EnableAsync
public class ClearDayRankServiceimpl  implements ClearDayRankService{
    @Autowired
    private RankInGroupMapper rankInGroupMapper;
    @Autowired
    private RankBetweenGroupMapper rankBetweenGroupMapper;

    /**
     * 组内排行清空日榜
     *
     *
     */
    @Async
    @Scheduled(cron="0 0 0 ? * *")
    public void clearDayRecordInGroup(){
        rankInGroupMapper.clearDayMinutes();
    }

    /**
     * 组间排行清空日榜
     *
     *
     */
    @Async
    @Scheduled(cron="0 0 0 ? * *")
    public void clearDayRecordBetweenGroup(){
        rankBetweenGroupMapper.clearDayAverageMinutes();
    }
}
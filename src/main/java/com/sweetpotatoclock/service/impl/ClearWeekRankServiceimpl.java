package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.RankBetweenGroupMapper;
import com.sweetpotatoclock.dao.RankInGroupMapper;
import com.sweetpotatoclock.service.ClearWeekRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableScheduling
@Service
@EnableAsync
public class ClearWeekRankServiceimpl implements ClearWeekRankService {
    @Autowired
    private RankInGroupMapper rankInGroupMapper;
    @Autowired
    private RankBetweenGroupMapper rankBetweenGroupMapper;
    /**
     * 组内排行清空周榜
     *
     *
     */
    @Async
    @Scheduled(cron = "0 0 0 ? * MON")
    public  void clearWeekRecordInGroup(){
        rankInGroupMapper.clearWeekMinutes();;
    }

    /**
     * 组间排行清空周榜
     *
     *
     */
    @Async
    @Scheduled(cron = "0 0 0 ? * MON")
    public void clearWeekRecordBetweenGroup() {
        rankBetweenGroupMapper.clearWeekAverageMinutes();
    }

}

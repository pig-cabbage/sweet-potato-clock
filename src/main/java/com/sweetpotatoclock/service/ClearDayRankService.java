package com.sweetpotatoclock.service;

public interface ClearDayRankService {

    /**
     * 组内排行清空日榜
     *
     *
     */
    void clearDayRecordInGroup();

    /**
     * 组间排行清空日榜
     *
     *
     */
    void clearDayRecordBetweenGroup();

    /**
     * 将是否打卡重置为0（未打卡）
     *
     *
     */
   void clearIsClocked();
}

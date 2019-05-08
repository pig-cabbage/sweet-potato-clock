package com.sweetpotatoclock.service;

public interface BuyTreesService {
    /**
     * 根据购买的树木量来扣除用户的积分
     *
     *
     */
    int buyTrees(String userId, int number);
}

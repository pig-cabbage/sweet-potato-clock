package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.MakeTrees;

public interface MakeTreesService {
    /**
     * 修改树木页的信息
     *
     * @return
     */
    void modify(String userId,int number);
}

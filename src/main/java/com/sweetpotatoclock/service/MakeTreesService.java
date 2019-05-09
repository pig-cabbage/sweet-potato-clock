package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.MakeTrees;

public interface MakeTreesService {
    /**
     * 修改树木页的信息
     *
     * @return
     */
    void modify(String userId,int number);
    /**
     * 根据user_id获取树木页的信息
     *
     * @return
     */
    MakeTrees getMakeTreesByUserId(String userId);
}

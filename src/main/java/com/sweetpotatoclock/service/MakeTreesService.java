package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.MakeTrees;

import java.util.List;

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
    /**
     * 对树木页按照树木面积进行排序
     *
     * @return
     */
    void rankTrees();

    List<String> returnNameList();

    List<MakeTrees>getList();
}

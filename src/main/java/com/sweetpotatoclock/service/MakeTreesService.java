package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.MakeTrees;

public interface MakeTreesService {
    /**
     * 通过区域userId获取树木页信息
     *
     * @return
     */
    MakeTrees getMakeTreesByUserId(String userId);
}

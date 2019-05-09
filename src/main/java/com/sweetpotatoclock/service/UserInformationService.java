package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.UserInformation;

import java.util.List;

public interface UserInformationService {

    /**
     * 通过userID获取用户信息
     *
     * @return
     */
    UserInformation getUserInformationByUserId(String userID);

    int addUserInformationInLogin(String userId,String nickName,String avatarUrl);

    int updateUserScoreInJoin(String userId,Integer joinScore);

    Boolean updateUserScoreInComplete(String userId,Integer obtainScore);

    Boolean updateUserScoreInClock(String userId, Integer minutes);

}

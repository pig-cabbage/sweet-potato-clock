package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.UserInformationMapper;
import com.sweetpotatoclock.entity.UserInformation;
import com.sweetpotatoclock.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInformationServiceimpl implements UserInformationService {
    @Autowired
    private UserInformationMapper userInformationMapper;


    @Override
    public UserInformation getUserInformationByUserId(String userId) {
        return userInformationMapper.selectByPrimaryKey(userId);
    }

    /**
     *
     * @param userId
     * @param nickName
     * @return 0:失败 1：成功 2：已存在
     */
    @Override
    public int addUserInformationInLogin(String userId, String nickName,String avatarUrl) {
        if(userInformationMapper.selectByPrimaryKey(userId)!=null){
            return 2;
        }
        else{
            UserInformation userInformation=new UserInformation();
            userInformation.setUserId(userId);
            userInformation.setUserNickname(nickName);
            userInformation.setDaysSum(0);
            userInformation.setMinutesSum(0);
            userInformation.setContinueDays(0);
            userInformation.setScore(0);
            userInformation.setMotto(avatarUrl);
            return userInformationMapper.insert(userInformation);
        }
    }

    @Override
    public Boolean updateUserScoreInJoin(String userId, Integer joinScore) {
        UserInformation userInformation=userInformationMapper.selectByPrimaryKey(userId);
        Integer scoreBefore = userInformation.getScore();
        userInformation.setScore(scoreBefore-joinScore);
        if(userInformationMapper.updateByPrimaryKey(userInformation)==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateUserScoreInComplete(String userId, Integer obtainScore) {
        UserInformation userInformation=userInformationMapper.selectByPrimaryKey(userId);
        Integer scoreBefore = userInformation.getScore();
        userInformation.setScore(scoreBefore+obtainScore);
        if(userInformationMapper.updateByPrimaryKey(userInformation)==1){
            return true;
        }
        return false;
    }


}

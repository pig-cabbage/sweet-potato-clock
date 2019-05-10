package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.UserInformationMapper;
import com.sweetpotatoclock.entity.GoalComplete;
import com.sweetpotatoclock.entity.UserInformation;
import com.sweetpotatoclock.service.GoalCompleteService;
import com.sweetpotatoclock.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInformationServiceimpl implements UserInformationService {
    @Autowired
    private UserInformationMapper userInformationMapper;
    @Autowired
    private GoalCompleteService goalCompleteService;

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
            userInformation.setScore(100);
            userInformation.setMotto(avatarUrl);
            return userInformationMapper.insert(userInformation);
        }
    }

    /**
     * 加入小组时更新用户积分
     * @param userId
     * @param joinScore
     * @return
     */
    @Override
    public int updateUserScoreInJoin(String userId, Integer joinScore) {
        UserInformation userInformation=userInformationMapper.selectByPrimaryKey(userId);
        Integer scoreBefore = userInformation.getScore();
        userInformation.setScore(scoreBefore-joinScore);
        System.out.print(userInformation.getScore()+"\n");
        if(userInformation.getScore()<0){
            return 2;
        }
        else if(userInformationMapper.updateByPrimaryKey(userInformation)==1){
            return 1;
        }
        return 0;
    }

    /**
     * 打卡目标完成后update用户的积分
     * @param userId
     * @param obtainScore
     * @return
     */
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

    @Override
    public Boolean updateUserScoreInClock(String userId, Integer minutes) {
        UserInformation userInformation=userInformationMapper.selectByPrimaryKey(userId);
        //更新minutesSum
        Integer beforeMinutes=userInformation.getMinutesSum();
        userInformation.setMinutesSum(beforeMinutes+minutes);
        //更新daySum
        int isClock=0;
        List<GoalComplete> goalCompleteList=goalCompleteService.queryGoalByUserId(userId);
        for(int i=0;i<goalCompleteList.size();i++){
            if(goalCompleteList.get(i).getIsClocked()==1){
                isClock=1;
                break;
            }
        }
        System.out.print(isClock+"\n");
        if(isClock==0){
            Integer beforeDays=userInformation.getDaysSum();
            userInformation.setDaysSum(beforeDays+1);
        }
        if(userInformationMapper.updateByPrimaryKey(userInformation)==1){
            return true;
        }
        return false;
    }


}

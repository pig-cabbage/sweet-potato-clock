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
    public UserInformation getUserInformationByUserId(String userID){
        return userInformationMapper.selectByPrimaryKey(userID);
    }


}

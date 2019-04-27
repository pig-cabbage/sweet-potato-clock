package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.UserInformation;

public interface UserInformationService {

/**
 * 通过userID获取用户信息
 *
 * @return
 */
UserInformation getUserInformationByUserId(String userID);

}

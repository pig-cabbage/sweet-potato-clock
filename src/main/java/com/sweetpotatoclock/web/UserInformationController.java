package com.sweetpotatoclock.web;


import com.sweetpotatoclock.entity.UserInformation;
import com.sweetpotatoclock.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userinformation")
public class UserInformationController {
    @Autowired
    private UserInformationService userinformationService;

    /**
     * 通过userId获取user信息
     *
     * @return
     */
    @RequestMapping(value = "/getuserinformationbyuserid",method = RequestMethod.GET)
    public Map<String,Object> getUserInformationByUserId (@RequestParam("userid") String userId){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        System.out.print(userId);
        //获取个人信息
        UserInformation userInformation =userinformationService.getUserInformationByUserId(userId);
        modelMap.put("userinformation",userInformation);
        return modelMap;
    }

}

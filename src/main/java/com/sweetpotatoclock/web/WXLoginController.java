package com.sweetpotatoclock.web;

import com.sweetpotatoclock.service.UserInformationService;
import com.sweetpotatoclock.util.AesCbcUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WXLoginController {
    @Autowired
    UserInformationService userInformationService;
    private String appid = "wxfabca9ab9db9e4dc";
    private String secret = "d9e3f6e43406ebd301c3e81c4374bdbb";

    @RequestMapping(value = "/WXLogin" , method = RequestMethod.POST)
    public Map<String,Object> WXLogin( @RequestBody JSONObject jsonObject){
        //调用微信服务器 获取用户 id
        //GET https://api.weixin.qq.com/sns/jscode2session?
        // appid=APPID  wxfabca9ab9db9e4dc
        // &secret=SECRET   d9e3f6e43406ebd301c3e81c4374bdbb
        // &js_code=JSCODE
        // &grant_type=authorization_code
        String encryptedData = jsonObject.getString("encryptedData");
        String iv=jsonObject.getString("iv");
        String code = jsonObject.getString("code");

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+
                "&secret="+secret+"&js_code="+ code +"&grant_type=authorization_code";
        String userId = null;

        //像微信服务器发起请求 返回json 字符串
        RestTemplate restTemplate = new RestTemplate();
        String response =  restTemplate.getForObject(url,String.class);

        //将字符串 转换为 json对象 并获取其 userId、session_key
        JSONObject json = JSONObject.fromObject(response);
        String session_key = json.get("session_key").toString();
        userId = (String) json.get("openid");
        String nickName=new String();
        String avatarUrl=new String();
        //进行解密
        Map<String,Object> map  = new HashMap<>();
        try {
            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");
                JSONObject userInfoJSON = JSONObject.fromObject(result);
                Map userInfo = new HashMap();
                userInfo.put("openId", userInfoJSON.get("openId"));
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                // 解密unionId & openId;
                userInfo.put("unionId", userInfoJSON.get("unionId"));
                map.put("userInfo", userInfo);
                //获取nickName
                nickName=userInfoJSON.getString("nickName");
                avatarUrl=userInfoJSON.getString("avatarUrl");
            } else {
                map.put("status", 0);
                map.put("msg", "解密失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*判断数据库中是否存在该用户
            不存在：添加该用户 并返回用户信息
            存在：返回用户信息
        */
        //System.out.print(avatarUrl.length()+"\n");
        userInformationService.addUserInformationInLogin(userId,nickName,avatarUrl);
        return map;
    }
}
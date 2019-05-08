package com.sweetpotatoclock.web;

import com.sweetpotatoclock.service.BuyTreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buytrees")
public class BuyTreeController {
    @Autowired
    private BuyTreesService buyTreesService;
    @RequestMapping(value="buytrees",method = RequestMethod.GET)
    public Map<String, Object> buyTrees(@RequestParam("userId") String userId, @RequestParam("number") int number){
        Map<String, Object>result =new HashMap<>();
        if(buyTreesService.buyTrees(userId,number)==1){
            result.put("success",1);
        }
        else
            result.put("success",0);
        return result;
    }
}

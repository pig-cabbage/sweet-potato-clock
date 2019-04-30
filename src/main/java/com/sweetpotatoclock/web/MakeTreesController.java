package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.MakeTrees;
import com.sweetpotatoclock.service.MakeTreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/maketrees")
public class MakeTreesController {

    @Autowired
    private MakeTreesService makeTreesService;

    /**
     * 通过userId获取树木页信息
     *
     * @return
     */
    @RequestMapping(value = "/getmaketreesbyid", method = RequestMethod.GET)
    private Map<String, Object> getMakeTreesById(String userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取树木页信息
        MakeTrees makeTrees = makeTreesService.getMakeTreesByUserId(userId);
        modelMap.put("makeTrees", makeTrees);
        return modelMap;
    }

}

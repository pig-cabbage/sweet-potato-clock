package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.MakeTreesMapper;
import com.sweetpotatoclock.dao.UserInformationMapper;
import com.sweetpotatoclock.entity.MakeTrees;
import com.sweetpotatoclock.service.MakeTreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MakeTreesServiceimpl implements MakeTreesService {
    @Autowired
    private MakeTreesMapper makeTreesMapper;
    @Autowired
    private UserInformationMapper userInformationMapper;

    private List<MakeTrees> list=new ArrayList<>();


    private List<String>nameList=new ArrayList<>();


    @Override
    public MakeTrees getMakeTreesByUserId(String userId){
        return makeTreesMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void modify(String userId,int number) {
        MakeTrees em=makeTreesMapper.selectByPrimaryKey(userId);
        int new_number=em.getTreeNumber()+number;
        double new_area=new_number*2;
        em.setArea(new_area);
        em.setTreeNumber(new_number);
        makeTreesMapper.updateByPrimaryKey(em);
    }



    @Override
    public List<MakeTrees> getList(){
        list=makeTreesMapper.selectAll();
        return list;
    }

    @Override
    public Boolean addMakeTreesInLogin(String userid) {
        MakeTrees makeTrees=new MakeTrees();
        makeTrees.setUserId(userid);
        makeTrees.setArea((double) 0);
        makeTrees.setTreeNumber(0);
        if(makeTreesMapper.insert(makeTrees)==1){
            return true;
        }
        return false;
    }

    @Override
    public List<MakeTrees> rankTrees(){
        Collections.sort(list, new Comparator<MakeTrees>() {
            @Override
            public int compare(MakeTrees t1, MakeTrees t2) {
                return t2.getArea().compareTo(t1.getArea());
            }
        });
        System.out.println(list.toString());
        return list;
    }
    @Override
    public List<String> returnNameList(){
        List<String>nameList=new ArrayList<>();
        List<MakeTrees>list=rankTrees();
        for(int i=0;i<list.size();i++){
            String name=userInformationMapper.selectByPrimaryKey(list.get(i).getUserId()).getUserNickname();
            nameList.add(name);
        }
        return nameList;
    }
}

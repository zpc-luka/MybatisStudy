package com.zpc.dao;

import com.zpc.pojo.Beauty;

import java.util.List;
import java.util.Map;

public interface BeautyMapper {
    // 获取全部用户
//    List<Beauty> getBeautyList();

    //根据 ID 查询用户
    Beauty getBeautyById(int id);

    //插入
//    int addBeauty(Beauty beauty);
//
//    int updateBeauty(Beauty beauty);
//
//    int deleteBeauty(int id);

//    分页
    List<Beauty> getBeautyByLimit(Map<String, Integer> map);

    List<Beauty> getBeautyRowBounds();
}
package com.zpc.dao;

import com.zpc.pojo.Beauty;

import java.util.List;
import java.util.Map;

public interface BeautyMapper {
    // 获取全部用户
    List<Beauty> getBeautyList();

    // 模糊查询
    List<Beauty> getBeautyByLike(String value);

    //根据 ID 查询用户
    Beauty getBeautyById(int id);

    //插入
    int addBeauty(Beauty beauty);

    int addBeauty2(Map<String, Object> map);

    int updateBeauty(Beauty beauty);

    int deleteBeauty(int id);
}
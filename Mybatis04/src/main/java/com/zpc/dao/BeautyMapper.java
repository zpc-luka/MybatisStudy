package com.zpc.dao;

import com.zpc.pojo.Beauty;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface BeautyMapper {
    @Select("select * from Beauty")
    List<Beauty> getBeauty();

//    方法存在多个参数，所有参数前面都必须加上 @Param()
    @Select("select * from Beauty where id = #{id}")
    Beauty getBeautyById(@Param("id") int id);

//    使用引用类型不需要@Param()
    @Insert("        insert into beauty (id,name,sex,boyfriend_id)\n" +
            "        values (#{id}, #{name}, #{sex}, #{boyfriend})")
    int addBeauty(Beauty beauty);

    @Update("        update beauty\n" +
            "        set name = #{name}, boyfriend_id = #{boyfriend}\n" +
            "        where id = #{id};")
    int updateBeauty(Beauty beauty);

    @Delete("delete from beauty where id = #{id};")
    int delete(@Param("id") int id);
}
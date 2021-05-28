package com.zpc.dao;

import com.zpc.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 插入数据
    public int addBlog(Blog blog);

//    查询blog
    List<Blog> queryBlogIF(Map map);

    //    查询blog
    List<Blog> queryBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);

//    查询前三个博客
    List<Blog> queryBlogForeach(Map map);
}

package com.zpc.dao;

import com.zpc.pojo.Beauty;
import com.zpc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void test() {
        // 1 获取 SqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            // 执行sql 方式一  getMapper
            BeautyMapper userDao = sqlSession.getMapper(BeautyMapper.class);
            List<Beauty> beautyList = userDao.getBeautyList();

            for (Beauty beauty: beautyList) {
                System.out.println(beauty);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭 sqlSession
            sqlSession.close();
        }
    }
    @Test
    public void getBeautyById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            BeautyMapper beautyMapper = sqlSession.getMapper(BeautyMapper.class);
            Beauty beauty = beautyMapper.getBeautyById(1);
            System.out.println(beauty);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void addBeauty() {
        // 增删改 需要提交事务
        Beauty beauty = new Beauty(13, "范冰冰", "女", 9);

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            BeautyMapper mapper = sqlSession.getMapper(BeautyMapper.class);
            int res = mapper.addBeauty(beauty);
            if (res > 0) {
                System.out.println("已添加 " + beauty);
            }

            // 提交事务
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void updateBeauty() {
        Beauty beauty = new Beauty(13, "赵薇", "女", 10);

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            BeautyMapper mapper = sqlSession.getMapper(BeautyMapper.class);
            int res = mapper.updateBeauty(beauty);
            if (res > 0) {
                System.out.println("已修改");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteBeauty() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            BeautyMapper mapper = sqlSession.getMapper(BeautyMapper.class);
            int res = mapper.deleteBeauty(13);
            if (res > 0) {
                System.out.println("删除成功");
            }

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}

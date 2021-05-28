package dao;

import com.mysql.jdbc.integration.jboss.MysqlValidConnectionChecker;
import com.zpc.dao.BeautyMapper;
import com.zpc.pojo.Beauty;
import com.zpc.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class UserDaoTest {

//    @Test
//    public void test() {
//        // 1 获取 SqlSession 对象
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        try {
//            // 执行sql 方式一  getMapper
//            BeautyMapper userDao = sqlSession.getMapper(BeautyMapper.class);
//            List<Beauty> beautyList = userDao.getBeautyList();
//
//            for (Beauty beauty: beautyList) {
//                System.out.println(beauty);
//            }
//
//        }catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 关闭 sqlSession
//            sqlSession.close();
//        }
//    }
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


//    @Test
//    public void addBeauty() {
//        // 增删改 需要提交事务
//        Beauty beauty = new Beauty(13, "范冰冰", "女", 9);
//
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        try {
//            BeautyMapper mapper = sqlSession.getMapper(BeautyMapper.class);
//            int res = mapper.addBeauty(beauty);
//            if (res > 0) {
//                System.out.println("已添加 " + beauty);
//            }
//
//            // 提交事务
//            sqlSession.commit();
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//
//    @Test
//    public void updateBeauty() {
//        Beauty beauty = new Beauty(13, "赵薇", "女", 10);
//
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        try {
//            BeautyMapper mapper = sqlSession.getMapper(BeautyMapper.class);
//            int res = mapper.updateBeauty(beauty);
//            if (res > 0) {
//                System.out.println("已修改");
//            }
//            sqlSession.commit();
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//    @Test
//    public void deleteBeauty() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        try {
//            BeautyMapper mapper = sqlSession.getMapper(BeautyMapper.class);
//            int res = mapper.deleteBeauty(13);
//            if (res > 0) {
//                System.out.println("删除成功");
//            }
//
//            sqlSession.commit();
//        } finally {
//            sqlSession.close();
//        }
//    }
    static Logger logger = Logger.getLogger("UserDao.class");
    @Test
    public void testLog4j() {
        logger.info("info: 进入了 testLog4j");
        logger.debug("debug: 进入了 testLog4j");
        logger.error("error: 进入了 testLog4j");

    }

    @Test
    public void getBeautyByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            BeautyMapper mapper = sqlSession.getMapper(BeautyMapper.class);

            HashMap<String, Integer> map = new HashMap<>();
            map.put("startIndex", 0);
            map.put("pageSize", 3);

            List<Beauty> beautyList = mapper.getBeautyByLimit(map);

            for (Beauty beauty : beautyList) {
                System.out.println(beauty);
            }

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getBeautyRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            RowBounds rowBounds = new RowBounds(1,2);

            List<Beauty> beautyList = sqlSession.selectList("com.zpc.dao.BeautyMapper.getBeautyRowBounds",null, rowBounds);

            for (Beauty beauty : beautyList) {
                System.out.println(beauty);
            }
        } finally {
            sqlSession.close();
        }
    }
}

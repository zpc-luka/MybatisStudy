import com.zpc.dao.BlogMapper;
import com.zpc.pojo.Blog;
import com.zpc.utils.IdUtils;
import com.zpc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void addInitBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis is easy");
        blog.setAuthor("author1");
        blog.setCreate_time(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setTitle("Java is easy");
        blog.setId(IdUtils.getId());
        mapper.addBlog(blog);

        blog.setTitle("Spring is easy");
        blog.setId(IdUtils.getId());
        mapper.addBlog(blog);

        blog.setTitle("micro service is easy");
        blog.setId(IdUtils.getId());
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
//        map.put("title", "Java is easy");
        map.put("id", "947c2c0238b34d4d8700dfa9f6744d32");
        List<Blog> blogs = mapper.queryBlogIF(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "Java is easy");
//        map.put("author", "author1");
        map.put("views", 9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
//        map.put("title", "Java is easy");
//        map.put("author", "author1");
        map.put("views", 1000);
        map.put("id", "947c2c0238b34d4d8700dfa9f6744d32");
        int res = mapper.updateBlog(map);
        if(res != 0) {
            System.out.println("updated");
        }
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        ArrayList<String> ids = new ArrayList<>();
        ids.add("aa020f64e9634ccc97d59700563f7966");
        ids.add("947c2c0238b34d4d8700dfa9f6744d32");
        ids.add("1fa76683f02d4b27a4ee27307b985863");
        map.put("ids", ids);
        List<Blog> blogList = mapper.queryBlogForeach(map);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}

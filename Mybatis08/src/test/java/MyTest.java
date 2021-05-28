import com.zpc.dao.StudentMapper;
import com.zpc.pojo.Student;
import com.zpc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void Test() {
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);

        Student student1 = mapper1.queryStudent(2);
        System.out.println(student1);
        sqlSession1.close();

        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);
        Student student2 = mapper2.queryStudent(2);
        System.out.println(student2);

        System.out.println(student1 == student2);

        sqlSession2.close();

    }
}

import com.zpc.dao.StudentMapper;
import com.zpc.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.zpc.dao.TeacherMapper;
import com.zpc.pojo.Teacher;
import com.zpc.utils.MybatisUtils;

import java.util.List;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//            Student student = mapper.getStudent(1);
            List<Student> studentList = mapper.getStudent();
            for (Student student : studentList) {
                System.out.println(student);
            }

        } finally {
            sqlSession.close();
        }
    }
}

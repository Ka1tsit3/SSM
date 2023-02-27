import almost.DRMapper.DeptMapper;
import almost.DRMapper.EmployeesMapper;
import almost.pojo.Dept;
import almost.pojo.Employees;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class selectTest {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private EmployeesMapper employeesMapper;

    @Test
    public void test(){
//        System.out.println(deptMapper);
//        deptMapper.insertSelective(new Dept(1,"ad"));
//        deptMapper.insertSelective(new Dept(2,"ap"));
        for (int i=0;i<1000;i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5)+i;
            employeesMapper.insertSelective(new Employees(null,uid,12,"男",uid+"@126.com",1));
        }
    }
}

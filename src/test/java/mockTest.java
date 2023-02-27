import almost.pojo.Employees;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:springmvc.xml"})
public class mockTest {
    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    //初始化
    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void TEST() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();//获取请求信息
        MockHttpServletRequest request = result.getRequest();//转换到请求页
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码"+pageInfo.getPageNum());
        System.out.println("总页码"+pageInfo.getPages());
        System.out.println("总记录数"+pageInfo.getTotal());
        System.out.println("当前要显示的页码数");
        int[] nums= pageInfo.getNavigatepageNums();//页码获取
        for (int i://页码遍历
             nums) {
            System.out.print(" "+i);
        }
        System.out.println();
        //列的获取
        List<Employees> list = pageInfo.getList();
        for (Employees e:
             list) {
            System.out.println("名字："+"==>"+e.getEmpName());
            System.out.println("ID："+"==>"+e.getEmpId());
        }
    }
}

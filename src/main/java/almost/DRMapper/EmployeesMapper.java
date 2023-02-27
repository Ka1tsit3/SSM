package almost.DRMapper;

import almost.pojo.Employees;
import almost.pojo.EmployeesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeesMapper {
    long countByExample(EmployeesExample example);

    int deleteByExample(EmployeesExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employees record);

    int insertSelective(Employees record);

    List<Employees> selectByExampleWithDept(Object o);

    List<Employees> selectByExample(EmployeesExample example);

    Employees selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("record") Employees record, @Param("example") EmployeesExample example);

    int updateByExample(@Param("record") Employees record, @Param("example") EmployeesExample example);

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);


}
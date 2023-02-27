package almost.CRService;

import almost.DRMapper.EmployeesMapper;
import almost.pojo.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpsService {

    @Autowired
    EmployeesMapper employeesMapper;
    public List<Employees> getAll() {
        return employeesMapper.selectByExampleWithDept(null);
    }
}

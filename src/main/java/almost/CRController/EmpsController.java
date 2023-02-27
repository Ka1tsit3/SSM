package almost.CRController;

import almost.CRService.EmpsService;
import almost.pojo.Employees;
import almost.utils.MSG;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmpsController {

    @Autowired
    EmpsService empsService;

    @RequestMapping("/emps")
    @ResponseBody
    public MSG getJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,5);
        List<Employees> emp=empsService.getAll();
        PageInfo pageInfo=new PageInfo(emp,5);
        return MSG.success().add("pageInfo",pageInfo);
    }
//    @RequestMapping("/emps")
//    public String getAllT(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
//        PageHelper.startPage(pn,5);
//        List<Employees> emp=empsService.getAll();
//        PageInfo pageInfo=new PageInfo(emp,5);
//        model.addAttribute("pageInfo",pageInfo);
//        return "list";
//    }
}

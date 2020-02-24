package com.mverp.modules.empManage.controller;


import com.mverp.common.dto.ResponseBean;
import com.mverp.jpa.entity.EmployeeEntity;
import com.mverp.modules.empManage.service.EmpService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("employee")


public class EmpManageController {

    @Autowired
    private EmpService empService;

    @RequiresRoles("B")
    @RequestMapping(value="/query",method= RequestMethod.GET)
    @ResponseBody
    public ResponseBean queryEmployee(@RequestParam("name") String name) {
        ResponseBean responseBean = new ResponseBean();
        List<EmployeeEntity> emplist = new ArrayList<EmployeeEntity>();
        try {
            emplist = empService.selectEmployeeInfoByName(name);
        }catch(Exception e) {
            e.printStackTrace();
        }
        if (emplist != null) {
            responseBean.setCode("20000");
            responseBean.setMsg("success");
            responseBean.setStatus(true);
            responseBean.setData(emplist);
            return responseBean;
        } else {
            responseBean.setCode("20000");
            responseBean.setMsg("찾으신 "+name+" 직원분이 없습니다.다시 확인하여 주십오");
            responseBean.setStatus(false);
            return responseBean;
        }
    }
}

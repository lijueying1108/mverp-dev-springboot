package com.mverp.modules.empManage.controller;


import com.mverp.common.dto.ResponseBean;
import com.mverp.modules.empManage.service.CompanyInfoService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiresAuthentication
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;
    @RequestMapping(value="/combobox/queryDepartmentsList")
    @ResponseBody
    public ResponseBean queryDepartmentsList(HttpServletRequest httpRequest, HttpSession httpSess) {
        ResponseBean respBean = new ResponseBean("20000",companyInfoService.selectDepartComboboxData());
        return respBean;
    }
}

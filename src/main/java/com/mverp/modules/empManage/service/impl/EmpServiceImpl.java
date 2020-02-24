package com.mverp.modules.empManage.service.impl;

import com.mverp.jpa.Repository.EmployeeRepository;
import com.mverp.jpa.entity.EmployeeEntity;
import com.mverp.modules.empManage.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<EmployeeEntity> selectEmployeeInfoByName(String name) {
        List<EmployeeEntity> list = employeeRepository.findEmployeeInfoByName(name);

        if (list.size() > 0) return list;
        else return null;
    }
}

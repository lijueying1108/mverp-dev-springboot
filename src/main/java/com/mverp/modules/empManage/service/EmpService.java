package com.mverp.modules.empManage.service;

import com.mverp.jpa.entity.EmployeeEntity;

import java.util.List;

public interface EmpService {

    List<EmployeeEntity> selectEmployeeInfoByName(String name);
}

package com.mverp.shiro.service;

import com.mverp.jpa.entity.EmployeeEntity;
import com.mverp.jpa.entity.SysRoleEntity;
import com.mverp.jpa.entity.SysUserEntity;

import java.util.List;

public interface SysUserService {
    SysUserEntity findSysUserByUserCode(String usercode);
    List<SysRoleEntity> findRolesByUserCode (String usercode);
    EmployeeEntity selectEmployeeNameById(String id);
}

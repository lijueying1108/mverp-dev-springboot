package com.mverp.shiro.service.impl;

import com.mverp.jpa.Repository.EmployeeRepository;
import com.mverp.jpa.Repository.SysRoleRepository;
import com.mverp.jpa.Repository.SysUserRepository;
import com.mverp.jpa.entity.EmployeeEntity;
import com.mverp.jpa.entity.SysRoleEntity;
import com.mverp.jpa.entity.SysUserEntity;
import com.mverp.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public SysUserEntity findSysUserByUserCode(String username) {
        return sysUserRepository.findByUsername(username);
    }

    @Override
    public List<SysRoleEntity> findRolesByUserCode(String usercode) {
        return sysRoleRepository.findRoleByUsername(usercode);
    }

    @Override
    public EmployeeEntity selectEmployeeNameById(String id) {
        return employeeRepository.findEmpById(id);
    }
}

package com.mverp.shiro.realm;

import com.mverp.jpa.entity.EmployeeEntity;
import com.mverp.jpa.entity.SysRoleEntity;
import com.mverp.jpa.entity.SysUserEntity;
import com.mverp.shiro.pojo.ActiveUser;
import com.mverp.shiro.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MVRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService ;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Session session = SecurityUtils.getSubject().getSession();
        ActiveUser currentUser = new ActiveUser();
        currentUser = (ActiveUser) principals.getPrimaryPrincipal();

        String usercode = currentUser.getUsercode();
        SysUserEntity sysUser = new SysUserEntity();

        if(usercode != null) {
            sysUser = sysUserService.findSysUserByUserCode(usercode);
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<SysRoleEntity> rolesList = null;
        try{
            rolesList = sysUserService.findRolesByUserCode(usercode);
        }catch (Exception e) {
            e.printStackTrace();
        }

        List<String> roles = new ArrayList<String>();
        if(rolesList != null) {
            for(SysRoleEntity sysRole:rolesList) {
                roles.add(sysRole.getName());
            };
        }
        simpleAuthorizationInfo.addRoles(roles);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) auth;
        String usercode = (String) token.getUsername();

        SysUserEntity sysUser = sysUserService.findSysUserByUserCode(usercode);
        List<SysRoleEntity> rolesList = new ArrayList<SysRoleEntity>();
        if (sysUser == null) {
            throw new UnknownAccountException();
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();
        try{
            employeeEntity = sysUserService.selectEmployeeNameById(sysUser.getEmloyeeid());
            rolesList = sysUserService.findRolesByUserCode(sysUser.getUsername());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        List<String> roles = new ArrayList<String>();
        if (rolesList != null) {
            for(SysRoleEntity sysRole:rolesList) {
                roles.add(sysRole.getName());
            }
        }
        ActiveUser activeUser = new ActiveUser();

        //ActiveUer Employeee Id
        activeUser.setId(employeeEntity.getId());
        //Login Id
        activeUser.setUsercode(sysUser.getUsername());
        //User name
        activeUser.setUsername(employeeEntity.getName());
        //User roles
        activeUser.setRoles(roles);
        System.out.println("activeUser: "+activeUser.getId());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(activeUser,sysUser.getPassword(),getName());

        return authenticationInfo;
    }
}

package com.mverp.modules.login.controller;

import com.mverp.common.dto.ResponseBean;
import com.mverp.common.dto.ResponseTokenBean;
import com.mverp.shiro.pojo.ActiveUser;
import com.mverp.shiro.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class LoginCotroller {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean doLogin(@RequestParam("username") String username, @RequestParam ("password") String password) throws Exception{
        ResponseBean respBean = new ResponseBean();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        ActiveUser currentUser = new ActiveUser();
        try {
            SecurityUtils.getSubject().login(token);
            currentUser = (ActiveUser) SecurityUtils.getSubject().getPrincipal();
            ResponseTokenBean respoTokenBean = new ResponseTokenBean();
            respoTokenBean.setToken(SecurityUtils.getSubject().getSession().getId());
            respoTokenBean.setData(currentUser);
            respoTokenBean.setCode("20000");
            respoTokenBean.setMsg("Login Success");
            return respoTokenBean;
        } catch (IncorrectCredentialsException e) {
            return new ResponseBean("Id or password is wrong","20000");
        } catch (UnknownAccountException e) {
            return new ResponseBean("User does not exist","20000");
        }
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public ResponseBean logout(HttpServletRequest request) throws Exception {
        ResponseBean resp = new ResponseBean();
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();

        resp.setCode("20000");
        resp.setMsg("logout 성공");
        return resp;
    }

    @RequestMapping(value = "/unauth")
    @ResponseBody
    public ResponseBean unauth(HttpServletRequest request) throws Exception {
        ResponseBean resp = new ResponseBean();
        resp.setCode("20000");
        resp.setMsg("다시 로그인 하세요");
        return resp;
    }
}

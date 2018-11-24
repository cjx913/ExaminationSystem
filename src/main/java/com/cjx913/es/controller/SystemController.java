package com.cjx913.es.controller;

import com.cjx913.es.entity.persistent.SysUser;
import com.cjx913.es.exception.CustomException;
import com.cjx913.es.exception.ValidationException;
import com.cjx913.es.service.UserService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SystemController {
    @Autowired
    private UserService userService;
	Logger log = LoggerFactory.getLogger(SystemController.class);


    @RequestMapping(value ={"/","/index"})
    public String index() {

        return "index";
    }
	
    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session) throws CustomException {
    	
        session.invalidate();
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) throws CustomException {
    	
        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        //根据shiro返回的异常类路径判断

        if (exceptionClassName != null) {
            String message = null;
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                //最终会抛给异常处理器
                message = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(
                    exceptionClassName)) {
                message = "用户名/密码错误";
            } else if (ValidationException.class.getName().equals(exceptionClassName)) {
                message = "验证码错误";
            } else {
                message = "未知错误 ";
            }
            request.setAttribute("message", message);
        }
        //此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
        //登陆失败还到login页面
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(HttpSession session) throws CustomException{
//        session.invalidate();
        return "register";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request,String username,String email,String password,String randomCode,String validateCode) throws CustomException{
        if(!randomCode.equalsIgnoreCase(validateCode)){
            request.setAttribute("registerMessage","验证码错误!!!");
            return "login";
        }
        if(userService.findUserByName(username)!=null){
            request.setAttribute("registerMessage","用户名已存在!!!");
            return "login";
        }
        SysUser sysUser = new SysUser();
        sysUser.setName(username);
        sysUser.setPassword(password);
        sysUser.setAccount(String.valueOf((int)(10000000+Math.random()*100000000)));
//        while (userService.findUserByAccount(sysUser.getAccount())!=null){
//            sysUser.setAccount(String.valueOf((int)(10000000+Math.random()*100000000)));
//        }
        sysUser.setSalt(sysUser.getName()+ sysUser.getAccount());
        userService.saveUser(sysUser);
        request.setAttribute("message","注册成功,请登录");
        return "login";
    }
    


}

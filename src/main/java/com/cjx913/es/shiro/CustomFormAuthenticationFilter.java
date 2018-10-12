package com.cjx913.es.shiro;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cjx913.es.entity.domain.UserIdentity;
import com.cjx913.es.exception.ValidationException;
import com.cjx913.es.service.UserService;


import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(FormAuthenticationFilter.class);

    public static final String DEFAULT_RANDOMCODE = "randomCode";
    public static final String DEFAULT_VALIDATECODE = "validateCode";
    //生成的隨機验证码
    private String randomCodeParam = DEFAULT_RANDOMCODE;
    //输入的验证码
    private String validateCodeParam = DEFAULT_VALIDATECODE;

    public String getRandomCodeParam() {
        return randomCodeParam;
    }

    public void setRandomCodeParam(String randomcodeParam) {
        this.randomCodeParam = randomcodeParam;
    }

    //获取字段值
    protected String getRandomCode(ServletRequest request) {
        return WebUtils.getCleanParam(request, getRandomCodeParam());
    }

    public String getValidateCodeParam() {
        return validateCodeParam;
    }

    public void setValidateCodeParam(String validateCodeParam) {
        this.validateCodeParam = validateCodeParam;
    }

    //获取字段值
    protected String getValidateCode(ServletRequest request) {
        return WebUtils.getCleanParam(request, getValidateCodeParam());
    }


    //重写原FormAuthenticationFilter的认证方法
    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {
        //是否是登陆验证的url
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                String randomCodeValue = getRandomCode(request);
                String validateCodeValue = getValidateCode(request);
                //不使用验证码
                if (randomCodeValue == null && validateCodeValue == null) {
                    return executeLogin(request, response);
                }
                //使用验证码
                //验证码不为空且相等
                if (randomCodeValue!= null && !randomCodeValue.equals("") &&validateCodeValue!= null && !validateCodeValue.equals("") && randomCodeValue.equalsIgnoreCase(validateCodeValue)) {
                    return executeLogin(request, response);
                }
                //验证码为空或不相等
                HttpServletRequest httpServletRequest = (HttpServletRequest)request;
                httpServletRequest.setAttribute("shiroLoginFailure", ValidationException.class.getName());
                return true;
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                //allow them to see the login page ;)
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
                        "Authentication url [" + getLoginUrl() + "]");
            }

            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
        HttpSession session = ((HttpServletRequest) request).getSession();
        UserIdentity userIdentity = (UserIdentity) subject.getPrincipal();
        session.setAttribute("user",userIdentity);
        return super.onLoginSuccess(token, subject, request, response);
	}
    
    


}

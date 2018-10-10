package com.cjx913.es;

import com.cjx913.es.exception.CustomException;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomDispatcherServlet extends DispatcherServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
        throw new CustomException("访问路径错误");
    }
}

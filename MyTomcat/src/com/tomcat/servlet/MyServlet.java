package com.tomcat.servlet;

import com.tomcat.initparam.MyServletRequest;
import com.tomcat.initparam.MyServletResponse;

/**
 * 
 * function: 自定义容器默认Servlet
 * @author a_zha
 * @date 2018年7月25日
 */
public abstract class MyServlet {

	public void service(MyServletRequest request, MyServletResponse response) {
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			doGet(request, response);
		} else {
			doPost(request, response);
		}
	}
	
	public abstract void doGet(MyServletRequest request, MyServletResponse response);
	
	public abstract void doPost(MyServletRequest request, MyServletResponse response);
	
}

package com.haolin.yewu;

import java.io.IOException;
import java.io.OutputStream;

import com.tomcat.initparam.MyServletRequest;
import com.tomcat.initparam.MyServletResponse;
import com.tomcat.servlet.MyServlet;

/**
 * 
 * function: 业务工程
 * @author a_zha
 * @date 2018年7月25日
 */
public class WodeServlet extends MyServlet {

	@Override
	public void doGet(MyServletRequest request, MyServletResponse response) {
		try {
			StringBuilder builder = new StringBuilder();
			builder.append(MyServletResponse.RESPONSE_HEADER);
			builder.append("--->Url: " + request.getUrl());
			builder.append(";--->\t Method: " + request.getMethod());
			String params = "";
			if (null != request.getParamArray() && request.getParamArray().length > 0) {
				String[] paramArray = request.getParamArray();
				for (int i = 0; i < paramArray.length; i++) {
					params += paramArray[i] + ",";
				}
				builder.append(";--->\t Params: << " + params.substring(0, params.length()-1) + " >>");
			}
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(builder.toString().getBytes("UTF-8"));
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(MyServletRequest request, MyServletResponse response) {
		doGet(request, response);
	}

}

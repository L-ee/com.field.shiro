package com.linan.shiro.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class BaceAction extends ActionSupport {
	
	/*
	 * 序列号
	 */
	private static final long serialVersionUID = -3016135347295345285L;

	/*
	 * 将对象数据格式化成JSON数据
	 * 
	 * @param Object obj(需要格式的数据)
	 * @Authod Lee
	 * 2016-01-30
	 */
	public void OutputJson(Object obj){
		@SuppressWarnings("unused")
		PrintWriter writer = null;
		
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置数据类型
		response.setContentType("application/json");
		// 设置编码格式
		response.setCharacterEncoding("UTF-8");
		try {
			writer = response.getWriter();
			writer.print(JSON.toJSONString(obj));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(writer != null){
				writer.close();
			}
		}
	}
	
	

}

package com.linan.shiro.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class BaceAction extends ActionSupport {
	
	/*
	 * ���к�
	 */
	private static final long serialVersionUID = -3016135347295345285L;

	/*
	 * ���������ݸ�ʽ����JSON����
	 *
	 * @param Object obj(��Ҫ��ʽ������)
	 * @Authod Lee
	 * 2016-01-30
	 */
	public void OutputJson(Object obj){
		@SuppressWarnings("unused")
		PrintWriter writer = null;

		HttpServletResponse response = ServletActionContext.getResponse();
		// ������������
		response.setContentType("application/json");
		// ���ñ����ʽ
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

package com.controller;

import java.io.*;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.model.*;
import com.sist.test.Context;
import com.sist.test.MyDataSource;
/*
 *  Spring => 구조 (원서)
 *  하둡
 *  R
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebApplicationContext wc;
	private ViewResolver vr;
	public void init(ServletConfig config) throws ServletException {
		try
		{
			Context c=new Context();
			MyDataSource ds=(MyDataSource)c.lookup("jdbc/oracle");
			Connection conn=ds.getConnection();
		}catch(Exception ex){}
		
		String path=config.getInitParameter("contextConfigLocation");
		wc = new WebApplicationContext(path);
		vr = new ViewResolver();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String cmd = request.getRequestURI();
			System.out.println(cmd);
			cmd = cmd.substring(request.getContextPath().length()+1,cmd.lastIndexOf('.'));
			System.out.println(cmd);
			Model model = (Model)wc.getBean(cmd);
			System.out.println(model);
			String jspName = model.handlerRequest(request, response);
			System.out.println(request);
			System.out.println(jspName);
			String jsp = vr.jspFind(jspName);
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		} catch (Exception ex) {}
	}
}

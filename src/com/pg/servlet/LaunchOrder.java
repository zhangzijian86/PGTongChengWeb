package com.pg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.pg.bean.Pg_user;
import com.pg.daoimpl.DaoImpl;

@SuppressWarnings("serial")
public class LaunchOrder extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    PrintWriter out=response.getWriter();
		String OrderCode=request.getParameter("OrderCode");
		String CreatedBy=request.getParameter("CreatedBy");
		DaoImpl userDaoImpl=new DaoImpl();
		int flag=userDaoImpl.LaunchOrder(OrderCode,CreatedBy);
		if(flag<0){
			out.write("error");		
		}else{
			out.write("ok");
		}	   
		out.flush();
		out.close();
	}
}

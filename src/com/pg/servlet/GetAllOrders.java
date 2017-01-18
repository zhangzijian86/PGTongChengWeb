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
import com.pg.bean.Pg_order;
import com.pg.bean.Pg_user;
import com.pg.daoimpl.DaoImpl;

@SuppressWarnings("serial")
public class GetAllOrders extends HttpServlet {
	
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
		String CurrentPage=request.getParameter("CurrentPage");
		String EachPage=request.getParameter("EachPage");
		String UserTmp=request.getParameter("UserTmp");
		UserTmp = new String(UserTmp.getBytes("ISO-8859-1"), "UTF-8");
		String OrderTmp=request.getParameter("OrderTmp");
		OrderTmp = new String(OrderTmp.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("====GetAllOrders=============CurrentPage======"+CurrentPage);
		System.out.println("====GetAllOrders=============EachPage======"+EachPage);
		System.out.println("====GetAllOrders=============OrderTmp======"+OrderTmp);
		System.out.println("====GetAllOrders=============UserTmp======"+UserTmp);
		DaoImpl userDaoImpl=new DaoImpl();
		List<Pg_order> list=userDaoImpl.GetAllOrders(UserTmp,OrderTmp,CurrentPage,EachPage);
		HttpSession session = request.getSession(); 
		if(session==null||session.getAttribute("UserCode")==null)
	    {
			out.write("error");
	    }else{
	    	if(list!=null&&list.size()>=0){			
				Gson gson=new Gson();//利用google提供的gson将一个list集合写成json形式的字符串		
				String jsonstring=gson.toJson(list);
				out.write(jsonstring);
			}else{
				out.write("error");
			}
	    }
		out.flush();
		out.close();
	}
}

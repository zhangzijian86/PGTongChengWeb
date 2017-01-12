package com.pg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pg.bean.Pg_user;
import com.pg.daoimpl.DaoImpl;

@SuppressWarnings("serial")
public class GetCount extends HttpServlet {
	
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
		String Name=request.getParameter("Name");
		String Condition=request.getParameter("Condition");
//		System.out.println("====doPost=============Name======"+Name);
//		System.out.println("====doPost=============Condition======"+Condition);
		DaoImpl userDaoImpl=new DaoImpl();
		int count=userDaoImpl.getCount(Name,Condition);
//		System.out.println("====doPost=============count======"+count);
		if(count!=-1){
			int pageCount = (new Double(Math.ceil(((double)count/Double.valueOf(10))))).intValue();
			Gson gson=new Gson();//利用google提供的gson将一个list集合写成json形式的字符串		
			String jsonstring=gson.toJson(pageCount);
			out.write(jsonstring);
		}else{
			out.write("error");
		}
		out.flush();
		out.close();
	}
}

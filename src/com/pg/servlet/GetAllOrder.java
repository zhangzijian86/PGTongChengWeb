package com.pg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.pg.bean.Pg_order;
import com.pg.daoimpl.DaoImpl;

@SuppressWarnings("serial")
public class GetAllOrder extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		//Model 0,客户端 1,网页 
		//Type 0,销售 1,制作 2,完成
		//Condition 查询条件
		System.out.println("=GetAllOrder=doPost=");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    PrintWriter out=response.getWriter();
		String Model=request.getParameter("Model");
		String Type=request.getParameter("Type");
		String Condition=request.getParameter("Condition");
		Condition = new String(Condition.getBytes("ISO-8859-1"), "UTF-8");
		String CreatedBy = "";
		String CurrentPage = "";
		String EachPage = "";
		HttpSession session = request.getSession(); 
		if(Model!=null&&Model.equals("1")){
			CurrentPage=request.getParameter("CurrentPage");
			EachPage=request.getParameter("EachPage");
		}else{
			CreatedBy=request.getParameter("CreatedBy");
		}
		DaoImpl userDaoImpl=new DaoImpl();
		List<Pg_order> list=userDaoImpl.GetAllOrder(Model,Type,Condition,CreatedBy,CurrentPage,EachPage);
		if(list!=null&&list.size()>=0){			
			Gson gson=new Gson();//利用google提供的gson将一个list集合写成json形式的字符串		
			String jsonstring=gson.toJson(list);
			out.write(jsonstring);
		}else{
			out.write("error");
		}	   
		out.flush();
		out.close();
	}
}

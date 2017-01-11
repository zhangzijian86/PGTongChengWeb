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


@SuppressWarnings("serial")
public class Login extends HttpServlet {

	
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
//		String usermobile=request.getParameter("usermobile");
////		out.write("登录成功==0="+usermobile); 
//		System.out.println("====doPost=============usermobile======"+usermobile);
////		out.write("登录成功==1="+password); 
//		UserDaoImpl userDaoImpl=new UserDaoImpl();
//		Pgdr_user puser=userDaoImpl.login(usermobile);
//		List<Pgdr_user> list1=new ArrayList<Pgdr_user>();
//		Gson gson=new Gson();//利用google提供的gson将一个list集合写成json形式的字符串		
//		list1.add(puser);
//		String jsonstring=gson.toJson(list1);
//		System.out.println("======jsonstring========="+jsonstring);
//		out.write(jsonstring);
//		if (b) 
//		{
//			System.out.println("====doPost=============success======");
//			out.write("success");
//		}
//		else 
//		{
//			System.out.println("====doPost=============false======");
//			out.write("false");
//		}
	    out.write("=============PGTongChengWeb======Login===============");
		out.flush();
		out.close();
	}

}

package com.pg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pg.bean.Pg_news;
import com.google.gson.Gson;
import com.pg.daoimpl.DaoImpl;

@SuppressWarnings("serial")
public class UpdateNews extends HttpServlet {
	
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
	    Gson gson=new Gson();
		String jsonStr=request.getParameter("jsonStr");
		System.out.println("====jsonStr===1==="+jsonStr);
		jsonStr = new String(jsonStr.getBytes("ISO-8859-1"), "UTF-8");
		//jsonStr = URLDecoder.decode(jsonStr,"utf-8");
		System.out.println("====jsonStr===22==="+jsonStr);
		Pg_news pnews = null;
		HttpSession session = request.getSession(); 
		if(session==null||session.getAttribute("UserCode")==null)
	    {
			out.write("error");		
	    }else{
	    	pnews = gson.fromJson(jsonStr, Pg_news.class); 
			if(pnews!=null){
				System.out.println("====jsonStr===33===");
				DaoImpl userDaoImpl=new DaoImpl();
				int flag=userDaoImpl.UpdateNews(pnews);
				if(flag<0){
					System.out.println("====jsonStr===44===");
					out.write("error");		
				}else{
					System.out.println("====jsonStr===55===");
					out.write("ok");
				}
			}else{
				System.out.println("====jsonStr===66===");
				out.write("error");		
			}
	    }
		out.flush();
		out.close();
	}
}

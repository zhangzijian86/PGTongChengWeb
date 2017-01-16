package com.pg.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Decoder.BASE64Encoder;

import com.google.gson.Gson;
import com.pg.bean.Pg_homeinfo;
import com.pg.bean.Pg_user;
import com.pg.daoimpl.DaoImpl;

@SuppressWarnings("serial")
public class GetHomeInfo extends HttpServlet {
	
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
		DaoImpl userDaoImpl=new DaoImpl();
		List<Pg_homeinfo> list = userDaoImpl.GetHomeInfo();
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
	
	//图片转化成base64字符串  
    public static String GetImageStr(String path)  
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        //String imgFile = "d://test.jpg";//待处理的图片  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(path);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }  
}

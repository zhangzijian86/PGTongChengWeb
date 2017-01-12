package com.pg.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pg.bean.Pg_user;
import com.pg.db.GetConn;


public class DaoImpl 
{
	public Pg_user login(String UserCode,String Password) 
	{
		GetConn getConn=new GetConn();
		ResultSet rs = null;
		Connection conn=getConn.getConnection();
		Pg_user user = null;
		try {
			PreparedStatement ps=conn.prepareStatement(
					"select UserID,UserCode,UserName,Password,PasswordKey,PasswordIV,UserClass,Gender,"+
					"ISDN,Telephone,Mobile,Fax,Email,Address,Photo,Age,Birthday,Remark,Status,"+
					"CreatedBy,CreatedDate,ModifiedBy,ModifiedDate "+
					"from pg_user where UserCode=? and Password=? and Status=1");
			ps.setString(1,UserCode);
			ps.setString(2,Password);
			rs=ps.executeQuery();
			if (rs.next())
			{
				user = new Pg_user();
				System.out.println("==UserID=="+rs.getString("UserID"));
				System.out.println("==UserCode=="+rs.getString("UserCode"));
				System.out.println("==UserName=="+rs.getString("UserName"));
				user.setUserID(rs.getString("UserID"));
				user.setUserCode(rs.getString("UserCode"));
				user.setUserName(rs.getString("UserName"));
				user.setPassword(rs.getString("Password"));
				user.setPasswordKey(rs.getString("PasswordKey"));
				user.setPasswordIV(rs.getString("PasswordIV"));
				user.setUserClass(rs.getString("UserClass"));
				user.setGender(rs.getString("Gender"));
				user.setISDN(rs.getString("ISDN"));
				user.setTelephone(rs.getString("Telephone"));
				user.setMobile(rs.getString("Mobile"));
				user.setFax(rs.getString("Fax"));
				user.setEmail(rs.getString("Email"));
				user.setAddress(rs.getString("Address"));
				user.setPhoto(rs.getString("Photo"));
				user.setAge(rs.getString("Age"));
				user.setBirthday(rs.getString("Birthday"));
				user.setRemark(rs.getString("Remark"));
				user.setStatus(rs.getString("Status"));
				user.setCreatedBy(rs.getString("CreatedBy"));
				user.setCreatedDate(rs.getString("CreatedDate"));
				user.setModifiedBy(rs.getString("ModifiedBy"));
				user.setModifiedDate(rs.getString("ModifiedDate"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	//查询所总条数   
    public int getCount(String name,String Condition){   
    	String sql="select count(*) as pageCount from "+name+" "+Condition;   
    	System.out.println(sql);
    	int i=-1;   
    	GetConn getConn=new GetConn();
    	ResultSet rs = null;
    	Connection conn=getConn.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
    		rs=ps.executeQuery();
    		if(rs!=null){    					
    			rs.next();  
    			i=rs.getInt("pageCount");  
    		}
    	} catch (SQLException e) {   
    		e.printStackTrace();   
    	}   
    	return i;   
    } 
    
    public List<Pg_user> GetAllUsers(String currentPage,String eachPage) 
	{
		int rows;
		GetConn getConn=new GetConn();
		ResultSet rs = null;
		Connection conn=getConn.getConnection();
		List<Pg_user> list=new ArrayList<Pg_user>();
		Pg_user puser = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select UserID,UserCode,UserName,Telephone,Mobile,Email"
					+ " from pg_user order by ModifiedDate desc  limit ?, ?");
			int intcurrentPage = Integer.parseInt(currentPage);
			int inteachPage = Integer.parseInt(eachPage);
			if(currentPage.equals("0")){
				ps.setInt(1, 0);
			}else{
				ps.setInt(1, (intcurrentPage-1)*inteachPage);
			}
			ps.setInt(2, inteachPage);
			rs=ps.executeQuery();
			if(rs!=null){    		
	    		rs.last();
	    		rows = rs.getRow();
	    		rs.beforeFirst();
	    		for(int i=0;i<rows;i++)
		    	{	    			
		    		rs.next();
		    		puser = new Pg_user();
		    		puser.setUserID(rs.getString("UserID"));
		    		puser.setUserCode(rs.getString("UserCode"));
		    		puser.setUserName(rs.getString("UserName"));
		    		puser.setTelephone(rs.getString("Telephone"));
		    		puser.setMobile(rs.getString("Mobile"));
		    		puser.setEmail(rs.getString("Email"));
		    		list.add(puser);
		    	}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

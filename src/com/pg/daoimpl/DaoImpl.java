package com.pg.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}

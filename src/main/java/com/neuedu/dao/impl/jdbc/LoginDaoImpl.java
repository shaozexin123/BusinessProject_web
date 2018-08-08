package com.neuedu.dao.impl.jdbc;

import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;
import com.neuedu.utils.DBUtils;
import com.neuedu.utils.MD5Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements ILoginDao {

	@Override
	public Account doLogin(String _username, String _password) {
		// TODO Auto-generated method stub
		
		Account account=null;
		
		Connection conn=null;
		PreparedStatement st=null; 
		
		try {
			conn=DBUtils.getConnection();
			//st=conn.createStatement();
			
			String  sql="select * from  account where username=? and password=? ";
			 st=conn.prepareStatement(sql);
			//给占位符赋值
			 st.setString(1, _username);
			 st.setString(2, _password);
			
			// asfksadfsdf'  or 1=1 -- ''
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			if(rs.first()) {
				 int  accountid= rs.getInt("accountid");	
				 String  name=rs.getString("username");
				 String password=rs.getString("password");
				 String ip=rs.getString("ip");
				 String sex=rs.getString("sex");
				
				 account=new Account(accountid,name,password,ip,sex);
			}
			
			
			 
			 
			
			
			return account;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}

	@Override
	public void addToken(String token,Account acc) {
		// TODO Auto-generated method stub
        Account account=null;
		
		Connection conn=null;
		PreparedStatement st=null; 
		
		try {
			conn=DBUtils.getConnection();
			//st=conn.createStatement();
			
			String  sql="update account set token=? where accountid=?";
			 st=conn.prepareStatement(sql);
			//给占位符赋值
			 st.setString(1, token);
			st.setInt(2, acc.getAccountId());
			System.out.println(sql);
			st.execute();
//			ResultSet rs=st.executeQuery();
//			if(rs.first()) {
//				 int  accountid= rs.getInt("accountid");	
//				 String  name=rs.getString("username");
//				 String password=rs.getString("password");
//				 String ip=rs.getString("ip");
//				 String sex=rs.getString("sex");
//				
//				 account=new Account(accountid,name,password,ip,sex);
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public String findTokenByAccountid(int accountid) {
		Connection conn=null;
		PreparedStatement st=null; 
		
		try {
			conn=DBUtils.getConnection();
			//st=conn.createStatement();
			
			String  sql="select token from  account where accountid=? ";
			 st=conn.prepareStatement(sql);
			//给占位符赋值
			 st.setInt(1, accountid);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			if(rs.first()) {
				 String  token=rs.getString("token");
				 return token;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
		
	}

	@Override
	public boolean addAccount(Account acc) {
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="insert into account(username,password,ip,sex) values (?,?,?,?)";
			st=conn.prepareStatement(sql);
			//占位符赋值
			st.setString(1, acc.getUsername());
			String password = MD5Utils.GetMD5Code(acc.getPassword());
			st.setString(2, password);
			st.setString(3, acc.getIp());
			st.setString(4, acc.getSex());
			System.out.println(sql);
			st.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}


}

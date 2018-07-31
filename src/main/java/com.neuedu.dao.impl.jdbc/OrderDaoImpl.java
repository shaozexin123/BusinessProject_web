package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.DBUtils;

public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean createOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			
			st=conn.createStatement();
		
			String  sql="insert into userorder(order_no,user_id,shipping_id,payment,payment_type,postage,status,payment_time,create_time,update_time)"
					+ " values ("+userOrder.getOrder_no()+","+userOrder.getUser_id()+","+userOrder.getShipping_id()+","+userOrder.getPayment()+","+userOrder.getPayment_type()+","+userOrder.getPostage()+","+userOrder.getStatus()+",now(),now(),now())";
			System.out.println(sql);
			st.execute(sql);
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

	@Override
	public int generateOrderId() {
		// TODO Auto-generated method stub
		int orderid=(int) System.currentTimeMillis();
		return orderid;
	}

	@Override
	public PageMode<UserOrder> findUserOrderByPage(int pageno, int pagesize) {
		PageMode<UserOrder> pagemode=new PageMode<UserOrder>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			
//			String  sql="select id,name,pdesc,price,rule ,image,stock from  product";
			String  sqlcount="select count(id) from  userorder ";
			pst=conn.prepareStatement(sqlcount);
			rs=pst.executeQuery();
			if(rs.next()) {
			int totalcount=rs.getInt(1);
			System.out.println(totalcount);
			int totalpage=(totalcount%pagesize)==0?totalcount/pagesize:(totalcount/pagesize+1);
			System.out.println(totalpage);
			pagemode.setTotalPage(totalpage);
			
			}
			String  sql="select id, order_no,user_id,shipping_id,payment,payment_type,postage,status,payment_time,create_time,update_time from  userorder limit ?,?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (pageno-1)*pagesize);
			pst.setInt(2,pagesize);
			System.out.println(sql);
			rs=pst.executeQuery();
			List<UserOrder> list=new ArrayList<UserOrder>();
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 double payment=rs.getDouble("payment");
			 int postage=rs.getInt("postage");
			 long order_no=rs.getLong("order_no");
			 int user_id=rs.getInt("user_id");
			 int shipping_id=rs.getInt("shipping_id");
			 int payment_type=rs.getInt("payment_type");
			 int status=rs.getInt("status");
			 String payment_time = rs.getString("payment_time");
			 String create_time = rs.getString("create_time");
			 String update_time = rs.getString("update_time");
//			 Product product=new Product(id,name,pdesc,price,rule,image,stock);
			 UserOrder userorder=new UserOrder(id, order_no,user_id,shipping_id,payment,payment_type,postage,status,payment_time,create_time,update_time);
			 
			 list.add(userorder);
			}
			pagemode.setData(list);
			pagemode.setCurrentpage(pageno);
			return pagemode;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean deleteUserOrder(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "delete from userorder where id=" + id + "";
			System.out.println(sql);
			st.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public UserOrder findById(int id) {
		UserOrder userorder = null;
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "select id, order_no,user_id,shipping_id,payment,payment_type,postage,status,payment_time,create_time,update_time from  userorder where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			if (rs.first()) {
				
				 int  _id= rs.getInt("id");	
				 double payment=rs.getDouble("payment");
				 int postage=rs.getInt("postage");
				 long order_no=rs.getLong("order_no");
				 int user_id=rs.getInt("user_id");
				 int shipping_id=rs.getInt("shipping_id");
				 int payment_type=rs.getInt("payment_type");
				 int status=rs.getInt("status");
				 String payment_time = rs.getString("payment_time");
				 String create_time = rs.getString("create_time");
				 String update_time = rs.getString("update_time");
//				int _id = rs.getInt("id");
//				int parent_id = rs.getInt("parent_id");
//				String name = rs.getString("name");
//				int status = rs.getInt("status");
//				int sort_order = rs.getInt("sort_order");
//				String create_time = rs.getString("create_time");
//				String update_time = rs.getString("update_time");
				userorder = new UserOrder(id, order_no,user_id,shipping_id,payment,payment_type,postage,status,payment_time,create_time,update_time);
//				category.setId(_id);
//				category.setParent_id(parent_id);
//				category.setName(name);
//				category.setStatus(status);
//				category.setSort_order(sort_order);
//				category.setCreate_time(create_time);
//				category.setUpdate_time(update_time);

			}

			return userorder;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return userorder;
	}


}


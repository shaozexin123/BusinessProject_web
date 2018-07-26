package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CateGoryDao;
import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

public class CateGoryDaoImpl implements CateGoryDao {

	@Override
	public boolean addCateGory(CateGory category) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "insert into category(parent_id,name,status,sort_order,create_time,update_time) values (?,?,?,?,now(),now())";
			st = conn.prepareStatement(sql);
			// Õ¼Î»·û¸³Öµ
			st.setInt(1, category.getParent_id());
			st.setString(2, category.getName());
			st.setInt(3, category.getStatus());
			st.setInt(4, category.getSort_order());
			System.out.println(sql);
			st.execute();
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
	public List<CateGory> findAll() {
		// TODO Auto-generated method stub
		List<CateGory> categorys = new ArrayList<CateGory>();

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "select id,parent_id,name,status,sort_order,create_time,update_time from  category";
			st = conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int parent_id = rs.getInt("parent_id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				int sort_order = rs.getInt("sort_order");
				String create_time = rs.getString("create_time");
				String update_time = rs.getString("update_time");
				// String name=rs.getString("name");
				// String pdesc=rs.getString("pdesc");
				// double price=rs.getDouble("price");
				// String rule=rs.getString("rule");
				// String image=rs.getString("image");
				// int stock=rs.getInt("stock");
				CateGory category = new CateGory(id, parent_id, name, status, sort_order, create_time, update_time);
				categorys.add(category);
			}
			return categorys;

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

		return null;
	}

	@Override
	public boolean updateCateGory(CateGory category) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			// id,parent_id,name,status,sort_order,create_time,update_time
			String sql = "update category set parent_id=?,name=?,status=?,sort_order=?,update_time=now() where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, category.getParent_id());
			st.setString(2, category.getName());
			st.setInt(3, category.getStatus());
			st.setInt(4, category.getSort_order());
			st.setInt(5, category.getId());
			st.executeUpdate();
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
	public boolean deleteCateGory(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "delete from category where id=" + id + "";
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
	public CateGory findById(int id) {
		// TODO Auto-generated method stub
		// Product product=null;
		CateGory category = null;
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "select id,parent_id,name,status,sort_order,create_time,update_time from  category where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			if (rs.first()) {
				// product=new Product();
				category = new CateGory();
				// int _id= rs.getInt("id");
				// String name=rs.getString("name");
				// String pdesc=rs.getString("pdesc");
				// double price=rs.getDouble("price");
				// String rule=rs.getString("rule");
				// String image=rs.getString("image");
				int _id = rs.getInt("id");
				int parent_id = rs.getInt("parent_id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				int sort_order = rs.getInt("sort_order");
				String create_time = rs.getString("create_time");
				String update_time = rs.getString("update_time");

//				product.setId(_id);
//				product.setName(name);
//				product.setPrice(price);
//				product.setDesc(pdesc);
//				product.setRule(rule);
//				product.setImage(image);
				category.setId(_id);
				category.setParent_id(parent_id);
				category.setName(name);
				category.setStatus(status);
				category.setSort_order(sort_order);
				category.setCreate_time(create_time);
				category.setUpdate_time(update_time);

			}

			return category;

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

		return category;
	}

	@Override
	public PageMode<CateGory> findCateGoryByPage(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		PageMode<CateGory> pagemode=new PageMode<CateGory>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			
//			String  sql="select id,name,pdesc,price,rule ,image,stock from  product";
			String  sqlcount="select count(id) from  category ";
			pst=conn.prepareStatement(sqlcount);
			rs=pst.executeQuery();
			if(rs.next()) {
			int totalcount=rs.getInt(1);
			int totalpage=(totalcount%pagesize)==0?totalcount/pagesize:(totalcount/pagesize+1);
			pagemode.setTotalPage(totalpage);
			
			}
			String  sql="select id,parent_id,name,status,sort_order,create_time,update_time from  category limit ?,?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (pageno-1)*pagesize);
			pst.setInt(2,pagesize);
			System.out.println(sql);
			rs=pst.executeQuery();
			List<CateGory> categorys=new ArrayList<CateGory>();
			while(rs.next()) {
				int id = rs.getInt("id");
				int parent_id = rs.getInt("parent_id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				int sort_order = rs.getInt("sort_order");
				String create_time = rs.getString("create_time");
				String update_time = rs.getString("update_time");
				
				CateGory category = new CateGory(id, parent_id, name, status, sort_order, create_time, update_time);
				categorys.add(category);
			}
			pagemode.setData(categorys);
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

}

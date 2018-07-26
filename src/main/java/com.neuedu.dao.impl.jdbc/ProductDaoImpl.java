package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;

import com.neuedu.dao.ProductDao;
import com.neuedu.data.DataSource;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;

import com.neuedu.utils.DBUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="insert into product(name,pdesc,price,rule,image,stock,categoryid) values (?,?,?,?,?,?,?)";
			st=conn.prepareStatement(sql);
			//占位符赋值
			st.setString(1, product.getName());
			st.setString(2, product.getDesc());
			st.setDouble(3, product.getPrice());
			st.setString(4, product.getRule());
			st.setString(5, product.getImage());
			st.setInt(6, product.getStock());
			st.setInt(7, product.getCategoryid());
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

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> products=new ArrayList<Product>();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select id,name,pdesc,price,rule ,image,stock,categoryid from  product";
			st=conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			 while(rs.next()) {
			 int  id= rs.getInt("id");	
			 String  name=rs.getString("name");
			 String pdesc=rs.getString("pdesc");
			 double price=rs.getDouble("price");
			 String rule=rs.getString("rule");
			 String  image=rs.getString("image");
			 int stock=rs.getInt("stock");
			int	categoryid=rs.getInt("categoryid");
			 Product product=new Product(id,name,pdesc,price,rule,image,stock,categoryid);
			 
			 products.add(product);
			 
			 
			}
			
			return products;
			
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
//	public boolean updateProduct(Product product) {
//		// TODO Auto-generated method stub
//		Connection conn=null;
//		PreparedStatement st=null;
//		try {
//			conn=DBUtils.getConnection();
//			String  sql="update product set name=？,pdesc=？,price=？,rule=？,image=？,stock=？  where id=？";
//				st=conn.prepareStatement(sql);
//				//占位符赋值
//				st.setString(1, product.getName());
//				st.setString(2, product.getDesc());
//				st.setDouble(3, product.getPrice());
//				st.setString(4, product.getRule());
//				st.setString(5, product.getImage());
//				st.setInt(6, product.getStock());
//				st.setInt(7, product.getId());
//				System.out.println(sql);
//				st.execute();
//				return true;
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				try {
//					DBUtils.close(conn, st);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		
//		
//		return false;
//	}
	public boolean updateProduct(Product product) {
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="update product set name=?,pdesc=?,price=?,rule=?,image=?,stock=?,categoryid=? where id=?";
			st=conn.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setString(2, product.getDesc());
			st.setDouble(3, product.getPrice());
			st.setString(4, product.getRule());
			st.setString(5, product.getImage());
			st.setInt(6, product.getStock());
			st.setInt(7, product.getId());
            st.setInt(8, product.getCategoryid());
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

	@Override
	public boolean deleteProduct(int id) {
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="delete from product where id="+id+"";
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
	public Product findById(int id) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				Product product=null;
				
				Connection conn=null;
				PreparedStatement st=null;
				try {
					conn=DBUtils.getConnection();
					
					String  sql="select id,name,pdesc,price,rule ,image,stock,categoryid from  product where id=?";
					st=conn.prepareStatement(sql);
					st.setInt(1, id);
					System.out.println(sql);
					ResultSet rs=st.executeQuery();
					
						
					     if(rs.first()) {
						product=new Product();
						 int  _id= rs.getInt("id");	
						 String  name=rs.getString("name");
						 String pdesc=rs.getString("pdesc");
						 double price=rs.getDouble("price");
						 String rule=rs.getString("rule");
						 String  image=rs.getString("image");
						 int stock=rs.getInt("stock");
						 int categoryid=rs.getInt("categoryid");
						 product.setId(_id);
                         product.setName(name);
                         product.setPrice(price);
                         product.setDesc(pdesc);
                         product.setRule(rule);
                         product.setImage(image);
                         product.setStock(stock);
                         product.setCategoryid(categoryid);
							}
                         
                         return product;
					
					
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
				
		return product;
	}

	@Override
	public PageMode<Product> findProductByPage(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		PageMode<Product> pagemode=new PageMode<Product>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			
//			String  sql="select id,name,pdesc,price,rule ,image,stock from  product";
			String  sqlcount="select count(id) from  product ";
			pst=conn.prepareStatement(sqlcount);
			rs=pst.executeQuery();
			if(rs.next()) {
			int totalcount=rs.getInt(1);
			System.out.println(totalcount);
			int totalpage=(totalcount%pagesize)==0?totalcount/pagesize:(totalcount/pagesize+1);
			System.out.println(totalpage);
			pagemode.setTotalPage(totalpage);
			
			}
			String  sql="select id,name,pdesc,price,rule ,image,stock,categoryid from  product limit ?,?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (pageno-1)*pagesize);
			pst.setInt(2,pagesize);
			System.out.println(sql);
			rs=pst.executeQuery();
			List<Product> list=new ArrayList<Product>();
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 String  name=rs.getString("name");
			 String pdesc=rs.getString("pdesc");
			 double price=rs.getDouble("price");
			 String rule=rs.getString("rule");
			 String  image=rs.getString("image");
			 int stock=rs.getInt("stock");
			 int categoryid=rs.getInt("categoryid");
			 Product product=new Product(id,name,pdesc,price,rule,image,stock,categoryid);
			 
			 list.add(product);
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
	public static void main(String[] args) {
        ProductDaoImpl dao =new ProductDaoImpl();
        List<Product> products = dao.findAll();
        String json = JSONArray.toJSONString(products);
        System.out.println(json);
    }
	public String findAllByJson() {
		ProductDaoImpl dao =new ProductDaoImpl();
        List<Product> products = dao.findAll();
        String json = JSONArray.toJSONString(products);
        return json;
	}
}

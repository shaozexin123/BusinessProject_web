package com.neuedu.dao.impl.jdbc;//package com.neuedu.dao.impl.jdbc;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.neuedu.dao.CartDao;
//import com.neuedu.dao.ProductDao;
//import com.neuedu.entity.Cart;
//import com.neuedu.entity.PageMode;
//import com.neuedu.entity.Product;
//import com.neuedu.utils.DBUtils;
//
//public class CartDaoImpl implements CartDao {
//
//	ProductDao productDao=new ProductDaoImpl();
//	@Override
//	public boolean addCart(Cart cart) {
//		// TODO Auto-generated method stub
//
//		Connection conn=null;
//		Statement st=null;
//		try {
//			conn=DBUtils.getConnection();
//			st=conn.createStatement();
//			//System.out.println(cart.getProduct().getId());
//			//System.out.println("+++++++++++++++++++++++++++++++++++");cart.getProductid()
//			String  sql="insert into cart(productid,productnum,productprice,totalprice) values ("+cart.getProduct().getId()+","+cart.getProductNum()+","+cart.getProductprice()+","+(cart.getProductprice()*cart.getProductNum())+")";
//			System.out.println(sql);
//			st.execute(sql);
//			return true;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				DBUtils.close(conn, st);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//
//
//
//		return false;
//	}
//
//	@Override
//	public boolean deleteCart(int id) {
//		// TODO Auto-generated method stub
//
//
//		Connection conn=null;
//		Statement st=null;
//		try {
//			conn=DBUtils.getConnection();
//			st=conn.createStatement();
//			String  sql="delete from cart where id="+id+"";
//			System.out.println(sql);
//			st.execute(sql);
//			return true;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				DBUtils.close(conn, st);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//
//
//		return false;
//	}
//
//	@Override
//	public boolean updataeCart(Cart cart) {
//		// TODO Auto-generated method stub
//
//		Connection conn=null;
//		Statement st=null;
//		try {
//			conn=DBUtils.getConnection();
//			st=conn.createStatement();
//			String  sql="update cart set productnum="+cart.getProductNum()+",totalprice="+cart.getTotalprice()+"  where id="+cart.getId()+"";
//			System.out.println(sql);
//			st.execute(sql);
//			return true;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				DBUtils.close(conn, st);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//
//		return false;
//	}
//
//	@Override
//	public List<Cart> findAllCart() {
//		// TODO Auto-generated method stub
//
//	List<Cart> carts=new ArrayList<Cart>();
//
//		Connection conn=null;
//		Statement st=null;
//		try {
//			conn=DBUtils.getConnection();
//			st=conn.createStatement();
//			String  sql="select id,productid,productnum,productprice,totalprice from  cart";
//			System.out.println(sql);
//			ResultSet rs=st.executeQuery(sql);
//			while(rs.next()) {
//			 int  id= rs.getInt("id");
//			 int  productid=rs.getInt("productid");
//			 int num=rs.getInt("productnum");
//			 double productprice=rs.getDouble("productprice");
//			 double totalprice=rs.getDouble("totalprice");
//
//
//			 Cart cart=new Cart();
//			 cart.setId(id);
//			 cart.setProductNum(num);
//			 cart.setProductid(productid);
//			 cart.setProductprice(productprice);
//			 cart.setTotalprice(totalprice);
//			 carts.add(cart);
//
//
//			}
//
//			return carts;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				DBUtils.close(conn, st);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//
//		return null;
//	}
//
//	@Override
//	public int getCartNum() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public boolean updateCart(int id, int num) {
//		// TODO Auto-generated method stub
//		Connection conn=null;
//		Statement st=null;
//		try {
//			conn=DBUtils.getConnection();
//			st=conn.createStatement();
//			String  sql="update cart set productnum="+num+" "+" where id="+id+"";
//			System.out.println(sql);
//			st.execute(sql);
//			return true;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				DBUtils.close(conn, st);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//
//		return false;
//	}
//
//	@Override
//	public void clearCart() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	/**
//	 * 按id查询购物车
//	 * */
//	public Cart findById(int id) {
//		// TODO Auto-generated method stub
//		Cart cart=null;
//
//		Connection conn=null;
//		PreparedStatement st=null;
//		try {
//			conn=DBUtils.getConnection();
//
//			String  sql="select id,productid,productNum,productprice,totalprice from  cart where id=?";
//			st=conn.prepareStatement(sql);
//			st.setInt(1, id);
//			System.out.println(sql);
//			ResultSet rs=st.executeQuery();
//
//
//			     if(rs.first()) {
//				cart=new Cart();
////				 int  _id= rs.getInt("id");
////				 String  name=rs.getString("name");
////				 String pdesc=rs.getString("pdesc");
////				 double price=rs.getDouble("price");
////				 String rule=rs.getString("rule");
////				 String  image=rs.getString("image");
////				 int stock=rs.getInt("stock");
////
////				 product.setId(_id);
////                 product.setName(name);
////                 product.setPrice(price);
////                 product.setDesc(pdesc);
////                 product.setRule(rule);
////                 product.setImage(image);
////                 product.setStock(stock);
//				int  _id= rs.getInt("id");
//				int productid=rs.getInt("productid");
//				int productNum=rs.getInt("productNum");
//				double productprice=rs.getDouble("productprice");
//				double totalprice=rs.getDouble("totalprice");
//				cart.setId(_id);
//				cart.setProductid(productid);
//				cart.setProductNum(productNum);
//				cart.setProductprice(productprice);
//				cart.setTotalprice(totalprice);
//					}
//
//                 return cart;
//
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				DBUtils.close(conn, st);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//return cart;
//	}
//
//	@Override
//	public PageMode<Cart> findCartByPage(int pageno, int pagesize) {
//		PageMode<Cart> pagemode=new PageMode<Cart>();
//		Connection conn=null;
//		PreparedStatement pst=null;
//		ResultSet rs=null;
//		try {
//			conn=DBUtils.getConnection();
//
////			String  sql="select id,name,pdesc,price,rule ,image,stock from  product";
//			String  sqlcount="select count(id) from  cart ";
//			pst=conn.prepareStatement(sqlcount);
//			rs=pst.executeQuery();
//			if(rs.next()) {
//			int totalcount=rs.getInt(1);
////			System.out.println(totalcount);
//			int totalpage=(totalcount%pagesize)==0?totalcount/pagesize:(totalcount/pagesize+1);
////			System.out.println(totalpage);
//			pagemode.setTotalPage(totalpage);
//
//			}
//			String  sql="select id,productid,productnum,productprice,totalprice from  cart limit ?,?";
//			pst=conn.prepareStatement(sql);
//			pst.setInt(1, (pageno-1)*pagesize);
//			pst.setInt(2,pagesize);
//			System.out.println(sql);
//			rs=pst.executeQuery();
//			List<Cart> carts=new ArrayList<Cart>();
//			while(rs.next()) {
//			 int  id= rs.getInt("id");
//			 int  productid= rs.getInt("productid");
//			 int  productnum= rs.getInt("productnum");
//			 double productprice=rs.getDouble("productprice");
//			 double totalprice=rs.getDouble("totalprice");
//
////			 String  name=rs.getString("name");
////			 String pdesc=rs.getString("pdesc");
////			 double price=rs.getDouble("price");
////			 String rule=rs.getString("rule");
////			 String  image=rs.getString("image");
////			 int stock=rs.getInt("stock");
//			 Cart cart=new Cart(id,productid,productnum,productprice,totalprice);
////		 Product product=new Product(id,name,pdesc,price,rule,image,stock);
//			 carts.add(cart);
////			 list.add(product);
//			}
//			pagemode.setData(carts);
//			pagemode.setCurrentpage(pageno);
//			return pagemode;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				DBUtils.close(conn, pst);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//
//}

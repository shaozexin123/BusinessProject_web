package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;
import com.neuedu.service.CartService;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.CartServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;
@WebServlet("/view/cart")
public class CartController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8574912870396136419L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String operation=req.getParameter("operation");
		
		if(operation!=null&&!operation.equals("")) {
			if(operation.equals("1")) {
				
				addCart(req,resp);
			}else if(operation.equals("2")) {
				 findAll(req,resp);
			}else if(operation.equals("3")) {
				updataeCart(req,resp);
			}else if(operation.equals("4")) {
				deleteCart(req,resp);
			}else if(operation.equals("5")) {
				findCartById(req,resp);
			}else if(operation.equals("6")) {
				findProductById(req,resp);
			}
		}else {
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
  CartService cartService=new CartServiceImpl();
	
	/**
	 * 添加购物车
	 **/
  public void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cart cart=new Cart();
//		System.out.println("========================");
		int id=0;
		int productNum=0;
		boolean result=false;
		try {
			id=Integer.parseInt(req.getParameter("id"));
//			req.getd
			System.out.println(id+"==69");
			productNum=Integer.parseInt(req.getParameter("productNum"));
			ProductController pc=new ProductController();
			Product product=pc.findProductById(id);
			double totalprice=productNum*product.getPrice();
			if(true) {
			if(product!=null&&product.getStock()>=productNum) {
			cart.setProduct(product);
//			cart.setProductid(product.getId());
			cart.setProductNum(productNum);
			cart.setProductprice(product.getPrice());
			cart.setTotalprice(totalprice);
			result=addCart(cart);
			if(result) {
				System.out.println("商品添加成功");
			    findAll(req, resp);
			    product.setStock(product.getStock()-productNum);
				product.setId(id);
				product.setDesc(product.getDesc());
				product.setImage(product.getImage());
				product.setName(product.getName());
				product.setPrice(product.getPrice());
				product.setRule(product.getRule());
				product.setCategoryid(product.getCategoryid());
				pc.updateProduct(product);
			}else {
				System.out.println("商品添加失败");
			}
		}else {
			System.out.println("商品添加失败");
		}
		}else {
			req.getRequestDispatcher("addcartfail.jsp").forward(req, resp);
		}
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public boolean  addCart(Cart cart) {
		return cartService.addCart(cart);
	}
	/**
	 * 删除
	 * */
	  public void deleteCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	int id=0;
	    	try {
	    	 id=Integer.parseInt(req.getParameter("id"));
	    	 Cart cart=cartService.findCartById(id);
	    	 if(cart!=null) {
	    	 System.out.println(id);
	    		 if(cartService.deleteCart(id)) {
	    			 System.out.println("商品删除成功");
	    			 findAll(req, resp);
	    		 }else {
	    			 System.out.println("商品删除失败");
	    		 }
	    	 }
	    	 else {
	    		 System.out.println("商品删除失败");
	    	 }
	    	}catch(NumberFormatException e) {
	    		e.printStackTrace();
	    	}
	    }
	public boolean  deleteCart(int id) {
		return cartService.deleteCart(id);
	}
	/**
	 * 修改购物车
	 * */
	public boolean  updataeCart(Cart cart) {
		
		return false;
	}
	/**
	 * 查询购物车
	 * */
	public  void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//    	List<Cart> carts= cartService.findAllCart();
//    	req.setAttribute("carts", carts);
//    	req.getRequestDispatcher("/view/showcart.jsp").forward(req, resp);
		String pageno=req.getParameter("pageno");
    	String pageNum=req.getParameter("pagesize");
		int _pageno=1;
		int _pageNum=5;
		try {
			if(pageno!=null&pageNum!=null) {
			_pageno=Integer.parseInt(pageno);
			_pageNum=Integer.parseInt(pageNum);
			}
//			int id=Integer.parseInt(req.getParameter("id"));
			PageMode<Cart> pagemode=cartService.findCartByPage(_pageno,_pageNum);
			//List<Product> products= pService.findAll();
			req.setAttribute("pagemode", pagemode);
			req.getRequestDispatcher("showcart.jsp").forward(req, resp);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
    }
	public List<Cart> findAllCart(){
		
		return cartService.findAllCart();
	}
	/**
	 * 获取购物车中商品数量
	 * */
	public int  getCartNum() {
		return cartService.getCartNum();
	};
	
//	/**修改购物车商品数量
//	 * @param  id  要修改的购物车的Id
//	 * @param  num 修改后的数量
//	 * */
	public void updataeCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Cart cart=new Cart();
//		String name= req.getParameter("pname");
//		System.out.println(name);
//		String image= req.getParameter("pimage");
//		String desc= req.getParameter("pdesc");
//		String rule= req.getParameter("prule");
//		double price=0.0;
    	int id=0;
		int productNum=0;

		int productid=0;
		double productprice=0.0;
		double totalprice=0.0;
		boolean result=false;
		try {
//			price=Double.parseDouble(req.getParameter("price"));
			id=Integer.parseInt(req.getParameter("id"));
			productNum=Integer.parseInt(req.getParameter("productNum"));
//			productid=Integer.parseInt(req.getParameter("productid"));
			ProductController pc=new ProductController();
			Product product=pc.findProductById(id);
			productprice=Double.parseDouble(req.getParameter("productprice"));
			System.out.println("productNum="+productNum+"productprice="+req.getParameter("productprice"));
			totalprice=productprice*productNum;
			System.out.println("totalprice======"+totalprice);
			cart.setId(id);
			cart.setProduct(product);
//			cart.setProductid(productid);
			cart.setProductNum(productNum);
			cart.setTotalprice(totalprice);
//			product.setDesc(desc);
//			product.setImage(image);
//			product.setName(name);
//			product.setPrice(price);
//			product.setRule(rule);
//			product.setStock(stock);
//			result= pService.updateProduct(product);
			result= cartService.updataeCart(cart);
			System.out.println(cart.getTotalprice()+"++++++++++++++");
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("购物车修改成功");
			findAll(req, resp);
		}else {
			System.out.println("购物车修改失败");
		}
    }
	/**
	 * 查询购物车中的购物信息
	 * */
	public void findCartById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id=0;
    	try {
    	 id=Integer.parseInt(req.getParameter("id"));
    	 Cart cart =cartService.findCartById(id);
    	 req.setAttribute("cart", cart);
    	 if(cart!=null) {
        	 System.out.println("查询成功");
        	 req.getRequestDispatcher("/view/updatecart.jsp").forward(req, resp);
         }
    	 else {
				System.out.println("查询不成功");
			}
         
    	 
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
    	
    }
	/**
	 * 查询商品
	 * */
	 public void findProductById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	int id=0;
	    	try {
	    	 ProductService pService=new ProductServiceImpl();
	    	 id=Integer.parseInt(req.getParameter("id"));
	    	 Product product=pService.findProductById(id);
	    	 req.setAttribute("product", product);
	    	 if(product!=null) {
	        	 System.out.println("查询成功");
	        	 req.getRequestDispatcher("/view/addcart.jsp").forward(req, resp);
	         }
	    	 else {
					System.out.println("查询不成功");
				}
	         
	    	 
	    	}catch(NumberFormatException e) {
	    		e.printStackTrace();
	    	}
	    	
	    }
}

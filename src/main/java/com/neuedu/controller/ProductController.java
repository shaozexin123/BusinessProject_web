package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.dao.impl.jdbc.ProductDaoImpl;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;
@WebServlet("/view/product")
public class ProductController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -895564076582129225L;
	ProductService  pService=new ProductServiceImpl();
			
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String operation=req.getParameter("operation");
		if(operation!=null&&!operation.equals("")) {
			if(operation.equals("1")) {
				addProduct(req,resp);
			}else if(operation.equals("2")) {
				findAll(req,resp);
			}else if(operation.equals("3")) {
				updateProduct(req,resp);
			}else if(operation.equals("4")) {
				deleteProduct(req,resp);
			}else if(operation.equals("5")) {
				findProductById(req,resp);
			}else if(operation.equals("6")) {
				findById(req,resp);
			}else if(operation.equals("7")) {
				findAllByJson(req,resp);
			}
		}else {
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	public void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product=new Product();
		String name= req.getParameter("pname");
		String image= req.getParameter("pimage");
		String desc= req.getParameter("pdesc");
		String rule= req.getParameter("prule");
		double price=0.0;
		int stock=0;
		boolean result=false;
		try {
			price=Double.parseDouble(req.getParameter("price"));
			stock=Integer.parseInt(req.getParameter("stock"));
			product.setDesc(desc);
			product.setImage(image);
			product.setName(name);
			product.setPrice(price);
			product.setRule(rule);
			product.setStock(stock);
			result= addProduct(product);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("商品添加成功");
			findAll(req, resp);
		}else {
			System.out.println("商品添加失败");
		}
	}
	
	
	/**添加商品*/
    public  boolean addProduct(Product product) {
    	return pService.addProduct(product);
    }	
    /**查询商品
     * @throws IOException 
     * @throws ServletException */
//    public  void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//    	List<Product> products= pService.findAll();
//    	req.setAttribute("products", products);
//    	req.getRequestDispatcher("/view/showproduct.jsp").forward(req, resp);
//    }
    public  void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    	//
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
			PageMode<Product> pagemode=pService.findProductByPage(_pageno,_pageNum);
			//List<Product> products= pService.findAll();
			req.setAttribute("pagemode", pagemode);
			req.getRequestDispatcher("showproductbypage.jsp").forward(req, resp);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
        //分页模型
		
    }
    /**修改商品
     * @throws IOException 
     * @throws ServletException */
    public void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Product product=new Product();
		String name= req.getParameter("pname");
		System.out.println(name);
		String image= req.getParameter("pimage");
		String desc= req.getParameter("pdesc");
		String rule= req.getParameter("prule");
		double price=0.0;
		int stock=0;
		boolean result=false;
		try {
			price=Double.parseDouble(req.getParameter("price"));
			stock=Integer.parseInt(req.getParameter("stock"));
			int id=Integer.parseInt(req.getParameter("id"));
			product.setId(id);
			product.setDesc(desc);
			product.setImage(image);
			product.setName(name);
			product.setPrice(price);
			product.setRule(rule);
			product.setStock(stock);
			result= pService.updateProduct(product);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("商品修改成功");
			findAll(req, resp);
		}else {
			System.out.println("商品修改失败");
		}
    }
    public  boolean  updateProduct(Product product) {
    	return pService.updateProduct(product);
    }
    /**删除商品
     * @throws IOException 
     * @throws ServletException */
    public void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id=0;
    	try {
    	 id=Integer.parseInt(req.getParameter("id"));
    	 Product product=pService.findProductById(id);
    	 if(product!=null) {
    		 if(pService.deleteProduct(id)) {
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
    public  boolean deleteProduct(int id) {
    	return pService.deleteProduct(id);
    }
    //
    public void findProductById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id=0;
    	try {
    	 id=Integer.parseInt(req.getParameter("id"));
    	 Product product=pService.findProductById(id);
    	 req.setAttribute("product", product);
    	 if(product!=null) {
        	 System.out.println("查询成功");
        	 req.getRequestDispatcher("/view/updateproduct.jsp").forward(req, resp);
         }
    	 else {
				System.out.println("查询不成功");
			}
         
    	 
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
    	
    }
    public Product findProductById(int id) {
    	return pService.findProductById(id);
    }
    private void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=0;
    	try {
    	 id=Integer.parseInt(req.getParameter("id"));
    	 Product product=pService.findProductById(id);
    	 req.setAttribute("product", product);
    	 if(product!=null) {
        	 System.out.println("查询成功");
        	 req.getRequestDispatcher("/view/showfindbyid.jsp").forward(req, resp);
         }
    	 else {
				System.out.println("查询不成功");
			}
         
    	 
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
	}
    public void findAllByJson(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
		ProductDaoImpl dao =new ProductDaoImpl();
        List<Product> products = dao.findAll();
        String json = JSONArray.toJSONString(products);
        resp.getWriter().print(json);
        System.out.println(json);
	}
}

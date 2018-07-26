package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;
import com.neuedu.service.CateGoryService;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.CateGoryServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;

@WebServlet("/view/category")
public class CateGoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1631046995858860367L;
    CateGoryService  cService=new CateGoryServiceImpl();
			
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String operation=req.getParameter("operation");
		if(operation!=null&&!operation.equals("")) {
			if(operation.equals("1")) {
				addCateGory(req,resp);
			}else if(operation.equals("2")) {
				findAll(req,resp);
			}else if(operation.equals("3")) {
				updateCateGory(req,resp);
			}else if(operation.equals("4")) {
				deleteCateGory(req,resp);
			}else if(operation.equals("5")) {
				findCategoryById(req,resp);
			}else if(operation.equals("6")) {
				findById(req,resp);
			}else if(operation.equals("7")) {
				findByPage(req,resp);
			}
		}else {
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	public void addCateGory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CateGory category=new CateGory();
		//parene_id,name,status,sort_order,create_time,update_time
		
		int parent_id=0;
		int status=0;
		int sort_order=0; 
		boolean result=false;
		try {
			String name= req.getParameter("name");
			parent_id=Integer.parseInt(req.getParameter("parent_id"));
			status=Integer.parseInt(req.getParameter("status"));
			sort_order=Integer.parseInt(req.getParameter("sort_order"));
//			String create_time=req.getParameter("create_time");
//			String update_time=req.getParameter("update_time");
			category.setParent_id(parent_id);
			category.setName(name);
			category.setStatus(status);
			category.setSort_order(sort_order);
//			category.setCreate_time(create_time);
//			category.setUpdate_time(update_time);
//			product.setDesc(desc);
//			product.setImage(image);
//			product.setName(name);
//			product.setPrice(price);
//			product.setRule(rule);
//			product.setStock(stock);
//			result= addProduct(product);
			result=addCateGory(category);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("商品类别添加成功");
			findAll(req, resp);
		}else {
			System.out.println("商品类别添加失败");
		}
	}
	
	
	/**添加商品类别*/
    public  boolean addCateGory(CateGory category) {
    	return cService.addCateGory(category);
    }
    /**查询商品类别
     * @throws IOException 
     * @throws ServletException */
    public  void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//    	List<CateGory> categorys= cService.findAll();
//    	req.setAttribute("categorys", categorys);
//    	req.getRequestDispatcher("/view/showcategory.jsp").forward(req, resp);
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
			PageMode<CateGory> pagemode=cService.findCateGoryByPage(_pageno,_pageNum);
			//List<Product> products= pService.findAll();
			req.setAttribute("pagemode", pagemode);
			req.getRequestDispatcher("showcategorybypage.jsp").forward(req, resp);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
    }
    /**修改商品类别
     * @throws IOException 
     * @throws ServletException */
    public void updateCateGory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	CateGory category=new CateGory();
//		String name= req.getParameter("pname");
//		String image= req.getParameter("pimage");
//		String desc= req.getParameter("pdesc");
//		String rule= req.getParameter("prule");
    	String name=req.getParameter("name");
//    	String create_time=req.getParameter("create_time");
//		String update_time=req.getParameter("update_time");
    	int parent_id=0;
		int status=0;
		int sort_order=0; 
		boolean result=false;
		try {
			parent_id=Integer.parseInt(req.getParameter("parent_id"));
			status=Integer.parseInt(req.getParameter("status"));
			sort_order=Integer.parseInt(req.getParameter("sort_order"));
			int id=Integer.parseInt(req.getParameter("id"));
//			product.setId(id);
//			product.setDesc(desc);
//			product.setImage(image);
//			product.setName(name);
//			product.setPrice(price);
//			product.setRule(rule);
//			product.setStock(stock);
			category.setId(id);
			category.setParent_id(parent_id);
			category.setName(name);
			category.setStatus(status);
			category.setSort_order(sort_order);
//			category.setCreate_time(create_time);
//			category.setUpdate_time(update_time);
			result= cService.updateCateGory(category);
			System.out.println(category);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("商品类别修改成功");
			findAll(req, resp);
		}else {
			System.out.println("商品类别修改失败");
		}
    }
    public  boolean  updateCateGory(CateGory category) {
    	return cService.updateCateGory(category);
    }
    //
    public void findCategoryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id=0;
    	try {
    	 id=Integer.parseInt(req.getParameter("id"));
    	 CateGory category=cService.findCateGoryById(id);
    	 req.setAttribute("category", category);
    	 if(category!=null) {
        	 System.out.println("查询成功");
        	 req.getRequestDispatcher("/view/updatecategory.jsp").forward(req, resp);
         }
    	 else {
				System.out.println("查询不成功");
			}
         
    	 
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
    	
    }
    public CateGory findCaetgoryById(int id) {
    	return cService.findCateGoryById(id);
    }
    //按id单个查询
    private void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=0;
    	try {
    	 id=Integer.parseInt(req.getParameter("id"));
    	 CateGory category=cService.findCateGoryById(id);
    	 req.setAttribute("category", category);
    	 if(category!=null) {
        	 System.out.println("查询成功");
        	 req.getRequestDispatcher("/view/findcategorybyid.jsp").forward(req, resp);
         }
    	 else {
				System.out.println("查询不成功");
			}
         
    	 
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
	}
    /**删除商品
     * @throws IOException 
     * @throws ServletException */
    public void deleteCateGory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id=0;
    	try {
    	 id=Integer.parseInt(req.getParameter("id"));
    	 CateGory category=cService.findCateGoryById(id);
    	 if(category!=null) {
    		 if(cService.deleteCateGory(id)) {
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
    public  boolean deleteCateGory(int id) {
    	return cService.deleteCateGory(id);
    }
    public void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	String pageno=req.getParameter("pageno");
        //分页模型
		PageMode<CateGory> pagemode=cService.findCateGoryByPage(Integer.parseInt(pageno), 4);
		req.setAttribute("pagemode", pagemode);
		req.getRequestDispatcher("showcategorybypage.jsp").forward(req, resp);
    
    }
}

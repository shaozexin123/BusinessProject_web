package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.entity.Cart;
import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;
@WebServlet("/view/order")
public class OrderController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1349467707596946732L;
	OrderService orderService=new OrderServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String operation=req.getParameter("operation");
		if(operation!=null&&!operation.equals("")) {
			if(operation.equals("1")) {
				createOrder(req,resp);
			}else if(operation.equals("2")) {
//				findAll(req,resp);
			}else if(operation.equals("3")) {
//				updateProduct(req,resp);
			}else if(operation.equals("4")) {
				deleteOrder(req,resp);
			}else if(operation.equals("5")) {
//				findProductById(req,resp);
			}else if(operation.equals("6")) {
//				findById(req,resp);
			}
		}else {
			
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	public  void  createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserOrder userorder=new UserOrder();
		HttpSession session=req.getSession();
		Object accobj=session.getAttribute("acc");
//		user_id,shipping_id,payment,payment_type,postage,status
		long order_no=orderService.generateOrderNo();
		int shipping_id=0;
		int id=0;
		int user_id=0;
		double payment=0.0;
		int payment_type=0;
		int postage=0;
		int status=0;
		boolean result=false;
		try {
			id=Integer.parseInt(req.getParameter("id"));
			ProductController pc=new ProductController();
			Product product=pc.findProductById(id);
			payment=Double.parseDouble(req.getParameter("totalprice"));
			if(accobj!=null) {
				Account acc=(Account)accobj;
			    user_id=acc.getAccountId();
			}
			userorder.setOrder_no(order_no);
			userorder.setUser_id(user_id);
			userorder.setShipping_id(shipping_id);
			userorder.setPayment(payment);
			userorder.setPayment_type(payment_type);
			userorder.setPostage(postage);
			userorder.setStatus(status);
			result=createOrder(userorder);
			if(result) {
				System.out.println("下单成功");
				findAll(req, resp);
			}else {
				System.out.println("下单失败");
			}
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		
	}
	public  boolean  createOrder(UserOrder userorder) {
		return orderService.createOrder(userorder);
	}
	public  void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		String pageno=req.getParameter("pageno");
    	String pageNum=req.getParameter("pagesize");
		int _pageno=1;
		int _pageNum=5;
		try {
			if(pageno!=null&pageNum!=null) {
			_pageno=Integer.parseInt(pageno);
			_pageNum=Integer.parseInt(pageNum);
			}
			PageMode<UserOrder> pagemode=orderService.findUserOrderByPage(_pageno,_pageNum);
			req.setAttribute("pagemode", pagemode);
			req.getRequestDispatcher("showorder.jsp").forward(req, resp);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
    }
	private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=0;
    	try {
    	 id=Integer.parseInt(req.getParameter("id"));
    	 UserOrder userorder=orderService.findUserOrderById(id);
    	 if(userorder!=null) {
    		 if(orderService.deleteUserOrder(id)) {
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
}

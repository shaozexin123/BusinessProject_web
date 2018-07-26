package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.entity.Product;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

@WebServlet("/register.do")
public class Registercontroller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1172271472291089049L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		ILoginService loginService = new LoginServiceImpl();
		Account acc=new Account();
		String username= req.getParameter("username");
		String password= req.getParameter("password");
		if(username!=null&password!=null&!username.equals("")&!password.equals("")) {
			
		String ip= req.getParameter("ip");
		String sex= req.getParameter("sex");
		boolean result=false;
		try {
//			product.setDesc(desc);
//			product.setImage(image);
//			product.setName(name);
//			product.setPrice(price);
//			product.setRule(rule);
//			product.setStock(stock);
			acc.setIp(ip);
			acc.setPassword(password);
			acc.setUsername(username);
			acc.setSex(sex);
			result= loginService.addAccount(acc);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("×¢²á³É¹¦");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else {
			System.out.println("×¢²áÊ§°Ü");
			req.getRequestDispatcher("failzhuce.jsp").forward(req, resp);
		}
		}else {
			System.out.println("×¢²áÊ§°Ü");
			req.getRequestDispatcher("failzhuce.jsp").forward(req, resp);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}

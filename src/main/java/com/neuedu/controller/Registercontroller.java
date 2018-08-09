package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet("/register.do")
public class Registercontroller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1172271472291089049L;
	@Autowired
	ILoginService loginService ;
	@Override
	public void init() throws ServletException {

		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,this.getServletContext());

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
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
			acc.setPassword(MD5Utils.GetMD5Code(password));
			acc.setUsername(username);
			acc.setSex(sex);
			result= loginService.addAccount(acc);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("ע��ɹ�");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else {
			System.out.println("ע��ʧ��");
			req.getRequestDispatcher("failzhuce.jsp").forward(req, resp);
		}
		}else {
			System.out.println("ע��ʧ��");
			req.getRequestDispatcher("failzhuce.jsp").forward(req, resp);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}

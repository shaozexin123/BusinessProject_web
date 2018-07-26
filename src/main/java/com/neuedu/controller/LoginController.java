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
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

/**
 * 负责接收用户用户名、密码
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2127867611341493332L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ILoginService loginService = new LoginServiceImpl();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Account acc = loginService.doLogin(username, MD5Utils.GetMD5Code(password));
		if (acc != null) {
			// 登录成功
			Cookie un_cookis = new Cookie("username", username);
			un_cookis.setMaxAge(7*24*3600);
			resp.addCookie(un_cookis);
			Cookie pwd_cookis = new Cookie("password", MD5Utils.GetMD5Code(password));
			pwd_cookis.setMaxAge(7*24*3600);
			resp.addCookie(pwd_cookis);
			
			
			//生成token，放到数据库
			long time=System.currentTimeMillis();
			String token=MD5Utils.GetMD5Code(username+password+time);
			loginService.addToken(token, acc);
//			放到会话域
			HttpSession session=req.getSession();
//			session.setMaxInactiveInterval(7*24*3600);
			session.setAttribute("token", token);
			session.setAttribute("acc", acc);
			req.getRequestDispatcher("view/home.jsp").forward(req, resp);
		} else {
			// 登录失败
			req.getRequestDispatcher("fail.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}

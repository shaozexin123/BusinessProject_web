package com.neuedu.controller.front;

import com.google.gson.Gson;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FrontLoginController
 */
@WebServlet("/front/login.do")
public class FrontLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
      ILoginService loginService=new LoginServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String method=request.getParameter("method");
		Account acc = loginService.doLogin(username, MD5Utils.GetMD5Code(password));
		if(acc!=null) {
			//登录成功
			/**
			 * JOSN username,password,id,sex
			 * {
			 *   "username":"admin",
			 *   "password":"admin",
			 *   "ip":null,
			 *   "sex":"man"
			 *   }
			 * */
			
			
//			StringBuffer sbuffer=new StringBuffer("{");
//			//"username":"admin",
//			sbuffer.append("\"");
//			sbuffer.append("username");
//			sbuffer.append("\"");
//			sbuffer.append(":");
//			sbuffer.append("\"");
//			sbuffer.append(acc.getUsername());
//			sbuffer.append("\"");
//			sbuffer.append(",");
//			
//			//"password":"admin",
//			sbuffer.append("\"");
//			sbuffer.append("password");
//			sbuffer.append("\"");
//			sbuffer.append(":");
//			sbuffer.append("\"");
//			sbuffer.append(acc.getPassword());
//			sbuffer.append("\"");
//			sbuffer.append(",");
//			
//			//"ip":null,
//			sbuffer.append("\"");
//			sbuffer.append("ip");
//			sbuffer.append("\"");
//			sbuffer.append(":");
//			sbuffer.append("\"");
//			sbuffer.append(acc.getIp());
//			sbuffer.append("\"");
//			sbuffer.append(",");
//			
//			//"sex":"男"}
//			sbuffer.append("\"");
//			sbuffer.append("sex");
//			sbuffer.append("\"");
//			sbuffer.append(":");
//			sbuffer.append("\"");
//			sbuffer.append(acc.getSex());
//			sbuffer.append("\"");
//			sbuffer.append("}");
//			System.out.println(sbuffer.toString());
			
			//gson.jar
			Gson gson=new Gson();
			String json=gson.toJson(acc);
			
			Account account=gson.fromJson(json, Account.class);
			System.out.println("json-->java.object"+account);
			
			//获取输出流
			PrintWriter writer=response.getWriter();
			//调用js中success方法
			writer.println(method+"("+json+")");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

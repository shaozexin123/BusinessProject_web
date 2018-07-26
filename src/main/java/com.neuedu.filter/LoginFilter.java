package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/login.jsp")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("½øÈë¹ýÂËÆ÷");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		ILoginService loginService = new LoginServiceImpl();
		String username = null;
		String password = null;
		Cookie[] cookis = req.getCookies();
		if(cookis!=null) {
			for (Cookie c : cookis) {
				if (c.getName().equals("username")) {
					username = c.getValue();
				}
				if (c.getName().equals("password")) {
					password = c.getValue();
				}
			}
		}
		
		if(username!=null&&!username.equals("")&&password!=null&&!password.equals("")) {
			Account acc = loginService.doLogin(username, password);
			if (acc != null) {
				req.getRequestDispatcher("view/home.jsp").forward(req, resp);
				return;
			} else {
				//req.getRequestDispatcher("fail.jsp").forward(req, resp);
				chain.doFilter(request, response);
			}
		}
		// pass the request along the filter chain
		else {
			//req.getRequestDispatcher("fail.jsp").forward(req, resp);
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

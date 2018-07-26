package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageMode;
import com.neuedu.service.CateGoryService;
import com.neuedu.service.impl.CateGoryServiceImpl;
@WebServlet("/view/categorypage")
public class CateGoryControllerPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4061827196776290177L;
    CateGoryService cService=new CateGoryServiceImpl();
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String pageno=req.getParameter("pageno");
		System.out.println(pageno);
        //·ÖÒ³Ä£ÐÍ
		PageMode<CateGory> pagemode=cService.findCateGoryByPage(Integer.parseInt(pageno), 4);
		req.setAttribute("pagemode", pagemode);
		req.getRequestDispatcher("showcategorybypage.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}

package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;
@WebServlet("/view/productpage")
public class ProductControllerPage extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8736216274955762630L;
	ProductService  pService=new ProductServiceImpl();
	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String pageno=req.getParameter("pageno");
		System.out.println(pageno);
        //·ÖÒ³Ä£ÐÍ
		PageMode<Product> pagemode=pService.findProductByPage(Integer.parseInt(pageno), 4);
		req.setAttribute("pagemode", pagemode);
		req.getRequestDispatcher("showproductbypage.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
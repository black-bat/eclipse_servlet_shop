package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import orm.ORM;


@WebServlet("/Filter")
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		try {
			ORM.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("act");
		String info="";
		if(action!=null) {
		info=request.getParameter("info");
		}
		try {
			request.setAttribute("productsFilter",ORM.getFilter(info));
			request.getRequestDispatcher("WEB-INF/views/filter.jsp").forward(request, response);	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	String action=request.getParameter("search").trim();
	String title="";
	if(action!=null) {
	title=request.getParameter("search");
	System.out.println(title);
	}
	try {
		request.setAttribute("productsFilter",ORM.getFilterByTitle(title));
		request.getRequestDispatcher("WEB-INF/views/filter.jsp").forward(request, response);	
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
}



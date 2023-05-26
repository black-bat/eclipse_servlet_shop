package controllers;


import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import orm.ORM;


@WebServlet({ "/Catalog24", "/getProducts", "/cart" })
public class Catalog24 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		try {
		ORM.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
	    String user =  (String) session.getAttribute("Username");
	    String orderInfo =  (String) session.getAttribute("OrderInfo");
		showAll(request,response);
	}
	
	protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("products",ORM.getProducts());
			request.getRequestDispatcher("WEB-INF/views/products.jsp").forward(request, response);				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		var id =request.getParameter("id");
		if(id != null) {
			try {
				if(ORM.addItem(Integer.parseInt(id))) {
					response.getWriter().print("product add");
				}
				else {
					response.getWriter().print("product  dont add");
				}
			} catch (NumberFormatException | SQLException | IOException e) {
				
				e.printStackTrace();
			}
		}	
	}
}

package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orm.ORM;


@WebServlet("/Cart24")
public class Cart24 extends HttpServlet {
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
		try {
			request.setAttribute("cart",ORM.getCart());
			request.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(request, response);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    		response.setContentType("text/html;charset=UTF-8");
    		request.setCharacterEncoding("UTF-8");
    		int idProduct = Integer.parseInt(request.getParameter("id"));
    		//String result = "Товар успешно удален";
    		ORM.deleteProductFromCart(idProduct);
    		//response.getWriter().print(result);
		    request.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(request, response);
    	}
}

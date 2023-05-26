package controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Order;
import orm.ORM;
import orm.ORMOrder;
import orm.ORMUser;
import models.User;


@WebServlet("/Order24")
public class Order24 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		try {
			ORMOrder.getInstance();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
        try {
        	HttpSession session = request.getSession();
    	    String user1 =  (String) session.getAttribute("Username");
    	    String orderInfo =  (String) session.getAttribute("OrderInfo");
    	   // System.out.println(user1+" - " + orderInfo);
    	    if(user1.equals("admin")) {
			request.setAttribute("orders",ORMOrder.getOrders());
		//	request.getRequestDispatcher("WEB-INF/views/orders.jsp").forward(request,response);
			response.getWriter().print("admin");
    	    }else {
    	    	System.out.println(user1+" - " + orderInfo);
    	    	request.setAttribute("orders",ORMOrder.getOrdersByUser(user1));
    	    //	request.getRequestDispatcher("WEB-INF/views/orders.jsp").forward(request,response);
    	    	response.getWriter().print("user");
    	    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("WEB-INF/views/orders.jsp").forward(request,response);
        }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		var click =request.getParameter("click");
		HttpSession session = request.getSession();
	    String user2 =  (String) session.getAttribute("Username");
	    String orderInfo =  (String) session.getAttribute("OrderInfo");
	    System.out.println(user2+" - " + orderInfo);
	    System.out.println(click);
	    if(click!="") {
		if(click.equals("show")) {
	    try {
			ORMOrder.getInfoByInfoOrder(orderInfo);
			request.getRequestDispatcher("WEB-INF/views/info.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		if(click.equals("change")) {
			int idOrder = Integer.parseInt(request.getParameter("id"));
			System.out.println(idOrder);
			ORMOrder.changeOrderStatus(idOrder);
			request.getRequestDispatcher("WEB-INF/views/orders.jsp").forward(request, response);
		}
	    }
	}
}

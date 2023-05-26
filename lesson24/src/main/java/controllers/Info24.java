package controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Info;
import models.Order;
import models.ShoppingCart;
import orm.ORM;
import orm.ORMOrder;


@WebServlet("/Info24")
public class Info24 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		try {
			ORM.getInstance();
			ORMOrder.getInstance();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); 
		try {
		//	request.setAttribute("info",ORMInfo.getInfo());
			String infoOr = request.getParameter("infoOr");
			request.setAttribute("info",ORMOrder.getInfoByInfoOrder(infoOr));
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("WEB-INF/views/info.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		var click =request.getParameter("click");
		if(click!=null) {
			
	    // добавление информации о заказе в БД
		HttpSession session = request.getSession();
	    String user =  (String) session.getAttribute("Username");
	    String orderInfo =  (String) session.getAttribute("OrderInfo");
	    String status = "оформлен";
	    System.out.println(user+" - " + orderInfo);
	    List<ShoppingCart> carts = null;
		try {
			carts = ORM.getCart();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	    Info info = null;
	    double total =0;
	    for(ShoppingCart cart:carts) {
	    total = cart.getCount()*cart.getPrice();
	    info = new Info(cart.getTitle(),cart.getCount(),total,orderInfo);
	    ORMOrder.addInfo(info);
	    }
		response.getWriter().print("Информация отправлена на обработку.");
		
		// добаление заказа в БД
		Date date = Date.valueOf(LocalDate.now());
	    System.out.println(user+" - " + orderInfo);
	    ORMOrder.addOrder(new Order(date,user,orderInfo,status));
		response.getWriter().print("\nЗаказ обрабатывается. ");
		}
	}
}

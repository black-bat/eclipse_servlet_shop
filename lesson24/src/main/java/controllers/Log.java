package controllers;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import orm.ORMUser;

@WebServlet("/Log")
public class Log extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 User user=null;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			ORMUser.getInstance();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
				        
		String login = request.getParameter("lgn").trim();
		String password = request.getParameter("pass").trim();
		System.out.println(login +" "+ password);
		String answer = "Данного пользователя не существует.\nПройдите регистрацию!";
		if(login.equals("") || password.equals("")) {
			response.getWriter().print("Пожалуйста, заполните все поля!");
	}
		else {
			try {
				user = ORMUser.getUserByPassword(password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(user==null) {
				response.getWriter().print(answer);
			}
			else {
				if(!(user.getLogin().equals(login))) {
					response.getWriter().print(answer);
				}
				else {
					response.getWriter().print("ENTER");
					HttpSession session = request.getSession();
			        session.setAttribute("Username", user.getLogin());
			        int order_id= new Random().nextInt(1001);
			        String userBasket = user.getLogin() + order_id;
			        session.setAttribute("OrderInfo", userBasket);	
			     }
			}
		}	
	}
	}
		
	

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
import javax.servlet.http.HttpSession;

import models.User;
import orm.ORMUser;


@WebServlet("/Reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    User user=null;
    List<User>users=new ArrayList<User>();
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
        request.getRequestDispatcher("WEB-INF/views/reg.jsp").forward(request,response);
        request.getSession().invalidate();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
				        
		String login = request.getParameter("lgn").trim();
		String password = request.getParameter("pass").trim();
		String email = request.getParameter("eml").trim();
		System.out.println(login +" "+ password +" "+ email);
		String answer = "Вы успешно зарегистрированы!";
		if(login.equals("") || email.equals("") || password.equals("")) {
			response.getWriter().print("Пожалуйста, заполните все поля!");
	}
		else {
			
				try {
					users=ORMUser.getUserByEmail(email);
				} catch (SQLException e) {
					System.out.println("ошибка в email");
					e.printStackTrace();
				}
				if(users.size()>0) {
					response.getWriter().print("Данный email уже зарегистрирован!");
				}
				else {
					try {
						user=ORMUser.getUserByLogin(login);
						if(user!=null) {
							response.getWriter().print("\n Данный login уже занят!");
						}else {
							user=new User(login,password,email);
							System.out.println(user);
							String str = ORMUser.addUser(user);
							System.out.println(str);
							response.getWriter().print(str);	
						}
					} catch (SQLException e) {
						System.out.println("ошибка в email");
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
		}
}
	}

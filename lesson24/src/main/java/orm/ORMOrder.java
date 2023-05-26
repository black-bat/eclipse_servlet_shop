package orm;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Config;
import models.Info;
import models.Order;

public class ORMOrder {
	static Connection connection;
    static ORMOrder object;
    static Statement statement;
    static List<Order>orders=new ArrayList<Order>();
    static List<Order>ordersUser=new ArrayList<Order>();
    static List<Info>infos=new ArrayList<Info>(); 
    
    //подключение к базе
    private ORMOrder() throws SQLException {
    	if (connection == null) {
    		try {
    			Class.forName(Config.Driver);
    			String url="jdbc:postgresql://"+ Config.SERVER + "/" + Config.DB;
    			connection=DriverManager.getConnection(url,Config.LOGIN,Config.PASSWORD);
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
        }
    }
    public static ORMOrder getInstance() throws SQLException {
        if (object == null) {
            object = new ORMOrder();
        }
        return object;
    }
    
  //получение списка заказов
    public static List<Order> getOrders() throws SQLException{
    //	object = getInstance();
    	String sql = "SELECT * FROM orders";
    	PreparedStatement ps= connection.prepareStatement(sql);
    	ResultSet rs =ps.executeQuery();
    	orders.clear();
    	infos.clear();
    	while(rs.next()) {
    		int id =rs.getInt("id");
    		Date date =rs.getDate("date");
    		String user = rs.getString("user_login").trim();
    		String info_order =rs.getString("info_order").trim();
    		String status =rs.getString("status").trim();
    		orders.add(new Order(id,date,user,info_order,status));
    	}
    	for(Order title:orders) {
    		System.out.println(title.getInfo_order()+"; ");
    	}
    	return orders;
    }
    
  //получение списка заказов по пользователю
    public static List<Order> getOrdersByUser(String userLogin) throws SQLException{
    //	object = getInstance();
    	String sql = "SELECT * FROM orders WHERE user_login=?";
    	PreparedStatement ps= connection.prepareStatement(sql);
    	ps.setString(1,userLogin);
    	ResultSet rs = ps.executeQuery();
    	System.out.println(sql + " " + userLogin);
    	System.out.println(rs.getFetchSize());
    	ordersUser.clear();
    	infos.clear();
    	while(rs.next()) {
    		System.out.println("tut");
    		int id = rs.getInt("id");
    		Date date = rs.getDate("date");
    		userLogin = rs.getString("user_login").trim();
    		String info_order =rs.getString("info_order").trim();
    		String status =rs.getString("status").trim();
    		ordersUser.add(new Order(id,date,userLogin,info_order,status));
    	}
    	for(Order title:ordersUser) {
    		System.out.println(title.getInfo_order()+"; ");
    	}
    	return ordersUser;
    }
    
    //добавление заказа в БД 
    public static String addOrder(Order order) {
    	String sql = "INSERT INTO orders (\"date\", \"user_login\",\"info_order\",\"status\") VALUES (?,?,?,?)";
    	String result = "Товар оформлен.";
    	try {
    		PreparedStatement ps= connection.prepareStatement(sql);
    		ps.setDate(1,order.getDate());
        	ps.setString(2,order.getUser());
        	ps.setString(3,order.getInfo_order());
        	ps.setString(4,order.getStatus());
        	ps.executeUpdate();
    	}catch( SQLException e){
    		e.printStackTrace();
    		result = "Что то пошло не так.";
    	}
    	return result;
    }
    
  //изменение статуса заказа
    public static String changeOrderStatus(int id) {
    //	object = getInstance();
    	String status = "Заказ отправлен";
    	String sql = "UPDATE orders SET status=? WHERE id=?";
    	try {
    	PreparedStatement ps= connection.prepareStatement(sql);
    	ps.setString(1,status);
    	ps.setInt(2,id);
    	ps.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    		System.out.println("При изменении статуса что то пошло не так.");
    	}
    	return status;
    }
    
  //получение информации о заказе по полю info_order
    public static List<Info> getInfoByInfoOrder(String infoOrder) throws SQLException{
    	object = getInstance();
    	String sql = "SELECT * FROM informations WHERE info_order=?";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	ps.setString(1, infoOrder);
    	ResultSet rs = ps.executeQuery();
    	//infos.clear();
    	while(rs.next()) {
    		int id =rs.getInt("id");
    		String title = rs.getString("title").trim();
    		int count = rs.getInt("count");
    		double total = rs.getDouble("total_price");
    		infoOrder = rs.getString("info_order").trim();
    		infos.add(new Info(id,title,count,total,infoOrder));
    	}
    	for(Info title:infos) {
    		System.out.println(title.getInfoOrder()+"; ");
    	}
    	return infos;
    }
    
  //получение информации о заказе
    public static List<Info> getInfo() throws SQLException{
    //	object = getInstance();
    	String sql = "SELECT * FROM informations";
    	PreparedStatement ps= connection.prepareStatement(sql);
    	ResultSet rs =ps.executeQuery();
    	infos.clear();
    	while(rs.next()) {
    		int id =rs.getInt("id");
    		String title = rs.getString("title").trim();
    		int count = rs.getInt("count");
    		double total = rs.getDouble("total_price");
    		String infoOrder =rs.getString("info_order").trim();
    		infos.add(new Info(id,title,count,total,infoOrder));
    	}
    	for(Info title:infos) {
    		System.out.println(title.getInfoOrder()+"; ");
    	}
    	return infos;
    }
    
  //добавление информации в БД 
    public static String addInfo(Info info) {
    	String sql = "INSERT INTO informations (\"title\", \"count\",\"total_price\",\"info_order\") VALUES (?,?,?,?)";
    	String result = "Информация получена.";
    	System.out.println(result);
    	try {
    		PreparedStatement ps= connection.prepareStatement(sql);
    		ps.setString(1,info.getTitle());
        	ps.setInt(2,info.getCount());
        	ps.setDouble(3,info.getTotalPrice());
        	ps.setString(4,info.getInfoOrder());
        	ps.executeUpdate();
    	}catch( SQLException e){
    		e.printStackTrace();
    		result = "Что то пошло не так.";
    	}
    	return result;
    }
    
    /* 
    public static void main(String[] args) throws SQLException {
			System.out.println();
	}
*/
}

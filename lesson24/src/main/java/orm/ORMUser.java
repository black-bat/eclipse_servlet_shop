package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Config;
import models.User;

public class ORMUser {
	static Connection connection;
    static ORMUser object;
    static Statement statement;
    static User user;
    static List<User>users=new ArrayList<User>();
    
    //подключение к базе
    private ORMUser() throws SQLException {
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
    public static ORMUser getInstance() throws SQLException {
        if (object == null) {
            object = new ORMUser();
        }
        return object;
    }
    
   //получение списка пользователей
    public static List<User> getUsers() throws SQLException{
    	String sql = "SELECT * FROM users";
    	PreparedStatement ps= connection.prepareStatement(sql);
    	ResultSet rs =ps.executeQuery();
    	users.clear();
    	while(rs.next()) {
    		int id =rs.getInt("id");
    		String login =rs.getString("login").trim();
    		String password =rs.getString("password").trim();
    		String email =rs.getString("email").trim();
    		users.add(new User(id,login,password,email));
    	}
    	for(User title:users) {
    		System.out.println(title.getLogin()+"; ");
    	}
    	return users;
    }
  //получение списка пользователей по email
    public static List<User> getUserByEmail(String email) throws SQLException{
    	users.clear();
    	String sql = "SELECT * FROM users WHERE email=?";
    	System.out.println(sql+" "+email);
    	PreparedStatement ps= connection.prepareStatement(sql);
    	ps.setString(1,email);
    	ResultSet rs =ps.executeQuery();
    	users.clear();
    	while(rs.next()) {
    		int id =rs.getInt("id");
    		String login =rs.getString("login").trim();
    		String password =rs.getString("password").trim();
    		String email1 =rs.getString("email").trim();
    		users.add(new User(id,login,password,email1));
    		System.out.println(user);
    	}
    		System.out.println(users);
    	return users;
    }
    
  //получение пользователя по login
    public static User getUserByLogin(String login) throws SQLException{
    //	object = getInstance();
    	String sql = "SELECT * FROM users WHERE login=?";
    	System.out.println(sql+" "+login);
    	PreparedStatement ps= connection.prepareStatement(sql);
    	ps.setString(1,login);
    	ResultSet rs =ps.executeQuery();
    	user = null; 
    	while(rs.next()) {
    		int id =rs.getInt("id");
    		login =rs.getString("login").trim();
    		String password =rs.getString("password").trim();
    		String  email =rs.getString("email").trim();
    		user=new User(id,login,password,email);
    	}
    	return user;
    }
    
  //получение пользователя по password
    public static User getUserByPassword(String password) throws SQLException{
    //	object = getInstance();
    	String sql = "SELECT * FROM users WHERE password=?";
    	System.out.println(sql+" "+password);
    	PreparedStatement ps= connection.prepareStatement(sql);
    	ps.setString(1,password);
    	ResultSet rs =ps.executeQuery();
    	user = null; 
    	while(rs.next()) {
    		int id =rs.getInt("id");
    		String  login =rs.getString("login").trim();
    		password =rs.getString("password").trim();
    		String  email =rs.getString("email").trim();
    		user=new User(id,login,password,email);
    	}
    	return user;
    }
    
  //добавление пользователя в БД (регистрация)
    public static String addUser(User user) {
    	String sql = "INSERT INTO users (\"login\", \"password\",\"email\") VALUES (?,?,?)";
    	String result = "Вы успешно зарегистрированы.";
    	try {
    		PreparedStatement ps= connection.prepareStatement(sql);
    		ps.setString(1,user.getLogin());
        	ps.setString(2,user.getPassword());
        	ps.setString(3,user.getEmail());
        	ps.executeUpdate();
    	}catch( SQLException e){
    		e.printStackTrace();
    		result = "Что то пошло не так.";
    	}
    	return result;
    }
    
    /* 
    public static void main(String[] args) throws SQLException {
			System.out.println(getUserByLogin("admin"));
	}
*/
}

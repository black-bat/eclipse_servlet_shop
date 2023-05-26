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
import models.Product;
import models.ShoppingCart;
import models.User;

public class ORM {
	    static Connection connection;
	    static ORM object;
	    static Statement statement;
	    static Product product;
	    static List<Product>products=new ArrayList<Product>();
	    static List<ShoppingCart>cart=new ArrayList<ShoppingCart>();
	    static List<Product>products1=new ArrayList<Product>();
	    
	    static User user;
	    static List<User>users=new ArrayList<User>();
	    
	    
	    //подключение к базе
	    private ORM() throws SQLException {
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
	    public static ORM getInstance() throws SQLException {
	        if (object == null) {
	            object = new ORM();
	        }
	        return object;
	    }
	    
	   //получение списка с товарами
	    public static List<Product> getProducts() throws SQLException{
	    //	object = getInstance();
	    	String sql = "SELECT * FROM products";
	    	PreparedStatement ps= connection.prepareStatement(sql);
	    	ResultSet rs =ps.executeQuery();
	    	products.clear();
	    	products1.clear();
	    	while(rs.next()) {
	    		int id =rs.getInt("id");
	    		String title =rs.getString("title").trim();
	    		double price =rs.getDouble("price");
	    		String info =rs.getString("info").trim();
	    		String info_picture =rs.getString("info_picture").trim();
	    		products.add(new Product(id,title,price,info,info_picture));
	    	}
	    	for(Product title:products) {
	    		System.out.println(title.getTitle()+"; ");
	    	}
	    	return products;
	    }
	    
	    //фильтр1
	    public static List<Product> getFilter(String str) throws SQLException{
	    //	object = getInstance();
	    	
	    	String sql  = "SELECT * FROM products WHERE info=?";	    	
	    	System.out.println(sql);
	    	PreparedStatement ps= connection.prepareStatement(sql);
	    	ps.setString(1,str);
	    	ResultSet rs =ps.executeQuery();
	    	
	    	while(rs.next()) {
	    		int id =rs.getInt("id");
	    		String title =rs.getString("title").trim();
	    		double price =rs.getDouble("price");
	    		String info =rs.getString("info").trim();
	    		String info_picture =rs.getString("info_picture").trim();
	    		products1.add(new Product(id,title,price,info,info_picture));
	    	}
	    	for(Product title:products1) {
	    		System.out.println(title.getTitle());
	    	}
	    	return products1;
	    }
	    
	    //фильтр2
	    public static List<Product> getFilterByTitle(String str) throws SQLException{
	    //	object = getInstance();
	    	
	    	String sql  = "SELECT * FROM products WHERE title=?";	    	
	    	System.out.println(sql+" "+str);
	    	PreparedStatement ps= connection.prepareStatement(sql);
	    	ps.setString(1,str);
	    	ResultSet rs =ps.executeQuery();
	    	products1.clear();
	    	while(rs.next()) {
	    		int id =rs.getInt("id");
	    		String title =rs.getString("title").trim();
	    		double price =rs.getDouble("price");
	    		String info =rs.getString("info").trim();
	    		String info_picture =rs.getString("info_picture").trim();
	    		products1.add(new Product(id,title,price,info,info_picture));
	    	}
	    	for(Product title:products1) {
	    		System.out.println(title.getTitle());
	    	}
	    	return products1;
	    }
	    
	  //получение списка из корзины
	    public static List<ShoppingCart> getCart() throws SQLException{
	    //	object = getInstance();
	    	String sql = "SELECT title,price,product_id,count FROM products INNER JOIN shopping_cart ON products.id=shopping_cart.product_id;";
	    	PreparedStatement ps= connection.prepareStatement(sql);
	    	ResultSet rs =ps.executeQuery();
	    	cart.clear();
	    	products1.clear();
	    	while(rs.next()) {
	    		String title =rs.getString("title").trim();
	    		double price =rs.getDouble("price");
	    		int product_id =rs.getInt("product_id");
	    		int count =rs.getInt("count");
	    		cart.add(new ShoppingCart(title,price,product_id,count));
	    	}
	    	return cart;
	    }
	  
	   /* 
	    public static void main(String[] args) throws SQLException {
				System.out.println(getProducts());
				System.out.println(getCart());
				System.out.println(getUsers());
		}
	*/
		public static boolean addItem(int id) throws SQLException {
		//	object = getInstance();
			String sql = "SELECT id FROM shopping_cart WHERE product_id=?";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				var update = "UPDATE shopping_cart SET count = count+1 WHERE product_id =? ";
				var psUpdate = connection.prepareStatement(update);
				psUpdate.setInt(1,id);
				if(psUpdate.executeUpdate() > 0) {
					return true;
				}
			}else {
				var sqlInsert = "INSERT INTO shopping_cart(product_id,count) VALUES (?,1)";
				var psInsert = connection.prepareStatement( sqlInsert);
				psInsert.setInt(1,id);
				if(psInsert.executeUpdate() > 0) {
					return true;
				}
				}
			return false;
		}
		public static String deleteProductFromCart(int idProduct) {
			String sql = "DELETE FROM shopping_cart WHERE product_id=?";
			String result = "Товар успешно удален";
			try {
				PreparedStatement ps= connection.prepareStatement(sql);
				ps.setInt(1,idProduct);
				ps.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
				result = "При удалении что то пошло не так.";
			}
			return result;
		}	    
}

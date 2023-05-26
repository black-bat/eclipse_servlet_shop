package models;

public class ShoppingCart {
	    private int id;
	    private int product_id;
	    private int count;
	    private String title;
	    private double price;

	   	    public ShoppingCart(String title,double price, int product_id, int count) {
	        this.title = title;
	        this.price = price;
	        this.product_id = product_id;
	        this.count = count;
	    }
	   	    
	   	 public ShoppingCart(int id, int product_id, int count) {
		        this.id = id;
		        this.product_id = product_id;
		        this.count = count;
		    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getProduct_id() {
	        return product_id;
	    }

	    public void setProduct_id(int product_id) {
	        this.product_id = product_id;
	    }

	    public int getCount() {
	        return count;
	    }

	    public void setCount(int count) {
	        this.count = count;
	    }
	    
	    public String getTitle() {
	        return title;
	    }
	    
	    public double getPrice() {
	        return price;
	    }
	    
	    public String toString() {
			return "товар: "+title+" стоит = "+price+" id товара: "+product_id+" количество = "+count;
	    	
	    }
	}


package models;

public class Product {
	private int id;
    private String title;
    private double price;
    private String info;
    private String info_picture;

    public Product(int id, String title, double price, String info, String info_picture) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.info = info;
        this.info_picture = info_picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo_picture() {
        return info_picture;
    }

    public void setInfo_picture(String info_picture) {
        this.info_picture = info_picture;
    }
    public String toString() {
		return "товар: "+title+" стоит = "+price+" тип: "+info+" адрес картинки = "+info_picture;
    	
    }
}

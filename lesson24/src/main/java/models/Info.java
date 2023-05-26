package models;

public class Info {
	private int id;
    private String title;
    private int count;
    private double totalPrice;
    private String infoOrder;

    public Info(int id) {
        this.id = id;
    }

    public Info(int id, String title, int count, double totalPrice, String infoOrder) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.totalPrice = totalPrice;
        this.infoOrder = infoOrder;
    }

    public Info(String title, int count, double totalPrice, String infoOrder) {
        this.title = title;
        this.count = count;
        this.totalPrice = totalPrice;
        this.infoOrder = infoOrder;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getInfoOrder() {
        return infoOrder;
    }
    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                ", infoOrder='" + infoOrder + '\'' +
                '}';
    }
}

package models;

import java.sql.Date;

public class Order {
	private int id;
	private Date date;
	private String user;
	private String info_order;
	private String status;

    public Order() {
    }

    public Order(int id, Date date, String user, String info_order, String status) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.info_order = info_order;
        this.status = status;
    }

    public Order(Date date, String user, String info_order, String status) {
        this.date = date;
        this.user = user;
        this.info_order = info_order;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public String getInfo_order() {
        return info_order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", user='" + user + '\'' +
                ", info_order='" + info_order + '\'' +
                ", status='" + status + '\'' +
                '}';
}
}

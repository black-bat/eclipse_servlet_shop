package models;

public class User {
	private int id;
	private String login;
	private String password;
	private String email;

	    public User() {
	    }

	    public User(String login, String password, String email) {
	        this.login = login;
	        this.password = password;
	        this.email = email;
	    }

	    public User(int id, String login, String password, String email) {
	        this.id = id;
	        this.login = login;
	        this.password = password;
	        this.email = email;
	    }

	    public User(String login, String password) {
	        this.login = login;
	        this.password = password;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getLogin() {
	        return login;
	    }

	    public void setLogin(String login) {
	        this.login = login;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", login='" + login + '\'' +
	                ", password='" + password + '\'' +
	                ", email='" + email + '\'' +
	                '}';
	    }
}

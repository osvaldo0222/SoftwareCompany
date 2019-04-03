package logical;

import java.io.Serializable;
import java.util.Date;

public class User extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7082630249243275893L;
	private String username;
	private String password;
	private String type;
	private Date last_enter;
	
	public User(String code, String id, String name, String last_name, String address, String gender, int age, String phone, String username, String password, String type) {
		super(code, id, name, last_name, address, gender, age, phone);
		this.username = username;
		this.password = password;
		this.type = type;
		this.last_enter = new Date();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLast_enter() {
		return last_enter;
	}

	public void setLast_enter(Date last_enter) {
		this.last_enter = last_enter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

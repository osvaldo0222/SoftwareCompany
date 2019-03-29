package logical;

import java.util.Date;

public class User extends Person {
	private String username;
	private String password;
	private Date last_enter;
	
	public User(String code, String id, String name, String last_name, String address, String gender, int age, String phone, String username, String password) {
		super(code, id, name, last_name, address, gender, age, phone);
		this.username = username;
		this.password = password;
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
}

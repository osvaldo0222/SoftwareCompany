package logical;

import java.io.Serializable;
import java.util.Date;

public class Client extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -682238514559973065L;
	private int cant_projects;
	private Date registration_date;
	
	public Client(String code, String id, String name, String last_name, String address, String gender, int age, String phone) {
		super(code, id, name, last_name, address, gender, age, phone);
		this.cant_projects = 0;
		this.registration_date = new Date();
	}

	public int getCant_projects() {
		return cant_projects;
	}

	public void setCant_projects(int cant_projects) {
		this.cant_projects = cant_projects;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
}

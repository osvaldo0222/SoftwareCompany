package logical;

import java.io.Serializable;
import java.util.Date;

import javax.swing.ImageIcon;

public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -682238514559973065L;
	private ImageIcon picture;
	private String code;
	private String id;
	private String name;
	private String last_name;
	private String address;
	private String phone;
	private String mail;
	private int cant_projects;
	private Date registration_date;
	
	public Client(String code, String id, String name, String last_name, String address, String phone, String mail) {
		super();
		this.code = code;
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.address = address;
		this.phone = phone;
		this.mail = mail;
		this.cant_projects = 0;
		this.registration_date = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCant_projects() {
		return cant_projects;
	}

	public void setCant_projects(int cant_projects) {
		this.cant_projects = cant_projects;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ImageIcon getPicture() {
		return picture;
	}

	public void setPicture(ImageIcon picture) {
		this.picture = picture;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
}

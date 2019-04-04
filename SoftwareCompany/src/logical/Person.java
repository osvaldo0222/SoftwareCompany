package logical;

import java.io.Serializable;

import javax.swing.ImageIcon;

public abstract class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1875933389069760567L;
	protected String code;
	protected String id;
	protected ImageIcon picture;
	protected String name;
	protected String last_name;
	protected String address;
	protected String gender;
	protected int age;
	protected String phone;
	protected String mail;
	

	public Person(String code, String id, String name, String last_name, String address, String gender, int age, String phone) {
		super();
		this.code = code;
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.mail = "";
		this.picture = new ImageIcon();
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public ImageIcon getPicture() {
		return picture;
	}


	public void setPicture(ImageIcon picture) {
		this.picture = picture;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
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

}

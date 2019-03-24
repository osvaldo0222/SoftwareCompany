package logical;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Worker {
	protected String code;
	protected String id;
	private ImageIcon picture;
	protected String name;
	protected String last_name;
	protected String address;
	protected String gender;
	protected int age;
	private String phone;
	protected float salary_per_hour;
	protected ArrayList<String> projects;
	
	public Worker(String code, String id, String name, String last_name, String address, String gender, int age, String phone, float salary) {
		super();
		this.code = code;
		this.id = id;
		this.picture =  new ImageIcon();
		this.name = name;
		this.last_name = last_name;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.salary_per_hour = salary;
		this.projects = new ArrayList<>();
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

	public float getSalary() {
		return salary_per_hour;
	}

	public void setSalary(float salary) {
		this.salary_per_hour = salary;
	}

	public ArrayList<String> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<String> projects) {
		this.projects = projects;
	}
	
	public void insertProject(String nameProject) {
		this.projects.add(nameProject);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ImageIcon getPicture() {
		return picture;
	}

	public void setPicture(ImageIcon picture) {
		this.picture = picture;
	}
}

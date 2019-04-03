package logical;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Worker extends Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float salary_per_hour;
	protected ArrayList<String> projects;
	
	public Worker(String code, String id,String name, String last_name, String address, String gender, int age, String phone,float salary) {
		super(code, id, name, last_name, address, gender, age, phone);
		this.salary_per_hour = salary;
		this.projects = new ArrayList<>();
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
		projects.add(nameProject);
	}
	
}

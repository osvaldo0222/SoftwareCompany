package logical;

import java.util.ArrayList;

public class Project {
	private String id;
	private String name;
	private ArrayList<Worker> workers;
	
	public Project(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.workers = new ArrayList<>();
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

	public ArrayList<Worker> getDesigners() {
		return workers;
	}

	public void setDesigners(ArrayList<Worker> workers) {
		this.workers = workers;
	}
}

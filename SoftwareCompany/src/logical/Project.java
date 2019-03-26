package logical;

import java.util.ArrayList;

public class Project {
	private String id;
	private String name;
	private ArrayList<Worker> workers;
	private String type;
	private String language;
	private String state; // Nuevo/En Proceso/Prorrogado/Atrasado/Terminado
	private boolean ended;

	public Project(String id, String name, ArrayList<Worker> workers, String type, String language, String state) {
		super();
		this.id = id;
		this.name = name;
		this.workers = workers;
		this.type = type;
		this.language = language;
		this.state = state;
		this.ended = false;
	}

	public ArrayList<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(ArrayList<Worker> workers) {
		this.workers = workers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isEnded() {
		return ended;
	}

	public void setEnded(boolean ended) {
		this.ended = ended;
	}
}

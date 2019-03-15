package logical;

public class Client {
	private String id;
	private String name;
	private String address;
	private int cant_projects;
	
	public Client(String id, String name, String address, int cant_projects) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.cant_projects = cant_projects;
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
}

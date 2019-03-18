package logical;

import java.util.ArrayList;

public class SoftwareCompany {
	private ArrayList<Worker> workers;
	private ArrayList<Project> projects;
	private ArrayList<Client> clients;
	private ArrayList<Contract> contracts;
	private static SoftwareCompany softwareCompany = null;
	
	private SoftwareCompany() {
		super();
		this.workers = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.clients = new ArrayList<>();
		this.contracts = new ArrayList<>();
	}
	
	public static SoftwareCompany getInstance() {
		if (softwareCompany == null) {
			softwareCompany = new SoftwareCompany();
		}
		return softwareCompany;
	}

	public ArrayList<Worker> getDesigners() {
		return workers;
	}

	public void setDesigners(ArrayList<Worker> workers) {
		this.workers = workers;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(ArrayList<Contract> contracts) {
		this.contracts = contracts;
	}

	public static SoftwareCompany getSoftwareCompany() {
		return softwareCompany;
	}

	public static void setSoftwareCompany(SoftwareCompany softwareCompany) {
		SoftwareCompany.softwareCompany = softwareCompany;
	}
	
	public void insertClient(Client C1) {
		clients.add(C1);
	}
	
	public void insertContract(Contract CNT1) {
		contracts.add(CNT1);
	}
	
	public void insertDesigner(Worker worker) {
		workers.add(worker);
	}
	
	public void insertProject(Project PRJ1) {
		projects.add(PRJ1);
	}
}

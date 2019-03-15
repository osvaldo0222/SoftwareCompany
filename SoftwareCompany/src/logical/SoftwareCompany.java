package logical;

import java.util.ArrayList;

public class SoftwareCompany {
	private ArrayList<Designer> designers;
	private ArrayList<Project> projects;
	private ArrayList<Client> clients;
	private ArrayList<Contract> contracts;
	private static SoftwareCompany softwareCompany = null;
	
	private SoftwareCompany() {
		super();
		this.designers = new ArrayList<>();
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

	public ArrayList<Designer> getDesigners() {
		return designers;
	}

	public void setDesigners(ArrayList<Designer> designers) {
		this.designers = designers;
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
	public void insertDesigner(Designer DSN1) {
		designers.add(DSN1);
	}
	public void insertProject(Project PRJ1) {
		projects.add(PRJ1);
		
	}
}

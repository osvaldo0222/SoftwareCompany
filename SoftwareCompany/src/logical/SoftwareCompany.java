package logical;

import java.util.ArrayList;

public class SoftwareCompany {
	private ArrayList<User> users;
	private ArrayList<Worker> workers;
	private ArrayList<Project> projects;
	private ArrayList<Client> clients;
	private ArrayList<Contract> contracts;
	private static SoftwareCompany softwareCompany = null;
	public static int codWorkers = 0;
	public static int codProjects = 0;
	public static int codClients = 0;
	public static int codUsers = 0;
	
	private SoftwareCompany() {
		super();
		this.users = new ArrayList<>();
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
		codClients++;
	}
	
	public void insertContract(Contract CNT1) {
		contracts.add(CNT1);
	}
	
	public void insertWorker(Worker worker) {
		workers.add(worker);
		codWorkers++;
	}
	
	public void insertProject(Project PRJ1) {
		projects.add(PRJ1);
	}
	
	public void insertUser(User user) {
		users.add(user);
		codUsers++;
	}
	
	public String calification(String id) {
		String calification = "";
		int total = 0;
		int good = 0;
		Worker aux = workerById(id);
		if (aux != null) {
			for (Contract contract : contracts) {
				for (Worker contraWorker : contract.getProject().getWorkers()) {
					if (contraWorker.equals(aux)) {
						total++;
						if (!contract.getDueDate().before(contract.getFinalDate())) {
							good++;
						}
					}
				}
			}
		}
		
		if (total > 0) {
			float percentage = (float) good/total;
			if (percentage >= 1) {
				calification = "Excelente";
			} else if (percentage < 1 && percentage >= 0.8) {
				calification = "Bueno";
			} else {
				calification = "Deficiente";
			}
		}
		return calification;
	}

	public Worker workerById(String id) {
		Worker aux = null;
		for (Worker worker : workers) {
			if (worker.getId().equalsIgnoreCase(id)) {
				aux = worker;
				break;
			}
		}
		return aux;
	}

	public ArrayList<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(ArrayList<Worker> workers) {
		this.workers = workers;
	}

	public static int getCodWorkers() {
		return codWorkers;
	}

	public static void setCodWorkers(int codWorkers) {
		SoftwareCompany.codWorkers = codWorkers;
	}

	public static int getCodProjects() {
		return codProjects;
	}

	public static void setCodProjects(int codProjects) {
		SoftwareCompany.codProjects = codProjects;
	}

	public Client clientById(String id) {
		Client aux = null;
		for (Client client : clients) {
			if (client.getId().equalsIgnoreCase(id)) {
				aux = client;
				break;
			}
		}
		return aux;
	}
	public Worker searchWorkerByCode(String id) {
		Worker auxWorker=null;
		
		for (int i = 0; i < workers.size(); i++) {
			if (workers.get(i).equals(id)) {
				auxWorker=workers.get(i);
				break;
			}
		}
		return auxWorker;
		
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
}

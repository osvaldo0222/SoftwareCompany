package logical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.toedter.calendar.JDateChooser;

public class SoftwareCompany implements Serializable {
	
	private static final long serialVersionUID = -2058297959693156912L;
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
	public static int codContract=0;
	private Calendar fechaInicio = new GregorianCalendar(); 
	private Calendar fechafin = new GregorianCalendar();
	private Calendar c = Calendar.getInstance();
	
	
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
		codContract++;
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
		String calification = "EXCELENTE";
		int total = 0;
		int good = 0;
		
		//System.out.println("pepe"+contract.getDueDate());
		
		
		Worker aux = workerById(id);
		System.out.println(aux.getName()+"\n");
		if (aux != null) {
			for (Contract contract : contracts) {
				System.out.println("pepe");
				for (Worker contraWorker : contract.getProject().getWorkers()) {
					if (contraWorker.getId().equalsIgnoreCase(id)) {
						
						total++;
						if (contract.getFinalDate().after(contract.getDueDate())) {
						
							//good++;
						}else {
							good++;
							System.out.println(""+contract.getDueDate());
							System.out.println(""+contract.getFinalDate());
							
						}
					}
				}
			}
		}
		
		if (total > 0) {
			float percentage = (float) good/total;
			if (percentage >= 1) {
				calification = "EXCELENTE";
			} else if (percentage < 1 && percentage >= 0.8) {
				calification = "BUENO";
			} else {
				calification = "DEFICIENTE";
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
	
	public Worker searchWorkerByCode(String code) {
		Worker auxWorker = null;
		for (int i = 0; i < workers.size(); i++) {
			if (workers.get(i).getCode().equalsIgnoreCase(code)) {
				auxWorker = workers.get(i);
				break;
			}
		}
		return auxWorker;
	}
	
	public Client searchClientByCode(String code) {
		Client auxClient = null;
		for (Client client : clients) {
			if (client.getCode().equalsIgnoreCase(code)) {
				auxClient = client;
				break;
			}
		}
		return auxClient;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public User searchUserByUsername(String username,String password) {
		User auxUser = null;
		for (User userForEach : users) {
			if (userForEach.getUsername().equalsIgnoreCase(username) && userForEach.getPassword().equalsIgnoreCase(password)) {
				auxUser = userForEach;
			}
		}
		return auxUser;
	}

	public boolean clientIsRemovable(String id) {
		boolean isRemovable = true;
		for (Contract contract : contracts) {
			if (contract.getIdClient().equalsIgnoreCase(id)) {
				isRemovable = false;
				break;
			}
		}
		return isRemovable;
	}

	public void removeClient(Client client) {
		clients.remove(client);
	}

	public static int getCodContract() {
		return codContract;
	}

	public static void setCodContract(int codContract) {
		SoftwareCompany.codContract = codContract;
	}
	
	public int calcDays(JDateChooser dateBegin, JDateChooser dateEnd) {
		int days = 0;
		
		if (dateBegin.getDate()!=null && dateEnd.getDate()!=null) {
			Calendar init=dateBegin.getCalendar();
			Calendar end=dateEnd.getCalendar();
		
			while(init.before(end) || init.equals(end)) {
				days++;
				init.add(Calendar.DATE, 1);
			}
			
		}
		return days;	
	}
	
	public User userById(String id) {
		User aux = null;
		for (User user : users) {
			if (user.getId().equalsIgnoreCase(id)) {
				aux = user;
				break;
			}
		}
		return aux;
	}

	public boolean checkUsername(User user) {
		boolean validated = true;
		for (User aux : users) {
			if (aux.getUsername().equals(user.getUsername()) && !aux.getCode().equalsIgnoreCase(user.getCode())) {
				validated = false;
				break;
			}
		}
		return validated;
	}

	public boolean workerIsRemovable(String id) {
		boolean isRemovable = true;
		for (Project project : projects) {
			for (Worker aux : project.getWorkers()) {
				if (aux.getId().equalsIgnoreCase(id)) {
					isRemovable = false;
					break;
				}
			}
		}
		return isRemovable;
	}

	public void removeWorker(Worker worker) {
		workers.remove(worker);
	}
	public Contract searchContractByCode(String codeContract) {
		Contract aux=null;
			for (int i = 0; i < contracts.size(); i++) {
				if (contracts.get(i).getId().equalsIgnoreCase(codeContract)) {
					aux=contracts.get(i);
					break;
				}
			}
		return aux;
	}

	public User userByCode(String code) {
		User user = null;
		for (User aux : users) {
			if (aux.getCode().equalsIgnoreCase(code)) {
				user = aux;
				break;
			}
		}
		return user;
	}

	public boolean atTwoAnAdmin() {
		boolean atLeast = false;
		int count = 0;
		for (User aux : users) {
			if (aux.getType().equalsIgnoreCase("ADMINISTRADOR") && aux.isState()) {
				count++;
			}
		}
		
		if (count > 1) {
			atLeast = true;
		}
		return atLeast;
	}
	public float calcAmountDelayTime(String idContract,int days) {
		float delayAmount=0;
		Contract aux=null;
		aux=searchContractByCode(idContract);
		//float total=aux.getPrice();
		//aux.setCopyPrice(total);
		
		float price=aux.getCopyPrice();
		delayAmount=(float) (price - price*(days*0.01));
	
		return delayAmount;
		
	}
	
	/*public float calcAmountOfMoney(int days) {
		float aux=0;
		float amount=0;
		float percent=0;
		
		for
		
		for (int i = 0; i < DLMWorkersSelected.size(); i++) {
			String[] codSplit=DLMWorkersSelected.getElementAt(i).toString().split(" ");
			aux=SoftwareCompany.getInstance().searchWorkerByCode(codSplit[0]).getSalary()*8*days;
			amount+=aux;
			aux=0;
		}
		percent=(float) (amount*0.25);
		amount+=percent;
		return amount;
		
	}*/
	
	public float calcAmountOfMoney(int days,String codeCont) {
		float amount=0;
		float aux2=0;
		for (int i = 0; i < searchContractByCode(codeCont).getProject().getWorkers().size(); i++) {
			amount=searchContractByCode(codeCont).getProject().getWorkers().get(i).getSalary()*8*days;
			aux2+=amount;
			amount=0;
		}
		//aux=(float)(aux2*0.25);
		
		
		
		return aux2;
		
	}
	
	
	public int calcDaysJustDate(Date d1,Date d2) {
		fechaInicio.setTime(d1);
		fechafin.setTime(d2);
		
		c.setTimeInMillis(fechafin.getTime().getTime() - fechaInicio.getTime().getTime());
		
		return c.get(Calendar.DAY_OF_YEAR);
		
	}
	
}

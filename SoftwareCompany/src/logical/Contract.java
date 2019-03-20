package logical;

import java.util.Date;

public class Contract {
	private String id;
	private Date dateBegin;
	private Date dueDate;
	private String idClient;
	private String name_project;
	private float price;
	
	public Contract(String id, Date dateBegin, Date dueDate, String idClient, String name_project, float price) {
		super();
		this.id = id;
		this.dateBegin = dateBegin;
		this.dueDate = dueDate;
		this.idClient = idClient;
		this.name_project = name_project;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getName_project() {
		return name_project;
	}

	public void setName_project(String name_project) {
		this.name_project = name_project;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}

package logical;

public class Designer extends Worker {
	private String master;

	public Designer(String id, String name, String last_name, String address, String gender, int age, float salary, String calification, String master) {
		super(id, name, last_name, address, gender, age, salary, calification);
		this.master = master;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}
}

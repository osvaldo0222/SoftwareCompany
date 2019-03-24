package logical;

public class Designer extends Worker {
	private String master;

	public Designer(String code, String id, String name, String last_name, String address, String gender, int age, String phone, float salary, String master) {
		super(code, id, name, last_name, address, gender, age, phone, salary);
		this.master = master;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}
}

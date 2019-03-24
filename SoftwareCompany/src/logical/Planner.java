package logical;

public class Planner extends Worker {
	private int cant_days;

	public Planner(String code, String id, String name, String last_name, String address, String gender, int age, String phone, float salary, int cant_days) {
		super(code, id, name, last_name, address, gender, age, phone, salary);
		this.cant_days = cant_days;
	}

	public int getCant_days() {
		return cant_days;
	}

	public void setCant_days(int cant_days) {
		this.cant_days = cant_days;
	}
}

package logical;

public class Planner extends Designer {
	private int cant_days;

	public Planner(String id, String name, String last_name, String address, String gender, int age, float salary, String project, String calification, int cant_days) {
		super(id, name, last_name, address, gender, age, salary, project, calification);
		this.cant_days = cant_days;
	}

	public int getCant_days() {
		return cant_days;
	}

	public void setCant_days(int cant_days) {
		this.cant_days = cant_days;
	}
}

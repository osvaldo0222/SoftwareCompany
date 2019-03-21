package logical;

public class Boss extends Worker {
	private int cant_workers;

	public Boss(String id, String name, String last_name, String address, String gender, int age, float salary, String calification, int cant_workers) {
		super(id, name, last_name, address, gender, age, salary, calification);
		this.cant_workers = cant_workers;
	}

	public int getCant_workers() {
		return cant_workers;
	}

	public void setCant_workers(int cant_workers) {
		this.cant_workers = cant_workers;
	}
}

package logical;

public class Boss extends Worker {
	private int cant_workers;
	private int experience_years;

	public Boss(String code, String id, String name, String last_name, String address, String gender, int age, String phone, float salary, int cant_workers, int experience_years) {
		super(code, id, name, last_name, address, gender, age, phone, salary);
		this.cant_workers = cant_workers;
		this.experience_years = experience_years;
	}

	public int getCant_workers() {
		return cant_workers;
	}

	public void setCant_workers(int cant_workers) {
		this.cant_workers = cant_workers;
	}

	public int getExperience_years() {
		return experience_years;
	}

	public void setExperience_years(int experience_years) {
		this.experience_years = experience_years;
	}
}

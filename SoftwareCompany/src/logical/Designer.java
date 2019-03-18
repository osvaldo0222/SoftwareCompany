package logical;

public class Designer extends Worker {
	private String master;

	public Designer(String id, String name, String last_name, String address, String gender, int age, float salary, String project, String calification, String especialidad) {
		super(id, name, last_name, address, gender, age, salary, project, calification);
		this.master = master;
	}

	public String getEspecialidad() {
		return master;
	}

	public void setEspecialidad(String especialidad) {
		this.master = master;
	}
}

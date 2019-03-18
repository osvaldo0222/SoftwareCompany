package logical;

public class Designer extends Worker {
	private String especialidad;

	public Designer(String id, String name, String last_name, String address, String gender, int age, float salary, String project, String calification, String especialidad) {
		super(id, name, last_name, address, gender, age, salary, project, calification);
		this.especialidad = especialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
}

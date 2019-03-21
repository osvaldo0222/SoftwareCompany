package logical;

import java.util.ArrayList;

public class Programmer extends Worker {
	private ArrayList<String> programingLanguages;

	public Programmer(String id, String name, String last_name, String address, String gender, int age, float salary, String calification) {
		super(id, name, last_name, address, gender, age, salary, calification);
		this.programingLanguages = new ArrayList<>();
	}

	public ArrayList<String> getLanguages() {
		return programingLanguages;
	}

	public void setLanguages(ArrayList<String> programingLanguages) {
		this.programingLanguages = programingLanguages;
	}
	
	public void insertLanguages(String language) {
		this.programingLanguages.add(language);
	}
}

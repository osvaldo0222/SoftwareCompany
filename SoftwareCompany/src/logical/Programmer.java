package logical;

import java.util.ArrayList;

public class Programmer extends Worker {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> programingLanguages;

	public Programmer(String code, String id, String name, String last_name, String address, String gender, int age, String phone, float salary) {
		super(code, id, name, last_name, address, gender, age, phone, salary);
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

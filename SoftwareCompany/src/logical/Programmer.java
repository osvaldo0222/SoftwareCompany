package logical;

import java.util.ArrayList;

public class Programmer extends Designer {
	private ArrayList<ProgramingLanguage> programingLanguages;

	public Programmer(String id, String name, String last_name, String address, String gender, int age, float salary, String project_name, String calification, ArrayList<ProgramingLanguage> programingLanguages) {
		super(id, name, last_name, address, gender, age, salary, project_name, calification);
		this.programingLanguages = new ArrayList<>();
	}

	public ArrayList<ProgramingLanguage> getLanguages() {
		return programingLanguages;
	}

	public void setLanguages(ArrayList<ProgramingLanguage> programingLanguages) {
		this.programingLanguages = programingLanguages;
	}
}

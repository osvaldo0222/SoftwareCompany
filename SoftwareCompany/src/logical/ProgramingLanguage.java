package logical;

public class ProgramingLanguage {
	private String id;
	private String name;
	private String version;
	private String paradigm;
	private String interpretation;
	private String category;
	
	public ProgramingLanguage(String id, String name, String version,String paradigm, String interpretation, String category) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.paradigm = paradigm;
		this.interpretation = interpretation;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParadigm() {
		return paradigm;
	}

	public void setParadigm(String paradigm) {
		this.paradigm = paradigm;
	}

	public String getInterpretation() {
		return interpretation;
	}

	public void setInterpretation(String interpretation) {
		this.interpretation = interpretation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}

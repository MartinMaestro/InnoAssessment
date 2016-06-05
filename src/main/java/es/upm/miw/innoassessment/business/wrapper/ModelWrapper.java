package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.Model;

public class ModelWrapper {

	private int id;
	private String name;
	private String year;
	private String version;
	private String description;

	public ModelWrapper() {
	}

	public ModelWrapper(int id, String name, String year, String version, String description) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.version = version;
		this.description = description;
	}

	public ModelWrapper(Model model) {
		this(model.getId(), model.getName(), model.getYear(), model.getVersion(), model.getDescription());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

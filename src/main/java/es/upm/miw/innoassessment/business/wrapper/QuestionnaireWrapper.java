package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.Questionnaire;

public class QuestionnaireWrapper {

	private int id;
	private String name;
	private String version;
	private int modelId;
	private String modelName;
	private String modelYear;
	private String modelVersion;
	private String modelDescription;

	public QuestionnaireWrapper() {
	}

	public QuestionnaireWrapper(int id, String name, String version, int modelId) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.modelId = modelId;
	}

	public QuestionnaireWrapper(int id, String name, String version, int modelId, String modelName, String modelYear,
			String modelVersion, String modelDescription) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.modelId = modelId;
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.modelVersion = modelVersion;
		this.modelDescription = modelDescription;
	}

	public QuestionnaireWrapper(Questionnaire questionnaire) {
		this(questionnaire.getId(), questionnaire.getName(), questionnaire.getVersion(),
				questionnaire.getModel().getId(), questionnaire.getModel().getName(),
				questionnaire.getModel().getYear(), questionnaire.getModel().getVersion(),
				questionnaire.getModel().getDescription());
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelVersion() {
		return modelVersion;
	}

	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

	public String getModelDescription() {
		return modelDescription;
	}

	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

}

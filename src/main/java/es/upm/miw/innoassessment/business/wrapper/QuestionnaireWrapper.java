package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.Questionnaire;

public class QuestionnaireWrapper {

	private int id;
	private String name;
	private String version;
	private int modelId;

	public QuestionnaireWrapper() {
	}

	public QuestionnaireWrapper(int id, String name, String version, int modelId) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.modelId = modelId;
	}

	public QuestionnaireWrapper(Questionnaire questionnaire) {
		this(questionnaire.getId(), questionnaire.getName(), questionnaire.getVersion()
				,questionnaire.getModel().getId());
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

	

}

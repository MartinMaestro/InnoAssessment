package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.AssessmentLine;

public class AssessmentLineWrapper {

	private int id;
	private int questionnaireId;
	private String questionnaireName;
	private String questionnaireVersion;
	private int modelItemId;
	private int modelItemModelId;
	private String modelItemModelName;
	private String modelItemModelYear;
	private String modelItemModelVersion;
	private String modelItemModelDescription;
	private int modelItemDimensionId;
	private String modelItemDimensionName;
	private int modelItemFactorId;
	private String modelItemFactorName;
	private String modelItemFactorDefinition;
	private String modelItemImpact;
	private String modelItemWeight;
	private String modelItemInterpretation;
	private String modelItemHelp;

	public AssessmentLineWrapper(int id, int questionnaireId, String questionnaireName, String questionnaireVersion,
			int modelItemId, int modelItemModelId, String modelItemModelName, String modelItemModelYear,
			String modelItemModelVersion, String modelItemModelDescription, int modelItemDimensionId,
			String modelItemDimensionName, int modelItemFactorId, String modelItemFactorName,
			String modelItemFactorDefinition, String modelItemImpact, String modelItemWeight,
			String modelItemInterpretation, String modelItemHelp) {
		super();
		this.id = id;
		this.questionnaireId = questionnaireId;
		this.questionnaireName = questionnaireName;
		this.questionnaireVersion = questionnaireVersion;
		this.modelItemId = modelItemId;
		this.modelItemModelId = modelItemModelId;
		this.modelItemModelName = modelItemModelName;
		this.modelItemModelYear = modelItemModelYear;
		this.modelItemModelVersion = modelItemModelVersion;
		this.modelItemModelDescription = modelItemModelDescription;
		this.modelItemDimensionId = modelItemDimensionId;
		this.modelItemDimensionName = modelItemDimensionName;
		this.modelItemFactorId = modelItemFactorId;
		this.modelItemFactorName = modelItemFactorName;
		this.modelItemFactorDefinition = modelItemFactorDefinition;
		this.modelItemImpact = modelItemImpact;
		this.modelItemWeight = modelItemWeight;
		this.modelItemInterpretation = modelItemInterpretation;
		this.modelItemHelp = modelItemHelp;
	}

	public AssessmentLineWrapper(AssessmentLine assessmentLine) {
		this(assessmentLine.getId(), assessmentLine.getQuestionnaire().getId(),
				assessmentLine.getQuestionnaire().getName(), assessmentLine.getQuestionnaire().getVersion(),
				assessmentLine.getModelItem().getId(), assessmentLine.getModelItem().getModel().getId(),
				assessmentLine.getModelItem().getModel().getName(), assessmentLine.getModelItem().getModel().getYear(),
				assessmentLine.getModelItem().getModel().getVersion(),
				assessmentLine.getModelItem().getModel().getDescription(),
				assessmentLine.getModelItem().getDimension().getId(),
				assessmentLine.getModelItem().getDimension().getName(),
				assessmentLine.getModelItem().getFactor().getId(), assessmentLine.getModelItem().getFactor().getName(),
				assessmentLine.getModelItem().getFactor().getDefinition(), assessmentLine.getModelItem().getImpact(),
				assessmentLine.getModelItem().getWeight(), assessmentLine.getModelItem().getInterpretation(),
				assessmentLine.getModelItem().getHelp());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getQuestionnaireName() {
		return questionnaireName;
	}

	public void setQuestionnaireName(String questionnaireName) {
		this.questionnaireName = questionnaireName;
	}

	public String getQuestionnaireVersion() {
		return questionnaireVersion;
	}

	public void setQuestionnaireVersion(String questionnaireVersion) {
		this.questionnaireVersion = questionnaireVersion;
	}

	public int getModelItemId() {
		return modelItemId;
	}

	public void setModelItemId(int modelItemId) {
		this.modelItemId = modelItemId;
	}

	public int getModelItemModelId() {
		return modelItemModelId;
	}

	public void setModelItemModelId(int modelItemModelId) {
		this.modelItemModelId = modelItemModelId;
	}

	public String getModelItemModelName() {
		return modelItemModelName;
	}

	public void setModelItemModelName(String modelItemModelName) {
		this.modelItemModelName = modelItemModelName;
	}

	public String getModelItemModelYear() {
		return modelItemModelYear;
	}

	public void setModelItemModelYear(String modelItemModelYear) {
		this.modelItemModelYear = modelItemModelYear;
	}

	public String getModelItemModelVersion() {
		return modelItemModelVersion;
	}

	public void setModelItemModelVersion(String modelItemModelVersion) {
		this.modelItemModelVersion = modelItemModelVersion;
	}

	public String getModelItemModelDescription() {
		return modelItemModelDescription;
	}

	public void setModelItemModelDescription(String modelItemModelDescription) {
		this.modelItemModelDescription = modelItemModelDescription;
	}

	public int getModelItemDimensionId() {
		return modelItemDimensionId;
	}

	public void setModelItemDimensionId(int modelItemDimensionId) {
		this.modelItemDimensionId = modelItemDimensionId;
	}

	public String getModelItemDimensionName() {
		return modelItemDimensionName;
	}

	public void setModelItemDimensionName(String modelItemDimensionName) {
		this.modelItemDimensionName = modelItemDimensionName;
	}

	public int getModelItemFactorId() {
		return modelItemFactorId;
	}

	public void setModelItemFactorId(int modelItemFactorId) {
		this.modelItemFactorId = modelItemFactorId;
	}

	public String getModelItemFactorName() {
		return modelItemFactorName;
	}

	public void setModelItemFactorName(String modelItemFactorName) {
		this.modelItemFactorName = modelItemFactorName;
	}

	public String getModelItemFactorDefinition() {
		return modelItemFactorDefinition;
	}

	public void setModelItemFactorDefinition(String modelItemFactorDefinition) {
		this.modelItemFactorDefinition = modelItemFactorDefinition;
	}

	public String getModelItemImpact() {
		return modelItemImpact;
	}

	public void setModelItemImpact(String modelItemImpact) {
		this.modelItemImpact = modelItemImpact;
	}

	public String getModelItemWeight() {
		return modelItemWeight;
	}

	public void setModelItemWeight(String modelItemWeight) {
		this.modelItemWeight = modelItemWeight;
	}

	public String getModelItemInterpretation() {
		return modelItemInterpretation;
	}

	public void setModelItemInterpretation(String modelItemInterpretation) {
		this.modelItemInterpretation = modelItemInterpretation;
	}

	public String getModelItemHelp() {
		return modelItemHelp;
	}

	public void setModelItemHelp(String modelItemHelp) {
		this.modelItemHelp = modelItemHelp;
	}

}

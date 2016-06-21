package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.Model;
import es.upm.miw.innoassessment.data.entities.ModelItem;

public class ModelItemWrapper {

	private int id;
	private int modelId;
	private String modelName;
	private String modelYear;
	private String modelVersion;
	private String modelDescription;
	private int dimensionId;
	private String dimensionName;
	private int factorId;
	private String factorName;
	private String factorDefinition;
	private String impact;
	private String weight;
	private String interpretation;
	private String help;

	public ModelItemWrapper() {
	}

	public ModelItemWrapper(int id, int modelId, String modelName, String modelYear, String modelVersion,
			String modelDescription, int dimensionId, String dimensionName, int factorId, String factorName,
			String factorDefinition, String impact, String weight, String interpretation, String help) {
		super();
		this.id = id;
		this.modelId = modelId;
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.modelVersion = modelVersion;
		this.modelDescription = modelDescription;
		this.dimensionId = dimensionId;
		this.dimensionName = dimensionName;
		this.factorId = factorId;
		this.factorName = factorName;
		this.factorDefinition = factorDefinition;
		this.impact = impact;
		this.weight = weight;
		this.interpretation = interpretation;
		this.help = help;
	}
	
	public ModelItemWrapper(int modelId, String modelName, int dimensionId, String dimensionName, int factorId, String factorName
			, String impact, String weight, String interpretation, String help) {
		super();
		this.modelId = modelId;
		this.modelName = modelName;
		this.dimensionId = dimensionId;
		this.dimensionName = dimensionName;
		this.factorId = factorId;
		this.factorName = factorName;		
		this.impact = impact;
		this.weight = weight;
		this.interpretation = interpretation;
		this.help = help;
	}
	
	public ModelItemWrapper( int modelId, int dimensionId, int factorId,String impact, String weight, String interpretation, String help) {
		super();		
		this.modelId = modelId;
		this.dimensionId = dimensionId;
		this.factorId = factorId;
		this.impact = impact;
		this.weight = weight;
		this.interpretation = interpretation;
		this.help = help;
	}

	public ModelItemWrapper(ModelItem modelItem) {
		this(modelItem.getId(), modelItem.getModel().getId(), modelItem.getModel().getName(),
				modelItem.getModel().getYear(), modelItem.getModel().getVersion(),
				modelItem.getModel().getDescription(), modelItem.getDimension().getId(),
				modelItem.getDimension().getName(), modelItem.getFactor().getId(), modelItem.getFactor().getName(),
				modelItem.getFactor().getDefinition(), modelItem.getImpact(), modelItem.getWeight(),
				modelItem.getInterpretation(), modelItem.getHelp());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
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

	public int getDimensionId() {
		return dimensionId;
	}

	public void setDimensionId(int dimensionId) {
		this.dimensionId = dimensionId;
	}

	public String getDimensionName() {
		return dimensionName;
	}

	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}

	public int getFactorId() {
		return factorId;
	}

	public void setFactorId(int factorId) {
		this.factorId = factorId;
	}

	public String getFactorName() {
		return factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	public String getFactorDefinition() {
		return factorDefinition;
	}

	public void setFactorDefinition(String factorDefinition) {
		this.factorDefinition = factorDefinition;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getInterpretation() {
		return interpretation;
	}

	public void setInterpretation(String interpretation) {
		this.interpretation = interpretation;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

}

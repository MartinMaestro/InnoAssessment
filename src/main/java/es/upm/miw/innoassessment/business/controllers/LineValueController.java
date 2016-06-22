package es.upm.miw.innoassessment.business.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.business.charts.Chart;
import es.upm.miw.innoassessment.business.charts.representation.Representation;
import es.upm.miw.innoassessment.business.charts.representation.RepresentationFactory;
import es.upm.miw.innoassessment.data.daos.DimensionDao;
import es.upm.miw.innoassessment.data.daos.EvaluationResultDao;
import es.upm.miw.innoassessment.data.daos.LineValueDao;
import es.upm.miw.innoassessment.data.entities.Dimension;
import es.upm.miw.innoassessment.data.entities.Evaluation;
import es.upm.miw.innoassessment.data.entities.EvaluationResult;
import es.upm.miw.innoassessment.data.entities.EvaluationResultType;
import es.upm.miw.innoassessment.data.entities.LineValue;
import es.upm.miw.innoassessment.data.entities.ValueName;

@Controller
public class LineValueController {

	private LineValueDao lineValueDao;
	private DimensionDao dimensionDao;
	private EvaluationResultDao evaluationResultDao;

	@Autowired
	public void setLineValueDao(LineValueDao lineValueDao) {
		this.lineValueDao = lineValueDao;
	}

	@Autowired
	public void setQuestionnaireDao(DimensionDao dimensionDao) {
		this.dimensionDao = dimensionDao;
	}

	@Autowired
	public void setEvaluationResultDao(EvaluationResultDao evaluationResultDao) {
		this.evaluationResultDao = evaluationResultDao;
	}

	public List<LineValue> findByEvaluationId(int evaluationId) {
		return lineValueDao.findByEvaluationIdOrderByAssessmentLineId(evaluationId);
	}

	public boolean createLineValues(List<LineValue> lineValues, int questionnaireId, int evaluationId) {
		List<LineValue> lineValuesSaved = lineValueDao.save(lineValues);
		lineValueDao.flush();
		generateCharts(lineValuesSaved, questionnaireId, evaluationId);	
		return true;
	}
	
	private void generateCharts(List<LineValue> lineValuesSaved, int questionnaireId, int evaluationId){
		RepresentationFactory representationFactory = new RepresentationFactory();
		HashMap<Integer, Chart> dimensionChartHashMap = getDimensionChartHashMap(questionnaireId);
		for(LineValue lineValue : lineValuesSaved){
			Representation representation = representationFactory.createRepresentation(lineValue.getAssessmentLine().getType(), lineValue.getValueName(), lineValue.getAssessmentLine().getModelItem().getWeight());
			Chart chart = dimensionChartHashMap.get(lineValue.getAssessmentLine().getModelItem().getDimension().getId());
			chart.addUpperLimitImpact(representation.getMaximum());
			chart.addLowerLimitImpact(representation.getMinimum());
			chart.addOptimalUpperLimitImpact(representation.getOptimum());
			if(representation.getValueName() != ValueName.NOT_APPLICABLE){
				chart.addRealDimensionImpact(representation.getWeighedValue());
				if(representation.getValueName() == ValueName.UNKNOWN){
					chart.addMaximumAchievableImpact(representation.getMaximum());
					chart.addMinimumAchievableImpact(representation.getMinimum());
					chart.addOptimumAchievableImpact(representation.getOptimum());
				} else {
					chart.addMaximumAchievableImpact(representation.getWeighedValue());
					chart.addMinimumAchievableImpact(representation.getWeighedValue());
					chart.addOptimumAchievableImpact(representation.getWeighedValue());				
				}
			}
		}
		
		ArrayList<EvaluationResult> evaluationResults = new ArrayList<EvaluationResult>();
		EvaluationResultType[] evaluationResultTypes = EvaluationResultType.values();
		for(int dimensionId : dimensionChartHashMap.keySet()){
			Chart chart = dimensionChartHashMap.get(dimensionId);
			for(EvaluationResultType evaluationResultType : evaluationResultTypes){
				evaluationResults.add(new EvaluationResult(new Evaluation(evaluationId), new Dimension(dimensionId), evaluationResultType,
						chart.getValueByEvaluationResultType(evaluationResultType), chart.getPercentageValueByEvaluationResultType(evaluationResultType)));
			}
		}
		evaluationResultDao.save(evaluationResults);
		evaluationResultDao.flush();
	}
	
	private HashMap<Integer, Chart> getDimensionChartHashMap(int questionnaireId){
		List<Dimension> dimensionList = dimensionDao.findByQuestionnaireId(questionnaireId);
		HashMap<Integer, Chart> dimensionChartHashMap = new HashMap<Integer, Chart>();
		for(Dimension dimension: dimensionList){
			dimensionChartHashMap.put(dimension.getId(), new Chart());
		}
		return dimensionChartHashMap;
	}
}

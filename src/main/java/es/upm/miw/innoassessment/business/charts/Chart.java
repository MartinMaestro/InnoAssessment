package es.upm.miw.innoassessment.business.charts;

import es.upm.miw.innoassessment.data.entities.EvaluationResultType;

public class Chart {

	private float optimalUpperLimitImpact = 0f;
	private float upperLimitImpact = 0f;
	private float optimumAchievableImpact = 0f;
	private float maximumAchievableImpact = 0f;
	private float realDimensionImpact = 0f;
	private float minimumAchievableImpact = 0f;
	private float lowerLimitImpact = 0f;
	
	public Float getValueByEvaluationResultType(EvaluationResultType evaluationResultType){		
		switch(evaluationResultType){
		case OPTIMUM_LIMIT_IMPACT:
			return optimalUpperLimitImpact;
		case UPPER_LIMIT_IMPACT:
			return upperLimitImpact;
		case OPTIMUM_ACHIEVABLE_IMPACT:
			return optimumAchievableImpact;
		case MAXIMUM_ACHIEVABLE_IMPACT:
			return maximumAchievableImpact;
		case REAL_DIMENSION_IMPACT:
			return realDimensionImpact;
		case MINIMUM_ACHIEVABLE_IMPACT:
			return minimumAchievableImpact;
		case LOWER_LIMIT_IMPACT:
			return lowerLimitImpact;
		default:
			return null;		
		}		
	}
	
	public Float getPercentageValueByEvaluationResultType(EvaluationResultType evaluationResultType){
		return ((getValueByEvaluationResultType(evaluationResultType) + getDelta())/(getMax() + getDelta())) * 100;	
	}
	
	public float getOptimalUpperLimitImpact() {
		return optimalUpperLimitImpact;
	}
	public void setOptimalUpperLimitImpact(float optimalUpperLimitImpact) {
		this.optimalUpperLimitImpact = optimalUpperLimitImpact;
	}
	public void addOptimalUpperLimitImpact(float optimalUpperLimitImpact) {
		this.optimalUpperLimitImpact += optimalUpperLimitImpact;
	}
	public float getUpperLimitImpact() {
		return upperLimitImpact;
	}
	public void setUpperLimitImpact(float upperLimitImpact) {
		this.upperLimitImpact = upperLimitImpact;
	}
	public void addUpperLimitImpact(float upperLimitImpact) {
		this.upperLimitImpact += upperLimitImpact;
	}
	public float getOptimumAchievableImpact() {
		return optimumAchievableImpact;
	}
	public void setOptimumAchievableImpact(float optimumAchievableImpact) {
		this.optimumAchievableImpact = optimumAchievableImpact;
	}
	public void addOptimumAchievableImpact(float optimumAchievableImpact) {
		this.optimumAchievableImpact += optimumAchievableImpact;
	}
	public float getMaximumAchievableImpact() {
		return maximumAchievableImpact;
	}
	public void setMaximumAchievableImpact(float maximumAchievableImpact) {
		this.maximumAchievableImpact = maximumAchievableImpact;
	}
	public void addMaximumAchievableImpact(float maximumAchievableImpact) {
		this.maximumAchievableImpact += maximumAchievableImpact;
	}
	public float getRealDimensionImpact() {
		return realDimensionImpact;
	}
	public void setRealDimensionImpact(float realDimensionImpact) {
		this.realDimensionImpact = realDimensionImpact;
	}
	public void addRealDimensionImpact(float realDimensionImpact) {
		this.realDimensionImpact += realDimensionImpact;
	}
	public float getMinimumAchievableImpact() {
		return minimumAchievableImpact;
	}
	public void setMinimumAchievableImpact(float minimumAchievableImpact) {
		this.minimumAchievableImpact = minimumAchievableImpact;
	}
	public void addMinimumAchievableImpact(float minimumAchievableImpact) {
		this.minimumAchievableImpact += minimumAchievableImpact;
	}
	public float getLowerLimitImpact() {
		return lowerLimitImpact;
	}
	public void setLowerLimitImpact(float lowerLimitImpact) {
		this.lowerLimitImpact = lowerLimitImpact;
	}
	public void addLowerLimitImpact(float lowerLimitImpact) {
		this.lowerLimitImpact += lowerLimitImpact;
	}
	
	private float getMax(){
		return optimalUpperLimitImpact > upperLimitImpact? optimalUpperLimitImpact : upperLimitImpact;
	}
	
	private float getMin(){
		return minimumAchievableImpact < lowerLimitImpact? minimumAchievableImpact : lowerLimitImpact;
	}
	
	private float getDelta(){
		return getMin() < 0f? -getMin() : 0f;
	}
}

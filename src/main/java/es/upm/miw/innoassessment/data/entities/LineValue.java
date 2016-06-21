package es.upm.miw.innoassessment.data.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;

@Entity
public class LineValue {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn
	Evaluation evaluation;

	@ManyToOne
	@JoinColumn
	private AssessmentLine assessmentLine;

	@Enumerated(EnumType.STRING)
	private ValueName valueName;

	@Column(nullable = false)
	private int valueData;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	List<SourceUrl> sourcesUrls;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	List<SourceFile> sourcesFiles;

	public LineValue() {

	}

	public LineValue(int id) {
		this.id = id;
	}

	public LineValue(Evaluation evaluation, AssessmentLine assessmentLine, ValueName valueName, int valueData,
			List<SourceUrl> sourcesUrls, List<SourceFile> sourcesFiles) {
		this.evaluation = evaluation;
		this.assessmentLine = assessmentLine;
		this.valueName = valueName;
		this.valueData = valueData;
		this.sourcesUrls = sourcesUrls;
		this.sourcesFiles = sourcesFiles;
	}

	public LineValue(Evaluation evaluation, AssessmentLine assessmentLine, String name, int valueData,
			List<SourceUrl> sourcesUrls, List<SourceFile> sourcesFiles) {
		this.evaluation = evaluation;
		this.assessmentLine = assessmentLine;
		this.valueName = ValueName.getByName(name);
		this.valueData = valueData;
		this.sourcesUrls = sourcesUrls;
		this.sourcesFiles = sourcesFiles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public AssessmentLine getAssessmentLine() {
		return assessmentLine;
	}

	public void setAssessmentLine(AssessmentLine assessmentLine) {
		this.assessmentLine = assessmentLine;
	}

	public ValueName getValueName() {
		return valueName;
	}

	public void setValueName(ValueName valueName) {
		this.valueName = valueName;
	}

	public void setValueNameByName(ValueName name) {
		this.valueName = name;
	}

	public int getValueData() {
		return valueData;
	}

	public void setValueData(int valueData) {
		this.valueData = valueData;
	}

	public List<SourceUrl> getSourcesUrls() {
		return sourcesUrls;
	}

	public void setSourcesUrls(List<SourceUrl> sourcesUrls) {
		this.sourcesUrls = sourcesUrls;
	}

	public List<SourceFile> getSourcesFiles() {
		return sourcesFiles;
	}

	public void setSourcesFiles(List<SourceFile> sourcesFiles) {
		this.sourcesFiles = sourcesFiles;
	}

}

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

    @OneToMany(cascade=CascadeType.REMOVE, fetch = FetchType.EAGER)
    List<SourceUrl> sourcesUrls;
    
    @OneToMany(cascade=CascadeType.REMOVE, fetch = FetchType.EAGER)
    List<SourceFile> sourcesFiles;

	public LineValue(Evaluation evaluation, AssessmentLine assessmentLine, ValueName valueName, int valueData, List<SourceUrl> sourcesUrls, List<SourceFile> sourcesFiles) {
		this.evaluation = evaluation;
		this.assessmentLine = assessmentLine;
		this.valueName = valueName;
		this.valueData = valueData;
		this.sourcesUrls = sourcesUrls;
		this.sourcesFiles = sourcesFiles;
	}

}

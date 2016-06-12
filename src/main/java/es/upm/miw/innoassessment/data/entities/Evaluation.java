package es.upm.miw.innoassessment.data.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={
		   @UniqueConstraint(columnNames={"questionnaire_id", "productVersion_id", "creationTimeStamp"})
		})
public class Evaluation {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn
	private Questionnaire questionnaire;

	@ManyToOne
	@JoinColumn
	private ProductVersion productVersion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date creationTimeStamp;
	

	public Evaluation() {}


	public Evaluation(Questionnaire questionnaire, ProductVersion productVersion, Date creationTimeStamp) {
		this.questionnaire = questionnaire;
		this.productVersion = productVersion;
		this.creationTimeStamp = creationTimeStamp;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}


	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}


	public ProductVersion getProductVersion() {
		return productVersion;
	}


	public void setProductVersion(ProductVersion productVersion) {
		this.productVersion = productVersion;
	}


	public Date getCreationTimeStamp() {
		return creationTimeStamp;
	}


	public void setCreationTimeStamp(Date creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}	

}

package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.GeneratedValue;

import java.sql.Blob;

import javax.persistence.Column;

@Entity
public class SourceFile {
	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String filename;
	
	@Column(name="content_type")
	private String contentType;
	
	@Column(name="content")
	@Lob
	private Blob content;

	public SourceFile(String filename, String contentType, Blob content) {
		this.filename = filename;
		this.contentType = contentType;
		this.content = content;
	}

	

}

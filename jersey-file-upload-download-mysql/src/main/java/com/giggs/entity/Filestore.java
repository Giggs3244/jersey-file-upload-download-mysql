package com.giggs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the filestore database table.
 * 
 */
@Entity
@Table(name = "filestore")
@NamedQuery(name = "Filestore.findAll", query = "SELECT f FROM Filestore f")
public class Filestore implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 10)
	private String department;

	@Column(length = 50)
	private String description;

	@Lob
	@Column(name = "file_blob")
	private byte[] fileBlob;

	@Column(name = "file_year", length = 4)
	private String fileYear;

	@Column(length = 255)
	private String filename;

	@Id
	@Column(nullable = false, length = 10)
	private String id;

	public Filestore() {
		// default constructor
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getFileBlob() {
		return this.fileBlob;
	}

	public void setFileBlob(byte[] fileBlob) {
		this.fileBlob = fileBlob;
	}

	public String getFileYear() {
		return this.fileYear;
	}

	public void setFileYear(String fileYear) {
		this.fileYear = fileYear;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
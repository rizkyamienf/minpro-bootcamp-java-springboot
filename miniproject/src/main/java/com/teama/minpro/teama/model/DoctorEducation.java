package com.teama.minpro.teama.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="m_doctor_education")
public class DoctorEducation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="doctor_id", insertable = false, updatable = false)
	private Doctor doctorId;
	
	@ManyToOne
	@JoinColumn(name="education_level_id", insertable = false, updatable = false)
	private EducationLevel eduLevelId;
	
	@Column(name="institution_name")
	private String institutionName;
	
	@Column(name="major")
	private String major;
	
	@Column(name="end_year")
	private String endYear;
	
	@Column(name="is_last_education")
	private Boolean isLastEducation;
	
	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "modified_by")
	private Long modifiedBy;

	@Column(name = "modified_on")
	private LocalDateTime modifiedOn;

	@Column(name = "deleted_by")
	private Long deletedBy;

	@Column(name = "deleted_on")
	private LocalDateTime deletedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Doctor getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Doctor doctorId) {
		this.doctorId = doctorId;
	}

	public EducationLevel getEduLevelId() {
		return eduLevelId;
	}

	public void setEduLevelId(EducationLevel eduLevelId) {
		this.eduLevelId = eduLevelId;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public Boolean getIsLastEducation() {
		return isLastEducation;
	}

	public void setIsLastEducation(Boolean isLastEducation) {
		this.isLastEducation = isLastEducation;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}

	public LocalDateTime getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(LocalDateTime deletedOn) {
		this.deletedOn = deletedOn;
	}

	
	
}

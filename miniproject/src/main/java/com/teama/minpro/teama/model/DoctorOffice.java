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
@Table(name="t_doctor_office")
public class DoctorOffice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="doctor_id", insertable = false, updatable = false)
	private Doctor doctorId;
	
	@ManyToOne
	@JoinColumn(name="medical_facility_id", insertable = false, updatable= false)
	private MedicalFacility medFacilityId;
	
	@Column(name="specialization")
	private String specialization;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@Column(name="created_by")
	private Long createdBy;
	
	@Column(name="created_on")
	private LocalDateTime createdOn;
	
	@Column(name="is_delete")
	private Boolean isDelete;
	
	@Column(name="modified_by")
	private Long modifiedBy;
	
	@Column(name="modified_on")
	private LocalDateTime modifiedOn;
	
	@Column(name="deleted_by")
	private Long deletedBy;
	
	@Column(name="deleted_on")
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

	public MedicalFacility getMedFacilityId() {
		return medFacilityId;
	}

	public void setMedFacilityId(MedicalFacility medFacilityId) {
		this.medFacilityId = medFacilityId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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

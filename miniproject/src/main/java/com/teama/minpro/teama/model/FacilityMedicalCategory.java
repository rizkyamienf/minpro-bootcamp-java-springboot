package com.teama.minpro.teama.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_medical_facility_category")
public class FacilityMedicalCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="name")
	private String categoryFacilityName;
	
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

}

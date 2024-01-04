package com.teama.minpro.teama.model;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

public class VMBiodata {
	private Long id;
	private String fullName;
	private String mobilePhone;
	private String image;
	private String pathImage;
	private MultipartFile filename;
	private Long createdBy;
	private LocalDateTime createdOn;
	private Boolean isDelete;
	private Long modifiedBy;
	private LocalDateTime modifiedOn;
	private Long deletedBy;
	private LocalDateTime deletedOn;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	public MultipartFile getFilename() {
		return filename;
	}
	public void setFilename(MultipartFile filename) {
		this.filename = filename;
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
	@Override
	public String toString() {
		return "VMBiodata [id=" + id + ", fullName=" + fullName + ", mobilePhone=" + mobilePhone + ", image=" + image
				+ ", pathImage=" + pathImage + ", filename=" + filename + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", isDelete=" + isDelete + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn
				+ ", deletedBy=" + deletedBy + ", deletedOn=" + deletedOn + "]";
	}




}

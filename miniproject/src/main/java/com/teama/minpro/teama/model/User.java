package com.teama.minpro.teama.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "m_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "m_biodata", insertable = false, updatable = false)
	private Biodata biodata;
	
	@Column(name="biodata_id")
	private Long biodataId;

	@ManyToOne
	@JoinColumn(name = "m_role", insertable = false, updatable = false)
	private Role role;
	
	@Column(name="role_id")
	private Long roleId;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Biodata getBiodata() {
		return biodata;
	}


	public void setBiodata(Biodata biodata) {
		this.biodata = biodata;
	}


	public Long getBiodataId() {
		return biodataId;
	}


	public void setBiodataId(Long biodataId) {
		this.biodataId = biodataId;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Long getRoleId() {
		return roleId;
	}


	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}

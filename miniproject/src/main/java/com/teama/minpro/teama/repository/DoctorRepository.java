package com.teama.minpro.teama.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teama.minpro.teama.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	@Query(value="SELECT DISTINCT d.* FROM m_doctor d JOIN m_biodata b ON d.biodata_id = ?1" , nativeQuery = true)
	Doctor findByIdDoctor(Long biodataId);
}

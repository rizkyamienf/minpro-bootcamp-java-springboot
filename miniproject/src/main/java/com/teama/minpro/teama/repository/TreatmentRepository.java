package com.teama.minpro.teama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teama.minpro.teama.model.TreatmentDoctor;

public interface TreatmentRepository extends JpaRepository<TreatmentDoctor, Long> {
	@Query(value="SELECT DISTINCT t.* FROM t_doctor_treatment t JOIN m_doctor d ON t.doctor_id = d.id JOIN m_biodata b ON d.biodata_id = ?1" , nativeQuery = true)
	List<TreatmentDoctor> findByIdDoctor(Long biodataId);
}

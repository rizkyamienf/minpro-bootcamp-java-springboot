package com.teama.minpro.teama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teama.minpro.teama.model.DoctorEducation;

public interface DoctorEducationRepository extends JpaRepository<DoctorEducation, Long> {
	@Query(value="SELECT DISTINCT * FROM m_doctor_education e\r\n"
			+ "where e.doctor_id = ?1 ORDER BY e.end_year DESC", nativeQuery=true)
	List<DoctorEducation> findEducationByDoctorId(Long doctorId);
}

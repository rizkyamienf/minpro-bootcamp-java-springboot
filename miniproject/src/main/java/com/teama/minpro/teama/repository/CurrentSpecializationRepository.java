package com.teama.minpro.teama.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teama.minpro.teama.model.DoctorSpecialization;

public interface CurrentSpecializationRepository extends JpaRepository<DoctorSpecialization, Long> {
	@Query(value="SELECT * FROM t_current_doctor_specialization c\r\n"
			+ "WHERE c.doctor_id = ?1", nativeQuery=true)
	Optional<DoctorSpecialization> findByDoctorId(Long doctorId);
}

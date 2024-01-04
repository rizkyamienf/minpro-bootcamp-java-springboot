package com.teama.minpro.teama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teama.minpro.teama.model.DoctorOffice;

public interface DoctorOfficeRepository extends JpaRepository<DoctorOffice, Long> {
	@Query(value="SELECT * FROM t_doctor_office where doctor_id = ?1", nativeQuery = true)
	List<DoctorOffice> findByDoctorId(Long doctorId);
}

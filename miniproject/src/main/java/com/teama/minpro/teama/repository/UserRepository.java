package com.teama.minpro.teama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teama.minpro.teama.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value="SELECT * FROM m_user WHERE biodata_id = ?1", nativeQuery=true)
	User findByBiodataId(Long biodataId);
}

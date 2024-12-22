package com.fedcorp.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.Enterprises;

@Repository
public interface EnterprisesRepository extends JpaRepository<Enterprises, Long> {

	@Query(nativeQuery = true, value = "UPDATE enterprises SET active = 0, updated_at = CURRENT_TIMESTAMP WHERE APPLICATION_FORM_ID =:applnid")
	String updateEnterprise(@Param("applnid") String applnid);

	Enterprises  findFirstByApplicationFormId(Long applicationFormId);

	List<Enterprises> findByApplicationFormId(Long applnid);

}

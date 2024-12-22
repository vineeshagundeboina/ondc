package com.fedcorp.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.Documents;

@Repository
public interface DocumentsRepository extends JpaRepository< Documents, Long>{
	

	
	@Query(nativeQuery = true,value="SELECT documents.* FROM documents WHERE documents.application_form_id = :applnformid")
	List<Documents> applicationDocuments(@Param("applnformid") String applnformid );

	

}

package com.fedcorp.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>{
	
	
	@Query(nativeQuery = true, value="SELECT comments.* FROM comments WHERE comments.application_form_id = :applnformid ORDER BY comments.created_at DESC")
	List<Comments>  applicationComments(@Param("applnformid") String applnformid);
}

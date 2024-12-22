package com.fedcorp.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.BranchVerifications;

@Repository
public interface BranchVerificationsRepository extends JpaRepository<BranchVerifications, Long>{

	Integer countByApplicationFormId(long appform_id);

	BranchVerifications findByApplicationFormId(Long appform_id);

}

package com.fedcorp.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long>{

	List<Branch> findByBranchCode(String branchcode);

	Branch findFirstElementBySolIdAndBranchCode(String solId,String branchCode);
}

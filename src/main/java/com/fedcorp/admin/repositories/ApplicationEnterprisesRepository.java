package com.fedcorp.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.ApplicationEnterprises;
import com.fedcorp.admin.entities.Users;

@Repository
public interface ApplicationEnterprisesRepository extends JpaRepository<ApplicationEnterprises, Long> {
	
	@Query(nativeQuery = true, value="SELECT count(*) as total FROM application_enterprises WHERE application_enterprises.active = '1' AND application_enterprises.acc_no=:accountNo")
	Long totalApplicationByAccountNo(@Param("accountNo") String accountNo);


	ApplicationEnterprises findByApplicationFormId( Long applicationFormId);
	
	Integer countByActiveAndAccNo(Boolean active,String accNo);
	
	Integer countByPrefCorpInAndActive(List<String> prefCorp,Boolean active);

	ApplicationEnterprises findByAccNoAndApplicationFormId(String accNo, Long applicationFormId);

}

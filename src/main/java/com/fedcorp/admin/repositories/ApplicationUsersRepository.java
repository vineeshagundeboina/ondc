package com.fedcorp.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.ApplicationUsers;

@Repository
public interface ApplicationUsersRepository extends JpaRepository<ApplicationUsers, Long> {

	@Query(nativeQuery = true, value = "SELECT application_users.* FROM application_users WHERE application_users.application_enterprise_id =:entid and active=1")
	List<ApplicationUsers> applicationUser(@Param("entid") String applicationEnterprisesId);

	@Query(nativeQuery = true, value = "UPDATE enterprises SET active = false, updated_at = CURRENT_TIMESTAMP WHERE APPLICATION_FORM_ID =:entstrLong")
	String updateApplicationUser(@Param("entstrLong") String entstrLong);

	List<ApplicationUsers> findByApplicationEnterpriseId(String applicationEnterpriseId);

	Integer countByCustNoAndApplicationEnterpriseId(String custNo, String applicationEnterpriseId);

	ApplicationUsers findByApplicationEnterpriseIdAndMobileAndCustNo(String applicationEnterpriseId, String mobile,
			String custNo);

	@Query(nativeQuery = true, value = "select APPLICATION_USERS.* from APPLICATION_USERS where APPLICATION_USERS.PREF_NO=:prefNo  and application_users.APPLICATION_ENTERPRISE_ID =:applicationEnterpriseId ")
	ApplicationUsers getPrefNoAndApplicationEnterpriseId(@Param("prefNo") String prefNo,
			@Param("applicationEnterpriseId") String applicationEnterpriseId);

	ApplicationUsers findByMobileAndCustNoAndActive(String oldMobile, String cust, Boolean active);



}

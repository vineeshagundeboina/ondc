package com.fedcorp.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.Users;
@Repository
public interface UsersRespository extends JpaRepository<Users, Long>{
	
	@Query( nativeQuery = true ,value="select us.mobile from USERS us inner join ENTERPRISES e on us.ENTERPRISE_ID=e.id where e.ACC_NO=:account and e.ACTIVE=1 and us.MARK_AS_ENABLED=1")
	List<String> getUserMobile(@Param("account") String account);
	
	@Query( nativeQuery = true , value="select us.* from users  us inner join ENTERPRISES et on us.ENTERPRISE_ID=et.id where et.ACTIVE=1 and us.MARK_AS_ENABLED=1  and us.MOBILE in (:mobiles)")
	Users getUser(@Param("mobiles") List<String> mobiles);

	@Query( nativeQuery = true ,value="UPDATE users SET mark_as_enabled = 0 WHERE users.enterprise_id =:enterpid")
	String updateUser(@Param("enterpid") Long enterpid);
	
	
	List <Users> findByEnterprisesId(String enterprisesId);

	List<Users> findByPrefNo(String authuserperfid);

	
	 Users findFirstByPrefNoInAndMarkAsEnabled(List<String> prefNo,Integer markAsEnabled);

	Users findByMobileAndMarkAsEnabled(String oldMobile, Integer markAsEnabled);

	Users findByCustNoAndEnterprisesId(String user_cust_Id, String ent_applicationid);
	
}

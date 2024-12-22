package com.splenta.hrms.repos.auth;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.splenta.hrms.models.auth.Role;



public interface RoleRepo extends JpaRepository<Role, UUID>,JpaSpecificationExecutor<Role> {

	Page<Role> findAllByRoleType(String roleType, PageRequest of);

    Role findByName(String retailerRoleName);
    
    @Query("select s from Role s where (lower(s.description) like lower(concat('%', :str, '%'))) and s.isActive = :active")
	Page<Role> getAllRole(@Param("str") String str, @Param("active") boolean active, Pageable pageable);

}

package com.splenta.hrms.repos.masters;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.splenta.hrms.models.auth.RoleType;

@Repository
public interface RoleTypeRepo extends JpaRepository<RoleType, UUID>{

}

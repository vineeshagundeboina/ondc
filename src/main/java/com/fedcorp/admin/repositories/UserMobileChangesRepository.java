package com.fedcorp.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.UserMobileChanges;


@Repository
public interface UserMobileChangesRepository extends JpaRepository<UserMobileChanges, Long>{

}

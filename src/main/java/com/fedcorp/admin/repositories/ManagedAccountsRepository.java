package com.fedcorp.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fedcorp.admin.entities.ManagedAccounts;

public interface ManagedAccountsRepository  extends JpaRepository<ManagedAccounts, Long>{

	ManagedAccounts findByUserId(Long userId);

}

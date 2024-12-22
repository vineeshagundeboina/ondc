package com.splenta.hrms.audit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.splenta.hrms.models.common.AuditLog;

@Repository
public interface AuditRepo extends JpaRepository<AuditLog, String> {

	Page<AuditLog> findAllByTablename(String table_name, Pageable pageable);
}

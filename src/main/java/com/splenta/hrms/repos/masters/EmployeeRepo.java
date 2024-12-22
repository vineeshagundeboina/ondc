package com.splenta.hrms.repos.masters;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.models.masters.Employee;

@Repository
public interface EmployeeRepo extends GenericRepository<Employee>{

	Optional<Employee> findFirstByOrderByCreatedAtDesc();

	Optional<Employee> findByEmployeeId(String employeeId);

	Optional<Employee> findByMobileNumber(String mobileNumber);
}

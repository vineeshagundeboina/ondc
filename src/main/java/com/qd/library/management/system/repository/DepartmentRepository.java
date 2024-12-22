package com.qd.library.management.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qd.library.management.system.entity.Book;
import com.qd.library.management.system.entity.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	
    
    Department findByName(String name);

}

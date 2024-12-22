package com.splenta.hrms.repos.masters;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.splenta.hrms.models.common.MenuItem;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {

	Long countByName(String name);

	Long countByModule(Module module);

	Optional<MenuItem> findByName(String name);

	Optional<MenuItem> findByEntityname(String entityname);

}

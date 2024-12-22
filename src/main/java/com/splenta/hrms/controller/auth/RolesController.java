package com.splenta.hrms.controller.auth;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.models.auth.Role;
import com.splenta.hrms.repos.auth.RoleRepo;
import com.splenta.hrms.utilites.CopyPropertiesUtil;
import com.turkraft.springfilter.boot.FilterSpecification;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/roles")
@Tag(name = "Roles", description = "APIs for Role related operations")
public class RolesController {

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/all")
	@Operation(summary = "Get all Roles")
	public ResponseEntity<Page<Role>> getAll(@RequestParam(defaultValue = "0", value = "pageNo") int pageNo,
			@RequestParam(defaultValue = "25", value = "pageSize") int pageSize,
			@RequestParam(required = false, value = "filter") String filter,
			@RequestParam(defaultValue = "", required = false, value = "sortField") String sortField,
			@RequestParam(defaultValue = "ASC", required = false, value = "sortDir") String sortDir) {

		Specification<Role> spec = null;

		if (sortField.equals("")) {
			sortField = "createdAt";
		}

		Sort sortSt = sortDir.equals("DESC") ? Sort.by(sortField).descending() : Sort.by(sortField).ascending();

		if (filter != null) {
			spec = new FilterSpecification<Role>(filter);
		}
		return ResponseEntity.ok(roleRepo.findAll(spec, PageRequest.of(pageNo, pageSize, sortSt)));
	}

	@GetMapping("/count")
	@Operation(summary = "Get count of all Roles")
	public ResponseEntity<Integer> getCount() {
		return ResponseEntity.ok(roleRepo.findAll().size());

	}

	@GetMapping("/getAllByType/{roleType}")
	@Operation(summary = "Get all Roles By Type")
	public ResponseEntity<Page<Role>> getAllByType(@RequestParam(defaultValue = "0", value = "pageNo") int pageNo,
			@RequestParam(defaultValue = "25", value = "pageSize") int pageSize,
			@PathVariable("roleType") String roleType) {
		return ResponseEntity.ok(roleRepo.findAllByRoleType(roleType, PageRequest.of(pageNo, pageSize)));

	}

	@PostMapping("/create")
	@Operation(summary = "Create a new Role")
	public ResponseEntity<Role> create(@RequestBody Role role) {
		return ResponseEntity.ok(roleRepo.save(role));

	}

	@GetMapping("/get/{RoleId}")
	@Operation(summary = "Get one Role")
	public ResponseEntity<Role> getSingle(@PathVariable("RoleId") UUID RoleId) {
		return ResponseEntity.ok(roleRepo.findById(RoleId).get());
	}
	
//	@GetMapping("/getbyuser/{userId}")
//	@Operation(summary = "Get one Role By User")
//	public ResponseEntity<Role> getSingleUser(@PathVariable("userId") UUID userId) {
//		return ResponseEntity.ok(roleRepo.findByUserId(userId).get());
//	}
	

	@PutMapping("/update/{RoleId}")
	@Operation(summary = "Update a Role by Id")
	public ResponseEntity<Role> update(@PathVariable("RoleId") UUID roleId, @RequestBody Role role) {
		Role oldRole = roleRepo.findById(roleId).get();
		CopyPropertiesUtil.copyProperties(role, oldRole);
		return ResponseEntity.ok(roleRepo.save(oldRole));
	}

	@DeleteMapping("/delete/{RoleId}")
	@Operation(summary = "Delete a Role by Id")
	public ResponseEntity<?> delete(@PathVariable("RoleId") UUID roleId) {
		roleRepo.deleteById(roleId);
		return ResponseEntity.ok().build();
	}
}

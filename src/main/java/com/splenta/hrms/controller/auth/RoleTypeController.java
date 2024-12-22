package com.splenta.hrms.controller.auth;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.models.auth.RoleType;
import com.splenta.hrms.repos.masters.RoleTypeRepo;
import com.splenta.hrms.utilites.CopyPropertiesUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/roleType")
@Tag(name = "RoleType", description = "APIs for RoleType related operations")
public class RoleTypeController {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RoleTypeRepo roleTypeRepo;

	@GetMapping("/allroleTypes")
	@Operation(summary = "Get  RoleTypes")
	public ResponseEntity<?> getRoleTypes() {
		return ResponseEntity.ok(roleTypeRepo.findAll());
	}
	
	@PostMapping("/createroleType")
	@Operation(summary = "Create a new RoleTypes")
	public ResponseEntity<RoleType> createRoleType(@RequestBody RoleType roleType) {
		return ResponseEntity.ok(roleTypeRepo.save(roleType));

	}

	@PutMapping("/updateuserType/{userTypeId}")
	@Operation(summary = "Update a RoleTypes by Id")
	public ResponseEntity<?> updateRoleType(@PathVariable("userTypeId") UUID userTypeId, @RequestBody RoleType roleType) {
		RoleType oldRoleType = roleTypeRepo.findById(userTypeId).get();
		CopyPropertiesUtil.copyProperties(roleType, oldRoleType);
		return ResponseEntity.ok(roleTypeRepo.save(oldRoleType));
	}
	@DeleteMapping("/deleteuserType/{userTypeId}")
	@Operation(summary = "Delete a RoleTypes by Id")
	public ResponseEntity<?> deleteroleType(@PathVariable("userTypeId") UUID userTypeId) {
		roleTypeRepo.deleteById(userTypeId);
		return ResponseEntity.ok().build();
	}
}
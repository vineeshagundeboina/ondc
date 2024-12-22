package com.splenta.hrms.controller.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.splenta.hrms.models.auth.Privilege;
import com.splenta.hrms.models.auth.Role;
import com.splenta.hrms.models.auth.User;
import com.splenta.hrms.repos.auth.PrivilegeRepo;
import com.splenta.hrms.repos.auth.RoleRepo;
import com.splenta.hrms.repos.auth.UserRepo;
import com.splenta.hrms.utilites.CopyPropertiesUtil;
import com.turkraft.springfilter.boot.FilterSpecification;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/privilege")
@Tag(name = "Privileges", description = "APIs for Privilege Privileges related operations")
public class PrivilegesController {

    @Autowired
    private PrivilegeRepo privilegeRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/all")
    @Operation(summary = "Get all Roles")
    public ResponseEntity<Page<Privilege>> getAll(@RequestParam(defaultValue = "0", value = "pageNo") int pageNo,
            @RequestParam(defaultValue = "25", value = "pageSize") int pageSize,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(defaultValue = "", required = false, value = "sortField") String sortField,
            @RequestParam(defaultValue = "ASC", required = false, value = "sortDir") String sortDir) {
                
        Specification<Privilege> spec = null;

        if (sortField.equals("")) {
            sortField = "createdAt";
        }

        Sort sortSt = sortDir.equals("DESC") ? Sort.by(sortField).descending() : Sort.by(sortField).ascending();

        if (filter != null) {
            spec = new FilterSpecification<Privilege>(filter);
        } 
        return ResponseEntity.ok(privilegeRepo.findAll(spec, PageRequest.of(pageNo, pageSize, sortSt)));
    
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new Privilege")
    public ResponseEntity<Privilege> create(@RequestBody Privilege privilege) {
        return ResponseEntity.ok(privilegeRepo.save(privilege));

    }

    @GetMapping("/get/{privilegeId}")
    @Operation(summary = "Get one Privilege")
    public ResponseEntity<Privilege> getSingle(@PathVariable("privilegeId") UUID privilegeId) {
        return ResponseEntity.ok(privilegeRepo.findById(privilegeId).get());
    }

    @PutMapping("/update/{privilegeId}")
    @Operation(summary = "Update a Privilege by Id")
    public ResponseEntity<Privilege> update(@PathVariable("privilegeId") UUID privilegeId,
            @RequestBody Privilege privilege) {
        Privilege oldPrivilege = privilegeRepo.findById(privilegeId).get();
        CopyPropertiesUtil.copyProperties(privilege, oldPrivilege);
        return ResponseEntity.ok(privilegeRepo.save(oldPrivilege));
    }

    @DeleteMapping("/delete/{privilegeId}")
    @Operation(summary = "Delete a Privilege by Id")
    public ResponseEntity<?> delete(@PathVariable("privilegeId") UUID privilegeId) {
        privilegeRepo.deleteById(privilegeId);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getByRole/{roleId}")
    @Operation(summary = "getByRole")
    public ResponseEntity<?> getByRole(@PathVariable("roleId") UUID roleId) {
        Role role = roleRepo.findById(roleId).get();
        return ResponseEntity.ok(role.getPrivileges());
    }

    @GetMapping("/getByUser/{userId}")
    @Operation(summary = "getByRole")
    public ResponseEntity<?> getByUser(@PathVariable("userId") UUID userId) {
        Optional<User> user = userRepo.findById(userId);
        List<Privilege> privileges = new ArrayList<Privilege>();
        for (Role role : user.get().getRoles()) {
            privileges.addAll(role.getPrivileges());
        }
        return ResponseEntity.ok(privileges);
    }

    @GetMapping("/addToRole/{roleId}/{privilegeId}")
    @Operation(summary = "addToRole")
    public ResponseEntity<?> addToRole(@PathVariable("privilegeId") UUID privilegeId,
            @PathVariable("roleId") UUID roleId) {
        Privilege privilege = privilegeRepo.findById(privilegeId).get();
        Role role = roleRepo.findById(roleId).get();
        role.getPrivileges().add(privilege);
        roleRepo.save(role);
        return ResponseEntity.ok(role);
    }

    @GetMapping("/unlinkRole/{roleId}/{privilegeId}")
    @Operation(summary = "unlinkRole")
    public ResponseEntity<?> unlinkRole(@PathVariable("privilegeId") UUID privilegeId,
            @PathVariable("roleId") UUID roleId) {
        Privilege privilege = privilegeRepo.findById(privilegeId).get();
        Role role = roleRepo.findById(roleId).get();
        role.getPrivileges().remove(privilege);
        roleRepo.save(role);
        return ResponseEntity.ok(role);
    }

}

/*
 *************************************************************************
 * The contents of this file are subject to the Splenta  License
 * Version  1.0  (the  "License")
 * The Original Code belongs to Splenta Systems PVT LTD.
 * The Initial Developer of the Original Code is Splenta Systems PVT LTD
 * All portions are Copyright (C) 2020 Splenta Systems PVT LTD
 * All Rights Reserved.
 * Contributor(s): Vikas Ramireddy.
 ************************************************************************
 */
package com.splenta.hrms.audit;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.exception.GenericException;
import com.splenta.hrms.models.common.AuditLog;
import com.splenta.hrms.models.common.MenuItem;
import com.splenta.hrms.repos.masters.MenuItemRepo;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;



@RestController
@RequestMapping(path = "/api")
public class AuditController {

	@Autowired
	AuditRepo repo;

	@Autowired
	MenuItemRepo menurepo;

	private ModelMapper modelMapper;

	@GetMapping("/audit/{menu}")
	@io.swagger.v3.oas.annotations.Operation(summary = "Audit Details", security = @SecurityRequirement(name = "bearerAuth"))
	public Page<AuditLogDto> getAudit(@PathVariable String menu, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		MenuItem menuitem = menurepo.findByName(menu).orElse(null);
		if (menuitem != null) {
			Pageable pageble = PageRequest.of(page, size);
			Page<AuditLog> auditList = repo.findAllByTablename(menuitem.getEntityname(), pageble);
			List<AuditLogDto> auditdtolist = auditList.getContent().stream().map(this::convertToDto)
					.collect(Collectors.toList());
			Page<AuditLogDto> pages = new PageImpl<AuditLogDto>(auditdtolist, pageble, auditList.getTotalElements());
			return pages;
		} else {
			throw new GenericException("Invalid Menu Details.Please add the menu in the master");
		}

	}

	@GetMapping("/auditlog/{id}")
	@io.swagger.v3.oas.annotations.Operation(summary = "Audit Details", security = @SecurityRequirement(name = "bearerAuth"))
	public AuditLogDto getAudit(@PathVariable String id) {

		AuditLog log = repo.findById(id).orElse(null);
		if (log != null) {
			return convertToDto(log);
		}
		return null;
	}

	// @GetMapping("/auditlog")
	// @io.swagger.v3.oas.annotations.Operation(summary = "Audit Details", security
	// = @SecurityRequirement(name = "bearerAuth"))
	// public Page<AuditLogDto> getAudit(@RequestParam(defaultValue = "0") int page,
	// @RequestParam(defaultValue = "10") int size) {
	// Pageable pageble = PageRequest.of(page, size);
	// Page<AuditLog> auditList = repo.findAll(pageble);
	// List<AuditLogDto> auditdtolist =
	// auditList.getContent().stream().map(this::convertToDto)
	// .collect(Collectors.toList());
	// Page<AuditLogDto> pages = new PageImpl<AuditLogDto>(auditdtolist, pageble,
	// auditList.getTotalElements());
	// return pages;
	//
	// }

	private AuditLogDto convertToDto(AuditLog audit) {
		AuditLogDto auditDto = modelMapper.map(audit, AuditLogDto.class);
		return auditDto;
	}

}

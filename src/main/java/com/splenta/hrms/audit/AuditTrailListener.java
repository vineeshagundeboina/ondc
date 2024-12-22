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

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.PreRemove;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.splenta.hrms.models.auth.User;
import com.splenta.hrms.models.common.AuditLog;
import com.splenta.hrms.models.common.Menu;
import com.splenta.hrms.models.common.MenuItem;
import com.splenta.hrms.repos.auth.UserRepo;
import com.splenta.hrms.repos.masters.MenuItemRepo;


@Component
public class AuditTrailListener {

	private static final Logger log4j = LogManager.getLogger(AuditTrailListener.class);

	@Autowired
	private  AuditRepo auditrepo;

	@Autowired
	private UserRepo userrepo;

	@Autowired
	private MenuItemRepo menurepo;


	ObjectMapper mapper = new ObjectMapper();

	@PreRemove
	@Transactional
	private void beforeAnyUpdate(Object model) {

		AuditLog log = new AuditLog();
		log.setUser(getCurrentUser());
		log.setDeleted_at(new Date());
		log.setTablename(model.getClass().getName());
		String data = getJson(model);
		log.setData(data);
		String record_id = getrecordid(data);
		if (record_id != null) {
			log4j.info("Saving the audit record:" + record_id);
			log.setRecordid(record_id);
		}

		Optional<MenuItem> menuitem = menurepo.findByEntityname(model.getClass().getName());
		if (menuitem.isPresent()) {
			log.setMenu(menuitem.get());
		}

		auditrepo.save(log);
	}

	@SuppressWarnings("unused")
	private String checkIfSerializable(Object object) {
		String menuname = "";
		if (Objects.isNull(object)) {
			// throw new GenericException("The object to serialize is null");
			log4j.info("The object to serialize is null");
		}
		@SuppressWarnings("null")
        Class<?> clazz = object.getClass();
		if (!clazz.isAnnotationPresent(Menu.class)) {
			log4j.info("The class " + clazz.getSimpleName() + " is not annotated with JsonSerializable");
		} else {
			Annotation a = clazz.getAnnotation(Menu.class);
			Menu annotation = (Menu) a;
			System.out.println(annotation.menuname());
		}
		return menuname;
	}

	public String getJson(Object model) {
		try {
			String jsonInString = mapper.writeValueAsString(model);
			return jsonInString;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getrecordid(String json) {
		if (StringUtils.isNotBlank(json)) {
			JSONObject obj = new JSONObject(json);
			if (obj.get("id") != null)
				return obj.get("id").toString();
		}
		return null;
	}

	@Transactional
	public User getCurrentUser() {
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				String user_name = ((UserDetails) principal).getUsername();
				log4j.info("Username:" + user_name);
				Optional<User> user = userrepo.findByUserName(user_name);
				if (user.isPresent()) {
					return user.get();
				}
			} else {
				String user_name = principal.toString();
				// log4j.info("Username obj:" + user_name);
				Optional<User> user = userrepo.findByUserName(user_name);
				if (user.isPresent()) {
					return user.get();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}

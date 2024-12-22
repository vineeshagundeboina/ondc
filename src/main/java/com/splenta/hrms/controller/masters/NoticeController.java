package com.splenta.hrms.controller.masters;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.models.masters.Domain;
import com.splenta.hrms.models.masters.Notice;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/notice")
@Tag(name = "Notice", description = "APIs for Notice related operations")
public class NoticeController extends GenericController<Notice> {

	public NoticeController(GenericRepository<Notice> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}

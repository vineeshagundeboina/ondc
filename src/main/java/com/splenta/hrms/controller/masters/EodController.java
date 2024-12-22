package com.splenta.hrms.controller.masters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.service.masters.EodService;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/eod")
@Tag(name = "Eod Report", description = "APIs for EOD Report related operations")
public class EodController extends GenericController<Eod> {

	public EodController(GenericRepository<Eod> repository) {
		super(repository);
	}

	@Autowired
	private EodService eodService;

	@Autowired
	private EodRepo eodRepo;
	

	Map<String, Object> data = new HashMap<>();

	@PostMapping("/sendPdfEmail")
	public ResponseEntity<String> sendPdfEmail() {
		eodService.sendMail();
		return ResponseEntity.ok("Email sent with PDF attachment.");
	}
}

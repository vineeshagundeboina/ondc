package com.splenta.hrms.controller.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.models.masters.DocCollection;
import com.splenta.hrms.service.masters.EodService;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/hiring")
@Tag(name = "Hiring ", description = "APIs for Hiring related operations")

public class HiringController extends GenericController<DocCollection>{

	public HiringController(GenericRepository<DocCollection> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private EodService eodService;
	@PostMapping("/senddoccollectionrequest")
	public ResponseEntity<?> sendDocCollection(@RequestBody DocCollection docCollection){
		
		
		System.out.println(docCollection);
		eodService.docCollectionNotify(docCollection);
		return ResponseEntity.ok().body("candidate notified successfully");
		
	}

}

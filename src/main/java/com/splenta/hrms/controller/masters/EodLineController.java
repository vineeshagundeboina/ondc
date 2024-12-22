package com.splenta.hrms.controller.masters;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/eodline")
@Tag(name = "EodLine Report", description = "APIs for EOD Line Report related operations")
public class EodLineController extends GenericController<EodLine> {

	public EodLineController(GenericRepository<EodLine> repository) {
		super(repository);

	}

	@Autowired
	private EodRepo eodRepo;

	@Autowired
	private EodLineRepo eodLineRepo;

	@GetMapping("/getLinesByEodId/{eodId}")
	public ResponseEntity<?> getJournalLinesByLedgerId(@PathVariable("eodId") UUID eodId) {

		return ResponseEntity.ok().body(eodLineRepo.findByEodId(eodId));
	}

}

package com.splenta.hrms.controller.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.models.masters.Timesheet;
import com.splenta.hrms.repos.masters.TimesheetRepo;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/timesheet")
@Tag(name = "Timesheet", description = "APIs for Timesheet related operations")
public class TimesheetController extends GenericController<Timesheet> {

	public TimesheetController(GenericRepository<Timesheet> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private TimesheetRepo timesheetRepo;

	@GetMapping("/get/{userName}")
	private ResponseEntity<?> getTimesheetEntires(@PathVariable String userName){
		
		return ResponseEntity.ok().body(timesheetRepo.findByUserName(userName));
	}
}

package com.splenta.hrms.controller.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.models.masters.Leave;
import com.splenta.hrms.repos.masters.LeaveRepo;
import com.splenta.hrms.service.masters.EodService;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/leave")
@Tag(name = "Leave ", description = "APIs for Leave related operations")
public class LeaveController extends GenericController<Leave>{

	public LeaveController(GenericRepository<Leave> repository) {
		super(repository);
	}
	
	@Autowired
	private LeaveRepo leaveRepo;
	
	@Autowired
	private EodService eodService;

	
	@PostMapping("/notifymanager")
	public void notifyToReportManager(@RequestBody Leave leave){
		//eodService.sendNotifyMail("Manager",leave);
		eodService.leaveUpdateToManager("Manager",leave);
	}

	@PostMapping("/notifyemployee")
	public void notifyToReportEmployee(@RequestBody Leave leave){
		eodService.sendNotifyMail("Employee",leave);
	}
}

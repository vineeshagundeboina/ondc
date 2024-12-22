package com.splenta.hrms.controller.masters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.exception.GenericException;
import com.splenta.hrms.models.masters.Employee;
import com.splenta.hrms.repos.masters.EmployeeRepo;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/employee")
@Tag(name = "Employee", description = "APIs for Employee related operations")
public class EmployeeController extends GenericController<Employee> {

	public EmployeeController(GenericRepository<Employee> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private EmployeeRepo employeeRepo;

	@Value("${employee-startId}")
	private int employee_startId;

	@GetMapping("/getmaxid")
	private ResponseEntity<?> getMaxEmployeeId() {

		Optional<Employee> employee = employeeRepo.findFirstByOrderByCreatedAtDesc();
		if (employee.isPresent()) {
			String empId = employee.get().getEmployeeId();
			System.out.println(employee.get().getEmployeeId());
			if (empId.length() > 4) {
				empId = empId.substring(empId.length() - 3);
				return ResponseEntity.ok().body(empId);
			} else {
				throw new GenericException("Invalid Format EmployeeId Series is there in Database");
			}

		} else {
			return ResponseEntity.ok().body(employee_startId);
		}
	}

	@GetMapping("/getbyId/{employeeId}")
	private ResponseEntity<?> getEmployeeId(@PathVariable String employeeId) {

		Optional<Employee> employee = employeeRepo.findByEmployeeId(employeeId);
		if (employee.isPresent()) {

			return ResponseEntity.ok().body(employee.get());

		} else {
			throw new GenericException("No Employee Record Found");

		}
	}
}

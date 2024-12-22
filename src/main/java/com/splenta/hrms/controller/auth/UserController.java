package com.splenta.hrms.controller.auth;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.splenta.hrms.exception.GenericException;
import com.splenta.hrms.exception.UnProcessableException;
import com.splenta.hrms.models.auth.User;
import com.splenta.hrms.pojo.response.MessageResponse;
import com.splenta.hrms.repos.auth.UserRepo;
import com.splenta.hrms.utilites.CopyPropertiesUtil;
import com.turkraft.springfilter.boot.FilterSpecification;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
@Tag(name = "User", description = "APIs for User related operations")
public class UserController {
	@Autowired
	UserRepo userRepo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;


	@GetMapping("/all")
	@Operation(summary = "Get all Users")
	public ResponseEntity<Page<User>> getAll(@RequestParam(defaultValue = "0", value = "pageNo") int pageNo,
			@RequestParam(defaultValue = "25", value = "pageSize") int pageSize,
			@RequestParam(required = false, value = "filter") String filter,
			@RequestParam(defaultValue = "", required = false, value = "sortField") String sortField,
			@RequestParam(defaultValue = "ASC", required = false, value = "sortDir") String sortDir) {
		Specification<User> spec = null;

		if (sortField.equals("")) {
			sortField = "createdAt";
		}

		Sort sortSt = sortDir.equals("DESC") ? Sort.by(sortField).descending() : Sort.by(sortField).ascending();

		if (filter != null) {
			spec = new FilterSpecification<User>(filter);
			return ResponseEntity.ok(userRepo.findAll(spec, PageRequest.of(pageNo, pageSize, sortSt)));
		}

		Page<User> users = userRepo.findAll(spec, PageRequest.of(pageNo, pageSize, sortSt));
		return ResponseEntity.ok(users);
	}

	@GetMapping("/count")
	@Operation(summary = "Get count of all users")
	public ResponseEntity<Integer> getCount() {
		return ResponseEntity.ok(userRepo.findAll().size());
	}

	@PostMapping("/create")
	@Operation(summary = "Create a new user")
	public ResponseEntity<User> create(@RequestBody User user) {

		Optional<User> existingUser = userRepo.findByMobileNumberOrEmail(user.getMobileNumber(), user.getEmail());
		if (existingUser.isPresent()) {
			throw new UnProcessableException("User is already existed please login");
		} else {
			String pwd = user.getPassword();
			pwd = bCryptPasswordEncoder.encode(pwd);
			user.setIsActive(false);
			user.setPassword(pwd);
			System.out.println("user.getRoles().toString()): " + user.getRoles().toString());
			return ResponseEntity.ok(userRepo.save(user));
		}
	}

	@GetMapping("/get/{userId}")
	@Operation(summary = "Get one user")
	public ResponseEntity<?> getSingle(@PathVariable("userId") UUID userId) {
		Optional<User> user = userRepo.findById(userId);
		if (!user.isPresent()) {

			return ResponseEntity.ok(new MessageResponse("No data found"));

		}

		return ResponseEntity.ok(user.get());
	}

	@PutMapping("/update/{userId}")
	@Operation(summary = "Update a user by Id")
	public ResponseEntity<User> update(@PathVariable("userId") UUID userId, @RequestBody User user) {
		User olduser = userRepo.findById(userId).get();
		String pwd = user.getPassword();
		if (pwd != null && !pwd.equals("")) {
			pwd = bCryptPasswordEncoder.encode(pwd);
			user.setPassword(pwd);
		}
		CopyPropertiesUtil.copyProperties(user, olduser);
		return ResponseEntity.ok(userRepo.save(olduser));
	}

	@DeleteMapping("/delete/{userId}")
	@Operation(summary = "Delete a user by Id")
	public ResponseEntity<?> delete(@PathVariable("userId") UUID userId) {
		User user = userRepo.findById(userId).get();
		if (!user.isDeleteAllowed()) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Sorry you cannot delete admin user");
		} else {

//			User cusrrentUser = dashBoardService.getCurrentUser();
//			if (!user.getId().equals(cusrrentUser.getId())) {
//
//				userRepo.deleteById(userId);
//			} else {
//				throw new GenericException("Sorry you are not permitted to delete!!!!");
//			}

			return ResponseEntity.ok().build();
		}

	}
}
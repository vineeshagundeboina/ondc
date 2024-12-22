package com.twg.dairy.mydairy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.twg.dairy.mydairy.entity.EntriesEntity;
import com.twg.dairy.mydairy.entity.UsersEntity;
import com.twg.dairy.mydairy.repository.EntriesRepository;
import com.twg.dairy.mydairy.repository.UsersRepository;
import com.twg.dairy.mydairy.service.UsersServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private UsersServiceImpl usersServiceImpl;

	@Autowired
	private EntriesRepository entriesRepository;

	@GetMapping("/")
	public String index() {
		return "hello";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("user", new UsersEntity());
		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new UsersEntity());
		return "register";
	}

	@PostMapping("/register")

	public String registerUser(@ModelAttribute("usersEntity") UsersEntity usersEntity) {

		usersServiceImpl.saveUser(usersEntity);

		// return "registersuccessfully";
		return "redirect:/login";
	}

	@PostMapping("/dashboard")

	public String loginUser(@ModelAttribute UsersEntity usersEntity, Model model) {
		UsersEntity existingUser = usersServiceImpl.findByUsername(usersEntity.getUserName());
		if ((existingUser != null) && (usersEntity.getPassword().equals(existingUser.getPassword()))) {

			System.out.println("username : " + usersEntity.getUserName() + "            " + "password : "
					+ usersEntity.getPassword());
			List<EntriesEntity> entries = null;
			entries = entriesRepository.findByUsersEntityId(existingUser.getId());
			long userId = existingUser.getId();
			model.addAttribute("entries", entries);
			model.addAttribute("userId", userId);
			System.out.println("entries>> " + entries.size());
			return "entrieslist";
			// return "welcome";
		}
		model.addAttribute("error", "invalid username or password");
		return "login";

	}

	@PostMapping("/addEntry")
	public String addEntry(@ModelAttribute UsersEntity usersEntity, @RequestParam Long userId,
			@RequestParam String entryDate, @RequestParam String description, Model model) {
		UsersEntity usersEntity1 = new UsersEntity();
		usersEntity1.setId(userId);

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

		Date parsedDate = null;

		try {
			parsedDate = dateformat.parse(entryDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EntriesEntity entriesEntity = new EntriesEntity();
		entriesEntity.setUsersEntityId(userId);
		entriesEntity.setEntryDate(parsedDate);
		entriesEntity.setDescription(description);
		entriesRepository.save(entriesEntity);
//		
//		UsersEntity existingUser=usersServiceImpl.findByUsername(usersEntity.getUserName());
//
//		List<EntriesEntity> entries=null;
//		entries=entriesRepository.findByUsersEntityId(existingUser.getId());
//		//long userId=existingUser.getId();
//		model.addAttribute("entries",entries);
//		model.addAttribute("userId",userId);
//		

//		return "entrieslist";
		return "entrysuccess";
	}

//	@PostMapping("/oreder")
//	public ResponseEntity<?> oreder(@RequestBody UsersEntity usersEntity){
//		return ResponseEntity.ok("success");
//	}

}

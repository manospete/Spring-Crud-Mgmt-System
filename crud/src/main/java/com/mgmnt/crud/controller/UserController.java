package com.mgmnt.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mgmnt.crud.entity.User;
import com.mgmnt.crud.service.DepartmentService;
import com.mgmnt.crud.service.UserService;

@Controller
public class UserController {
	private  UserService  userService;
	private  DepartmentService  departmentService;

	public UserController(UserService userService, DepartmentService departmentService) {
		super();
		this.userService = userService;
		this.departmentService = departmentService;
	}

	@RequestMapping("/users")
	public String findAllUsers(Model model) {
		
		model.addAttribute("users", userService.findAllUsers());
		return "list-users";
	}

	@RequestMapping("/user/{id}")
	public String findUserById(@PathVariable("id") Long id, Model model) throws Exception {

		model.addAttribute("user", userService.findUserById(id));
		return "list-user";
	}

	@GetMapping("/addUser")
	public String showCreateForm(User user, Model model) {
		model.addAttribute("departments", departmentService.findAllDepartments());
		return "add-user";
	}

	@RequestMapping("/add-user")
	public String createUser(User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}

		userService.saveUser(user);
		return "redirect:/users";
	}

	@GetMapping("/updateUser/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) throws Exception {

		model.addAttribute("user", userService.findUserById(id));
		return "update-user";
	}

	@RequestMapping("/update-user/{id}")
	public String updateUser(@PathVariable("id") Long id, User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		userService.saveUser(user);
		return "redirect:/users";
	}

	@RequestMapping("/remove-user/{id}")
	public String deleteUser(@PathVariable("id") Long id, Model model) throws Exception {
		userService.deleteUser(id);

		return "redirect:/users";
	}
}

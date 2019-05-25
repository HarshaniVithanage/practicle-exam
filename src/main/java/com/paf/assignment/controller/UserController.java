package com.paf.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.paf.assignment.dao.UserRepo;
import com.paf.assignment.model.User;

@RestController
public class UserController {

	@Autowired
	UserRepo repo;
	
	@RequestMapping("/users")
	public ModelAndView getUsers() {
		
		ModelAndView mv = new ModelAndView("adminHome.jsp");
		
		List<User> userList = repo.findAll();
	
		System.out.println(userList);
		
		mv.addObject(userList);
		
		return mv;
	}
	
	@RequestMapping("/getUser")
	public ModelAndView getUser(@RequestParam int id ) {
		ModelAndView mv = new ModelAndView("showUser.jsp");
	
		User user = repo.findById(id).orElse(new User() );
	
		mv.addObject(user);
		
		return mv;
	}
	
	@RequestMapping("/newUser")
	public ModelAndView newUserForm() {
		ModelAndView mv = new ModelAndView("newUser.jsp");
		
		String message = "";
		mv.addObject(message);
		return mv;
	}
	
	@PostMapping("/addUser")
	public ModelAndView addUser(User user ) {
		
		ModelAndView mv = new ModelAndView("newUser.jsp");
				
		repo.save(user);
			
		mv.addObject("message", "User successfully added !");
		return mv;
	}
	
	@RequestMapping("/updateUser")
	public ModelAndView updateUser( User user) {
		
		ModelAndView mv = new ModelAndView("showUser.jsp");
		
		repo.save(user);
		
		mv.addObject("message", "User Updated Successfully !");
		return mv;
	}
	
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		
		ModelAndView mv = new ModelAndView("showUser.jsp");
		
		User user = repo.findById(id).orElse(new User());
		
		repo.delete(user);
		
		mv.addObject("message", "User Deleted Successfully !");
		return mv;
	}

}

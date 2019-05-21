package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Student_pojo;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/user")
public class StudentController {
	
	
	@Autowired
	public IStudentService service;
	
	
	
	public StudentController() {
		System.out.println("user controller");
	}
	
	
	@PostMapping("/login")
	public String validateUser(@RequestBody Student_pojo s) {
		
		if(service.validateStudent(s.getUsername())!=null)
			return "present";
		return "not present";
	}
	

}

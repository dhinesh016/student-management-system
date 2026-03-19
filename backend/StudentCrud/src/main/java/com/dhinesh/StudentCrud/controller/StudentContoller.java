package com.dhinesh.StudentCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhinesh.StudentCrud.Entity.Student;
import com.dhinesh.StudentCrud.service.StudentService;

import jakarta.annotation.PostConstruct;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentContoller {
	 
	@Autowired
	StudentService student;
	
	@GetMapping
	public List<Student> getStudents() {
		
		return student.getStudents();
	}
	
	@PostMapping
	public String addStudent(@RequestBody Student s){
		return student.addStudent(s);
		
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id) {
		return student.getStudent(id);
	}
	 
	@PutMapping("/{id}")
	public String updateStudent(@PathVariable Long id,@RequestBody Student s) {
		return student.updateStudent(id,s);
	}
   
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return student.deleteStudent(id);
	}
	
}

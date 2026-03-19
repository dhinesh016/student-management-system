package com.dhinesh.StudentCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhinesh.StudentCrud.Entity.Student;
import com.dhinesh.StudentCrud.reposity.StudentRepositry;

@Service
public class StudentService {

	@Autowired
	StudentRepositry repo;
	
	public List<Student> getStudents() {
		return repo.findAll();
	}

	public String addStudent(Student s) {
		repo.save(s);
		return "Student added success fully";
	}
    
	
	public String updateStudent(Long id, Student s) {
		Student stud=repo.findById(id).orElseThrow();
		
		stud.setName(s.getName());
		stud.setDept(s.getDept());
		stud.setEmail(s.getEmail());
		stud.setDob(s.getDob());
		repo.save(stud);
		return "Updated sucessfully";
	}

	public Student getStudent(Long id) {
		return repo.findById(id).orElseThrow();
	}

	public String deleteStudent(Long id) {
		repo.deleteById(id);
		return "deleted Sucesfully";
	}

}

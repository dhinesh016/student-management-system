package com.dhinesh.StudentCrud.reposity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhinesh.StudentCrud.Entity.Student;

public interface StudentRepositry extends JpaRepository<Student, Long> {

}

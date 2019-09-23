package com.tarento.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarento.Student.model.Student;
import com.tarento.Student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	private StudentService studService;
	@Autowired
	public StudentController(StudentService studService) {
		this.studService = studService;
	}
	
	@GetMapping("/students")
	public List<Student> read(){
		return studService.read();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		Student stud = studService.findStudentById(studentId);
		if(stud==null) {
			throw new RuntimeException("Employee id not found"+studentId);
		}
		return stud;
	}
	
	@PostMapping("/add")
	public String addStudent(@RequestBody Student stud) {
		studService.create(stud);
		return "New employee added";
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		Student studt = studService.findStudentById(studentId);
		if(studt==null)
		{
			throw new RuntimeException("Employee id not found"+studentId);
		}
		studService.delete(studentId);
		return "Deleted employee id - "+studentId;
	}
//	@PutMapping("/students") 
}

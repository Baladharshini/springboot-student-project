package com.tarento.Student.service;

import java.util.List;

import com.tarento.Student.model.Student;

public interface StudentService {
	public int create(Student stud);
	public List<Student> read();
	public Student findStudentById(int studentId);
	public int update(Student stud);
	public int delete(int studentId);
}

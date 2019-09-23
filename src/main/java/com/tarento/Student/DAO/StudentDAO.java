package com.tarento.Student.DAO;

import java.util.List;

import com.tarento.Student.model.Student;

public interface StudentDAO {
	public int create(Student stud);
	public List<Student> read();
	public Student findStudentById(int studentId);
	public int update(Student stud);
	public int delete(int studentId);
}

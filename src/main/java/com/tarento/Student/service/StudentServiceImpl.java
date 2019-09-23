package com.tarento.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tarento.Student.DAO.StudentDAO;
import com.tarento.Student.model.Student;
@Component
public class StudentServiceImpl implements StudentService {
	
	private StudentDAO studDao;
	@Autowired
	public StudentServiceImpl(StudentDAO studDao) {
		this.studDao = studDao;
	}

	@Override
	@Transactional
	public int create(Student stud) {
		return studDao.create(stud);
	}

	@Override
	@Transactional
	public List<Student> read() {
		return studDao.read();
	}

	@Override
	@Transactional
	public Student findStudentById(int studentId) {
		return studDao.findStudentById(studentId);
	}

	@Override
	@Transactional
	public int update(Student stud) {
		return studDao.update(stud);
	}

	@Override
	@Transactional
	public int delete(int studentId) {
		return studDao.delete(studentId);
	}

}

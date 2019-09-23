package com.tarento.Student.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.tarento.Student.model.Student;

@Component
public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;

	public StudentDAOImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public int create(Student stud) {
		String sql = "insert into student(stu_name,stu_dept,stu_college)values(?,?,?)";
		try {
			int counter = jdbcTemplate.update(sql,
					new Object[] { stud.getName(), stud.getDept(), stud.getCollege() });
			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Student> read() {
		List<Student> studentList = jdbcTemplate.query("select * from student", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stud = new Student();
				stud.setName(rs.getString("stu_name"));
				stud.setId(rs.getInt("stu_id"));
				stud.setDept(rs.getString("stu_dept"));
				stud.setCollege(rs.getString("stu_college"));
				return stud;
			}

		});
		return studentList;
	}

	@Override
	public int update(Student stud) {
		String sql = "update  student1 set stu_name=?, stu_dept=?, stu_college=? where stu_id=?";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { stud.getName(), stud.getId(), stud.getDept(), stud.getCollege() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int studentId) {
		String sql = "delete from student1 where stu_id=?";

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { studentId });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Student findStudentById(int studentId) {

		return jdbcTemplate.queryForObject("select * from student where stu_id=?", new Object[] { studentId },
				new RowMapper<Student>() {

					@Override
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student student = new Student();

						student.setName(rs.getString("stu_name"));
						student.setId(rs.getInt("stu_id"));
						student.setDept(rs.getString("stu_dept"));
						student.setCollege(rs.getString("stu_college"));

						return student;
					}

				});
	}
}

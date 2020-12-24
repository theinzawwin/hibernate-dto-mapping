package com.best.hibernate.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.best.hibernate.exam.dao.StudentDao;
import com.best.hibernate.exam.model.Student;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	public List<Student> getStudentListByGrade(Long gradeId){
		return studentDao.getStudentListByGrade(gradeId);
	}
}

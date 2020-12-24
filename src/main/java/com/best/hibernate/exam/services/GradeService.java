package com.best.hibernate.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.best.hibernate.exam.dao.GradeDao;
import com.best.hibernate.exam.model.Grade;

@Service
@Transactional
public class GradeService {

	@Autowired
	private GradeDao gradeDao;
	public void save(Grade grade) {
		gradeDao.save(grade);
	}
	public List<Grade> getGradeList(){
		return gradeDao.getGradeList();
	}
}

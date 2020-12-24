package com.best.hibernate.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.best.hibernate.exam.model.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSesssion(){
		return sessionFactory.getCurrentSession();
	}
	
	public List<Student> getStudentListByGrade(Long gradeId){
		
		Criteria cr=getCurrentSesssion().createCriteria(Student.class);
		cr.createAlias("grade", "g",JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("g.id",gradeId));
		return cr.list();
	}
	
}

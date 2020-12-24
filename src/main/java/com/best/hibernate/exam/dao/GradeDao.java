package com.best.hibernate.exam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.best.hibernate.exam.model.Grade;

@Repository
public class GradeDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSesssion(){
		return sessionFactory.getCurrentSession();
	}
	public void save(Grade grade) {
		getCurrentSesssion().save(grade);
	}
	public List<Grade> getGradeList(){
		Query query=getCurrentSesssion().createQuery("from Grade");
		return query.list();
	}
	
}

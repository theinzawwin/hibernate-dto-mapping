package com.best.hibernate.exam.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.best.hibernate.exam.model.Attendance;

@Repository
public class AttendanceDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSesssion(){
		return sessionFactory.getCurrentSession();
	}
	public void saveAttendanceList(Attendance att) {
		getCurrentSesssion().save(att);
	}
}

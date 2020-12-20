package com.best.hibernate.exam.dao;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.best.hibernate.exam.dto.TeacherDTO;
import com.best.hibernate.exam.model.Department;
import com.best.hibernate.exam.model.Teacher;

@Repository
public class TeacherDao {

	@Autowired
	private SessionFactory sessionFactory;
	public Session getCurrentSesssion(){
		return sessionFactory.getCurrentSession();
	}
	public void save(Teacher teacher) {
		getCurrentSesssion().save(teacher);
	}
	public TeacherDTO findById(Long id) {
		Criteria cr=getCurrentSesssion().createCriteria(Teacher.class);
		cr.add(Restrictions.eq("id",id));
		cr.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"),"name")
				.add(Projections.property("nrc"),"nrc")
				.add(Projections.property("email"),"email")
				.add(Projections.property("deparment.id"),"departmentId")
				.add(Projections.property("deparment.name"),"departmentName")
				);
		cr.setResultTransformer(Transformers.aliasToBean(TeacherDTO.class));
		return (TeacherDTO)cr.uniqueResult();
	}
	public List<TeacherDTO> findAll(){
		Criteria cr=getCurrentSesssion().createCriteria(Teacher.class);
		cr.createAlias("department", "d", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		//cr.add(Restrictions.eq("id",id));
		cr.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"),"name")
				.add(Projections.property("nrc"),"nrc")
				.add(Projections.property("email"),"email")
				.add(Projections.property("educationDesc"),"educationDesc")
				.add(Projections.property("d.id"),"departmentId")
				.add(Projections.property("d.name"),"departmentName")
				);
		cr.setResultTransformer(Transformers.aliasToBean(TeacherDTO.class));
		return (List<TeacherDTO> )cr.list();
	}
	public void  delete(Long id) {
		Teacher t=getCurrentSesssion().load(Teacher.class, id);
		if(t!=null) {
			getCurrentSesssion().delete(t);
		}
	}
}

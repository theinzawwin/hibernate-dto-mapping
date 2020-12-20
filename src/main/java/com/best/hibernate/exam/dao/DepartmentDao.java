package com.best.hibernate.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.best.hibernate.exam.dto.DepartmentDTO;
import com.best.hibernate.exam.model.Department;

@Repository
public class DepartmentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSesssion(){
		return sessionFactory.getCurrentSession();
	}
	public void save(Department department) {
		getSesssion().saveOrUpdate(department);
	}
	public DepartmentDTO findById(Long id) {
		Criteria cr=getSesssion().createCriteria(Department.class);
		cr.add(Restrictions.eq("id",id));
		cr.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name")
				);
		cr.setResultTransformer(Transformers.aliasToBean(DepartmentDTO.class));
		return (DepartmentDTO)cr.uniqueResult();
	}
	public List<DepartmentDTO> findAll() {
		Criteria cr=getSesssion().createCriteria(Department.class);
		//cr.add(Restrictions.eq("id",id));
		cr.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name")
				);
		cr.setResultTransformer(Transformers.aliasToBean(DepartmentDTO.class));
		return (List<DepartmentDTO>)cr.list();
	}
	public void delete(Long id) {
		Department dept=getSesssion().load(Department.class, id);
		if(dept!=null) {
			getSesssion().delete(dept);
		}
	}
}

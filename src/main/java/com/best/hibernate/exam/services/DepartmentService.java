package com.best.hibernate.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.best.hibernate.exam.dao.DepartmentDao;
import com.best.hibernate.exam.dto.DepartmentDTO;
import com.best.hibernate.exam.model.Department;

@Service
@Transactional
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	public DepartmentDTO findById(Long id) {
		return departmentDao.findById(id);
	}
	public void save(DepartmentDTO dto) {
		Department department=new Department();//=new Department(0L,dto.getName(), true);
		if(dto!=null && dto.getId()!=null) {
			department.setId(dto.getId());
		}
		department.setName(dto.getName());
		department.setStatus(true);
		departmentDao.save(department);
	}
	
	public List<DepartmentDTO> getDepartmentList(){
		return departmentDao.findAll();
	}
	public void delete(Long id) {
		departmentDao.delete(id);
	}
}

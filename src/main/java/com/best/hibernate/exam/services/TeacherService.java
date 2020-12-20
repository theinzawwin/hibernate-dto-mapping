package com.best.hibernate.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.best.hibernate.exam.dao.TeacherDao;
import com.best.hibernate.exam.dto.TeacherDTO;
import com.best.hibernate.exam.model.Teacher;

@Service
@Transactional
public class TeacherService {
	
	@Autowired
	private TeacherDao teacherDao;
	
	public void save(TeacherDTO teacherDTO) {
		Teacher teacher= new Teacher();
		if(teacherDTO.getId()!=null) {
			teacher.setId(teacherDTO.getId());
		}
		teacher.setName(teacherDTO.getName());
		teacher.setNrc(teacherDTO.getNrc());
		teacher.setEmail(teacherDTO.getEmail());
		teacher.setEducationDesc(teacherDTO.getEducationDesc());
		teacher.getDepartment().setId(teacherDTO.getDepartmentId());
		teacherDao.save(teacher);
	}
	
	public List<TeacherDTO> getTeacherList(){
		return teacherDao.findAll();
	}
	
	public TeacherDTO findById(Long id) {
		return teacherDao.findById(id);
	}
	public void delete(Long id) {
		teacherDao.delete(id);
	}

}

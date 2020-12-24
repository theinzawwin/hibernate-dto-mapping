package com.best.hibernate.exam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.best.hibernate.exam.dao.AttendanceDao;
import com.best.hibernate.exam.dto.AttendanceListDTO;
import com.best.hibernate.exam.model.Attendance;

@Service
@Transactional
public class AttendanceService {

	@Autowired
	private AttendanceDao attendanceDao;
	public void saveAttendance(AttendanceListDTO attListDTO) {
		attListDTO.getAttList().stream().forEach(a->{
			Attendance att=new Attendance();
			att.getStudent().setId(a.getStudentId());
			att.setStatus(a.getStatus());
			att.setDate(attListDTO.getDate());
			attendanceDao.saveAttendanceList(att);
		});
	}
}

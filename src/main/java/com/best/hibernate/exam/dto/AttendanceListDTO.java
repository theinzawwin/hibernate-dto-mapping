package com.best.hibernate.exam.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceListDTO implements Serializable{

	private Date date;
	private List<AttendanceStudentDTO> attList=new ArrayList<AttendanceStudentDTO>();
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<AttendanceStudentDTO> getAttList() {
		return attList;
	}
	public void setAttList(List<AttendanceStudentDTO> attList) {
		this.attList = attList;
	}
	
}

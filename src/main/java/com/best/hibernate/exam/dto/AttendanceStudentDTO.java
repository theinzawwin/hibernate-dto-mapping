package com.best.hibernate.exam.dto;

import java.io.Serializable;

public class AttendanceStudentDTO implements Serializable{

	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	private Long studentId;
	private Boolean status;
}

package com.best.hibernate.exam.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.best.hibernate.exam.dto.AttendanceListDTO;
import com.best.hibernate.exam.model.Student;
import com.best.hibernate.exam.services.AttendanceService;
import com.best.hibernate.exam.services.GradeService;
import com.best.hibernate.exam.services.StudentService;

@Controller
public class AttendanceController {

	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private AttendanceService attendanceService;
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
	@RequestMapping(value="att_list.htm")
	public String index(@RequestParam(value="gradeId",required = false)Long gradeId,Model model) {
		model.addAttribute("gradeList", gradeService.getGradeList());
		List<Student> studentList=new ArrayList<Student>();
		if(gradeId!=null&&gradeId!=0L) {
			studentList=studentService.getStudentListByGrade(gradeId);
		}
		model.addAttribute("studentList", studentList);
		model.addAttribute("attendanceListDTO", new AttendanceListDTO());
		
		return "attendance_list";
	}
	@RequestMapping(value="save_attendance.htm",method = RequestMethod.POST)
	public String saveAttendance(@ModelAttribute(value="attendanceListDTO")AttendanceListDTO attListDTO) {
		attendanceService.saveAttendance(attListDTO);
		return "success_attendance";
	}
}

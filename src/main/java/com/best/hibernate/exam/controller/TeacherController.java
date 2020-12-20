package com.best.hibernate.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.best.hibernate.exam.dto.TeacherDTO;
import com.best.hibernate.exam.services.DepartmentService;
import com.best.hibernate.exam.services.TeacherService;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private DepartmentService departmentService;
	@RequestMapping(value="create_teacher.htm")
	public String crate(Model model) {
		model.addAttribute("teacherDTO", new TeacherDTO());
		model.addAttribute("departmentList", departmentService.getDepartmentList());
		return "teacher_create";
	}
	@RequestMapping(value="create_teacher.htm",method = RequestMethod.POST)
	public String post_teacher(@ModelAttribute(value="teacherDTO") TeacherDTO teacherDTO) {
		teacherService.save(teacherDTO);
		return "redirect:/teacher/list.htm";
	}
	@RequestMapping(value="list.htm")
	public String list(Model model) {
		model.addAttribute("teacherList", teacherService.getTeacherList());
		return "teacher_list";
	}
}

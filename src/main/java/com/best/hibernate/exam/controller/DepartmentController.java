package com.best.hibernate.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.best.hibernate.exam.dto.DepartmentDTO;
import com.best.hibernate.exam.services.DepartmentService;

@Controller
@RequestMapping(value="/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	@RequestMapping(value="/list.htm")
	public String index(Model model) {
		model.addAttribute("department_list", departmentService.getDepartmentList());
		return "department_list";
	}
	@RequestMapping(value="/create_department.htm")
	public String create_department(Model model) {
		model.addAttribute("departmentDTO", new DepartmentDTO());
		return "departement_create";
	}
	@RequestMapping(value="/create_department.htm",method = RequestMethod.POST)
	public String post_deparment(@ModelAttribute(value="departmentDTO")DepartmentDTO dept) {
		departmentService.save(dept);
		return "redirect:/department/list.htm";
	}
	
}

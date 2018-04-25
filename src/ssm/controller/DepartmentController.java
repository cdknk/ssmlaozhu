package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssm.entity.Department;
import ssm.service.DepartmentService;


@Controller
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/departments")
	public String list(Model model) {
		List<Department> departments = departmentService.findAll();
		model.addAttribute("departments", departments);
		return "department-list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/departments/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Department dep = departmentService.findOne(id);
		model.addAttribute("dep", dep);
		
		List<Department> depOptions = departmentService.findAll();
		model.addAttribute("depOptions", depOptions);
		return "department-edit";
	}
}

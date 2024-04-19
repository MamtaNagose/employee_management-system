package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller//it produce html format 
//@RestController /// it produce json format response

public class EmpController {

	@Autowired
	private EmpService service;

	@GetMapping("/res")
	public String home(Model m) {
		List<Employee> emp = service.getAllEmp();
		m.addAttribute("emp", emp);
		return "index";
	}
	

	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Emplyoee Added Sucessfully..");
		return "redirect:/res";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee emp = service.getEMpById(id);
		m.addAttribute("emp", emp);
		return "edit";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Emp Data Update Sucessfully..");
		return "redirect:/res";
	}

	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {

		service.deleteEMp(id);
		session.setAttribute("msg", "Emp Data Delete Sucessfully..");
		return "redirect:/res";
	}

}
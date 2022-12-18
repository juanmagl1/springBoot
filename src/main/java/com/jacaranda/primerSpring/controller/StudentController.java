package com.jacaranda.primerSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.primerSpring.Service.StudentService;
import com.jacaranda.primerSpring.model.Student;

@Controller
public class StudentController {
	@Autowired
	StudentService repositorio;

	@GetMapping("listStudent")
	public String listStudent(Model model) {
		model.addAttribute("lista", repositorio.getStudents());
		return "listStudents";
	}

	@GetMapping("addStudent")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("estudiante", student);
		return "addStudents";
	}

	@PostMapping("/addStudent/submit")
	public String addStudent(@ModelAttribute("estudiante") Student aux) {
		repositorio.add(aux);
		return "redirect:/listStudent";
	}

	@GetMapping("delStudent")
	public String delStudent(Model model, @RequestParam(name = "name") String name,
			@RequestParam(name = "apellido") String apellido) {
		Student estudiante = repositorio.get(name, apellido);
		model.addAttribute("estudiante", estudiante);
		return "deleteStudents";

	}
	
	@PostMapping("execDel")
	public String deleteStudent(@ModelAttribute("estudiante")Student estudiante) {
		repositorio.remove(estudiante);
		return "redirect:/listStudents";

	}
	
	@GetMapping("updateStudent")
	public String updateStudent(Model model, @RequestParam(name = "name") String name,
			@RequestParam(name = "apellido") String apellido) {
		Student estudiante = repositorio.get(name, apellido);
		model.addAttribute("estudiante", estudiante);
		return "updateStudents";

	}
	
	@PostMapping("execUpdate")
	public String updateStudent(@ModelAttribute("estudiante")Student estudiante) {
		repositorio.update(estudiante);
		return "redirect:/listStudents";

	}
	

}

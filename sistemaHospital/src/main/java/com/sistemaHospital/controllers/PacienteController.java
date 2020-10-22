package com.sistemaHospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemaHospital.models.Consulta;
import com.sistemaHospital.models.Paciente;
import com.sistemaHospital.repositories.ConsultaRepository;
import com.sistemaHospital.repositories.PacienteRepository;

@Controller
@RequestMapping("/admin")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pr;
	
	@Autowired
	private ConsultaRepository cr;
	
	//Metodo que direciona o secretário para página de cadastro de pacientes.
	@GetMapping("/cadastrarPaciente")
	public String form() {
		return "admin/paciente/fromPaciente";
	}
	
	//Metodo que efetua o cadastro de Pacientes
	@PostMapping("/cadastrarPaciente")
	public String salvar(Paciente paciente) {
		
		pr.save(paciente);
		return "admin/paciente/fromPaciente";
	}
	
	//Metodo que lista os pacientes e realiza busca pelo nome do paciente
	@RequestMapping("/pacientes")
	public ModelAndView listaPacientes(String filter){
		
		if (filter == null)
			filter = "";
		
		ModelAndView mv = new ModelAndView("admin/paciente/listaPaciente");
		Iterable<Paciente> pacientes = pr.findAllByNomeContaining(filter);
		mv.addObject("pacientes", pacientes);
		return mv;
	}

	//Metodo que efetua a exclusão do paciente
	@RequestMapping("/pacientes/{id}")
	public String deletarPaciente(@PathVariable("id") long idPaciente) {
		
		Paciente paciente = pr.findByIdPaciente(idPaciente);
		pr.delete(paciente);
		return "redirect:/admin/pacientes/";
		
	}
	
	@RequestMapping("/adicionaPaciente")
	public ModelAndView adicionar(String filter){
		
		if (filter == null)
			filter = "";
		
		ModelAndView mv = new ModelAndView("admin/consulta/adicionarPaciente");
		Iterable<Paciente> adicionarPacientes = pr.findAllByNomeContaining(filter);
		mv.addObject("pacientes", adicionarPacientes);
		return mv;
	}
	
	@RequestMapping("/adicionaPaciente/{id}")
	public ModelAndView adicionarPaciente(@PathVariable("id") long idPaciente) {
		
		Paciente addPaciente = pr.findById(idPaciente).get();
		Iterable<Consulta> consulta = cr.findByPaciente(addPaciente);
		ModelAndView mv = new ModelAndView("admin/consulta/fromConsulta");
		mv.addObject("addPaciente", addPaciente);
		mv.addObject("consulta", consulta);

		return mv;
		
	}
}

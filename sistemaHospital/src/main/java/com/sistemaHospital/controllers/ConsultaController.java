package com.sistemaHospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sistemaHospital.models.Consulta;
import com.sistemaHospital.models.Paciente;
import com.sistemaHospital.repositories.ConsultaRepository;
import com.sistemaHospital.repositories.PacienteRepository;

@Controller
@RequestMapping("/admin")
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository cr;
	
	@Autowired
	private PacienteRepository pr;
	
	@RequestMapping("/deletarConsultas")
	public String deletarConsulta(long idConsulta) {
		Consulta consulta = cr.findByIdConsulta(idConsulta);
		cr.delete(consulta);
		return "redirect:/consultas";
	}
	
	
	@RequestMapping(value="/cadastrarConsulta/{id}", method=RequestMethod.POST)
	public String formPOST(@PathVariable("id") long idPaciente, Consulta consulta) {
		Paciente paciente = pr.findByIdPaciente(idPaciente);
		consulta.setPaciente(paciente);
		consulta.getSintomas();
		consulta.getEspecialista();
		consulta.getDtConsulta();
		consulta.getHorario();
		cr.save(consulta);
		
		return "redirect:/admin/adicionaPaciente/";
		
	}
	
}

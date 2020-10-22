package com.sistemaHospital.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemaHospital.models.Consulta;
import com.sistemaHospital.models.Paciente;
import com.sistemaHospital.models.Role;
import com.sistemaHospital.models.Usuario;
import com.sistemaHospital.repositories.ConsultaRepository;
import com.sistemaHospital.repositories.PacienteRepository;
import com.sistemaHospital.repositories.RoleRepository;
import com.sistemaHospital.repositories.UsuarioRepository;

@Controller
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	private UsuarioRepository ur;
	@Autowired
	private RoleRepository rr;
	
	@Autowired
	private ConsultaRepository cr;
	
	@Autowired
	private PacienteRepository pr;
	
	
	@RequestMapping("/listarConsulta")
	public ModelAndView listaConsulta(){
		
		ModelAndView mv = new ModelAndView("usuarios/listarConsulta");
		Iterable<Consulta> consultas = cr.findAll();
		Iterable<Paciente> pacientes = pr.findAll();
		mv.addObject("consultas", consultas);
		mv.addObject("pacientes", pacientes);
		
		return mv;
	}
	
	
	//Metodo que efetua a exclusão do paciente
	@RequestMapping("/listarConsulta/{id}")
	public String deletarPaciente(@PathVariable("id") long idConsulta) {
			
		Consulta consultas = cr.findByIdConsulta(idConsulta);
		cr.delete(consultas);
		return "redirect:/user/listarConsulta/";
			
	}
	
	@PostMapping("/cadastro")
	public String salvar(Usuario usuario) {
		
		ArrayList<Role> roles = new ArrayList<Role>();
		Role role = rr.findByNome("ROLE_USUARIO"); 
		roles.add(role);

		usuario.setRoles(roles);

		/* Criptografando senha */
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));

		ur.save(usuario);

		return "redirect:/login";
	}

}


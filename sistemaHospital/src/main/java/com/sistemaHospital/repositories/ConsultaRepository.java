package com.sistemaHospital.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistemaHospital.models.Consulta;
import com.sistemaHospital.models.Paciente;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Long> {
	
	Iterable<Consulta> findByPaciente(Paciente paciente);
	Consulta findByIdConsulta (long idConsulta);
	
}

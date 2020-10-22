package com.sistemaHospital.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sistemaHospital.models.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Long>{
	
	Paciente findByIdPaciente (long idPaciente);
	
	Iterable<Paciente> findAllByNomeContaining(String nome);
	
}

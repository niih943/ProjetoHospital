package com.sistemaHospital.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistemaHospital.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Usuario findByLogin(String login);
	
	Iterable<Usuario> findAllByNomeContaining(String nome);
	
}

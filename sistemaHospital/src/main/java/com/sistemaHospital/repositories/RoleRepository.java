package com.sistemaHospital.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistemaHospital.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByNome(String nome);
	
	Iterable<Role> findAllByOrderByNomeAsc();

}

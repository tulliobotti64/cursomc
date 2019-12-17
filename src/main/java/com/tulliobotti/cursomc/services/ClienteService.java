package com.tulliobotti.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulliobotti.cursomc.domain.Cliente;
import com.tulliobotti.cursomc.repositories.ClienteRepository;
import com.tulliobotti.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	// implementar um servico para buscar uma categoria por codigo 
	@Autowired
	public ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
}

package com.tulliobotti.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulliobotti.cursomc.domain.Categoria;
import com.tulliobotti.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	// implementar um servico para buscar uma categoria por codigo 
	@Autowired
	public CategoriaRepository repo;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj;
	}
}

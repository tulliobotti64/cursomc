package com.tulliobotti.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulliobotti.cursomc.domain.Categoria;
import com.tulliobotti.cursomc.repositories.CategoriaRepository;
import com.tulliobotti.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	// implementar um servico para buscar uma categoria por codigo 
	@Autowired
	public CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}
}

package com.tulliobotti.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulliobotti.cursomc.domain.Pedido;
import com.tulliobotti.cursomc.repositories.PedidoRepository;
import com.tulliobotti.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	// implementar um servico para buscar uma categoria por codigo 
	@Autowired
	public PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}
}

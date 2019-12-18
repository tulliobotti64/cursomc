package com.tulliobotti.cursomc.domain;

import javax.persistence.Entity;

import com.tulliobotti.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComcartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;

	// construtores vazio e cheio
	
	public PagamentoComcartao() {
	}

	public PagamentoComcartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeparcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

// Hashcode
	
	
	

	
}

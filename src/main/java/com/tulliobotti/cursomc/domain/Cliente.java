package com.tulliobotti.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tulliobotti.cursomc.domain.enums.TipoCliente;

//implementar o mapeamento objeto relacional
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	//implementar o mapeamento objeto relacional das associacoes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo; //macete: campo trocado de TipoCliente para Integer ???
	
	@JsonManagedReference //liberar a serializacao para os enderecos 
	// associacoes: um cliente pode ter varios enderecos
	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	// Implementacao para o telefone nao tem Classe e sim um conjunto(Set) que nao aceita repeticao
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefone = new HashSet<>();
	//relacionamento 
	@OneToMany(mappedBy="cliente")
	//associacao da tabela Pedidos
	private List<Pedido> pedidos = new ArrayList<>();

	//Criar construtor vazio
	public Cliente() {
	}
	// Criar construtor para todos os campos menos para as colecoes
	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getCod();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo); //macete
	}
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod(); //macete
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public Set<String> getTelefone() {
		return telefone;
	}
	public void setTelefone(Set<String> telefone) {
		this.telefone = telefone;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	//implementar hascode somente para o id
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

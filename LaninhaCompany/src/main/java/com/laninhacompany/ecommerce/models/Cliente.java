package com.laninhacompany.ecommerce.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	@Column(name = "celular", nullable = false, length = 11)
	private String celular;
	
	@Column(name = "revendedor")
	private Boolean revendedor;
	
	@JsonManagedReference(value = "end")
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Endereco endereco;
	
	@OneToMany(targetEntity = Depoimento.class, mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Depoimento> setDepoimentos;
	
	@JsonBackReference(value = "client")
	@OneToMany(targetEntity = Pedido.class, mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Pedido> setPedidos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Boolean getRevendedor() {
		return revendedor;
	}
	public void setRevendedor(Boolean revendedor) {
		this.revendedor = revendedor;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Pedido> getSetPedidos() {
		return setPedidos;
	}
	public void setSetPedidos(Set<Pedido> setPedidos) {
		this.setPedidos = setPedidos;
	}
	
}

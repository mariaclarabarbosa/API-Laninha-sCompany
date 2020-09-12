package com.laninhacompany.ecommerce.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "data", nullable = false)
	private LocalDate data_pedido = LocalDate.now();
	
	@JsonManagedReference(value = "pag")
	@ManyToOne()
	@JoinColumn(name = "id_pagamento", referencedColumnName = "id")
	private Pagamento pagamento;
	
	@JsonManagedReference(value = "client")
	@ManyToOne()
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private Cliente cliente;
	
	@OneToMany(targetEntity = Carrinho.class, mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Carrinho> setCarrinho;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(LocalDate data_pedido) {
		this.data_pedido = data_pedido;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Carrinho> getSetCarrinho() {
		return setCarrinho;
	}

	public void setSetCarrinho(Set<Carrinho> setCarrinho) {
		this.setCarrinho = setCarrinho;
	}

	
}

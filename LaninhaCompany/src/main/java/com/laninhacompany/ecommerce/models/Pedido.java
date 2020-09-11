package com.laninhacompany.ecommerce.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "data")
	private LocalDate data_pedido = LocalDate.now();
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name = "id_pagamento", referencedColumnName = "id")
	private Pagamento pagamento;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private Cliente cliente;

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
	
}

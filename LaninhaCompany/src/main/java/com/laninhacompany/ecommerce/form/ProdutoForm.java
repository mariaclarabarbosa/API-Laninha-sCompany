package com.laninhacompany.ecommerce.form;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProdutoForm {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@NotNull
	@Size(max = 50)
	private String nome;
	
	@NotNull
	@Size(max = 100)
	private String descricao;
	
	@NotNull
	@Size(max = 50)
	private String marca;
	
	@NotNull
	private Integer estoque;
	
	@NotNull
	private Integer cod_anvisa;
	
	@NotNull
	private Double valor;

	@NotNull
	private Integer id_categoria;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Integer getCod_anvisa() {
		return cod_anvisa;
	}

	public void setCod_anvisa(Integer cod_anvisa) {
		this.cod_anvisa = cod_anvisa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	
}

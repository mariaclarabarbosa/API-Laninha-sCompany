package com.laninhacompany.ecommerce.models;

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
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	@Column(name = "marca", nullable = false, length = 50)
	private String marca;
	
	@Column(name = "estoque", nullable = false)
	private Integer estoque;
	
	@Column(name = "cod_anvisa", nullable = false)
	private Integer cod_anvisa;
	
	@Column(name = "valor", nullable = false)
	private Double valor;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "id_categoria", referencedColumnName = "id")
	private Categoria categoria;
	
	
	@OneToMany(targetEntity = Depoimento.class, mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Depoimento> setDepoimentos;
	
	
	@OneToMany(targetEntity = Carrinho.class, mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Carrinho> setCarrinhos;
	
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}

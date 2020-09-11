package com.laninhacompany.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laninhacompany.ecommerce.form.ProdutoForm;
import com.laninhacompany.ecommerce.models.Produto;
import com.laninhacompany.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@PostMapping
	public void inserirProduto(@RequestBody ProdutoForm produtoForm) {
		produtoService.inserirProduto(produtoForm);
	}
	
	@GetMapping
	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}
	
	@GetMapping("/{id}")
	public Produto listarProdutoPorId(@PathVariable Integer id) {
		return produtoService.listarProdutoPorId(id);
	}
	
	@PutMapping("/{id}")
	public void atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoForm produtoForm) {
		produtoService.atualizarProduto(id, produtoForm);
	}
	
	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable Integer id) {
		produtoService.deletarProduto(id);
	}
}

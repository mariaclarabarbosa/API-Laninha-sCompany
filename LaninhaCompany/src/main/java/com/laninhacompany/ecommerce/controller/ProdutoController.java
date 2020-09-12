package com.laninhacompany.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laninhacompany.ecommerce.exceptions.CodigoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.NullObjectException;
import com.laninhacompany.ecommerce.form.ProdutoForm;
import com.laninhacompany.ecommerce.models.Depoimento;
import com.laninhacompany.ecommerce.models.Produto;
import com.laninhacompany.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<String> inserirProduto(@RequestBody ProdutoForm produtoForm) throws NullObjectException {
		String msg = produtoService.inserirProduto(produtoForm);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos() {
		List<Produto> listaProdutos = produtoService.listarProdutos();
		return new ResponseEntity<List<Produto>>(listaProdutos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> listarProdutoPorId(@PathVariable Integer id) throws CodigoNotFoundException {
		Produto p = produtoService.listarProdutoPorId(id);
		return new ResponseEntity<Produto>(p, HttpStatus.OK);
	}
	
	@GetMapping("//{id}")
	public ResponseEntity<List<Depoimento>> listarDepoimentosDoProduto(@PathVariable Integer id) throws CodigoNotFoundException{
		List<Depoimento> listaDepoimentos = produtoService.listarDepoimentosDoProduto(id);
		return new ResponseEntity<List<Depoimento>>(listaDepoimentos, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoForm produtoForm) throws CodigoNotFoundException {
		String msg = produtoService.atualizarProduto(id, produtoForm);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarProduto(@PathVariable Integer id) throws CodigoNotFoundException {
		String msg = produtoService.deletarProduto(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}

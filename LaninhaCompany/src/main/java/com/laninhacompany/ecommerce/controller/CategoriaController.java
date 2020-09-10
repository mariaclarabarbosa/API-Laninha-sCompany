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

import com.laninhacompany.ecommerce.models.Categoria;
import com.laninhacompany.ecommerce.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	//CRUD
	
	@PostMapping
	public void criarCategoria(@RequestBody Categoria categoria) {
		categoriaService.criarCategoria(categoria);
	}
	
	@GetMapping
	public List<Categoria> listarCategorias(){
		return categoriaService.listarCategorias();
	}
	
	@GetMapping("/{id}")
	public Categoria listarCategoriaPorId(@PathVariable Integer id) {
		return categoriaService.listarCategoriaPorId(id);
	}
	
	@PutMapping("/{id}")
	public void atualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
		categoriaService.atualizarCategoria(id, categoria);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCategoria(@PathVariable Integer id) {
		categoriaService.deletarCategoria(id);
	}
}

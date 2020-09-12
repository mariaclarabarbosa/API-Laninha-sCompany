package com.laninhacompany.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.laninhacompany.ecommerce.models.Categoria;
import com.laninhacompany.ecommerce.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	//CRUD
	
	@PostMapping
	public ResponseEntity<String> criarCategoria(@Valid @RequestBody Categoria categoria) throws NullObjectException {
		String msg = categoriaService.criarCategoria(categoria);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listarCategorias(){
		List<Categoria> listaCategorias = categoriaService.listarCategorias();
		return new ResponseEntity<List<Categoria>>(listaCategorias, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> listarCategoriaPorId(@PathVariable Integer id) throws CodigoNotFoundException {
		Categoria c = categoriaService.listarCategoriaPorId(id);
		return new ResponseEntity<Categoria>(c, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarCategoria(@PathVariable Integer id, @Valid @RequestBody Categoria categoria) throws CodigoNotFoundException {
		String msg = categoriaService.atualizarCategoria(id, categoria);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarCategoria(@PathVariable Integer id) throws CodigoNotFoundException {
		String msg = categoriaService.deletarCategoria(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}

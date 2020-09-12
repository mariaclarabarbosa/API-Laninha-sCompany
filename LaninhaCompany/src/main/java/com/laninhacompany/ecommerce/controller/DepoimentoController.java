package com.laninhacompany.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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
import com.laninhacompany.ecommerce.form.DepoimentoForm;
import com.laninhacompany.ecommerce.models.Depoimento;
import com.laninhacompany.ecommerce.service.DepoimentoService;

@RestController
@RequestMapping("/cliente/depoimentos")
public class DepoimentoController {

	@Autowired
	DepoimentoService depoimentoService;
	
	@PostMapping
	public ResponseEntity<String> criarDepoimento(@Valid @RequestBody DepoimentoForm depoimentoForm) throws NullObjectException {
		String msg = depoimentoService.criarDepoimento(depoimentoForm);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping("//{id}")
	public ResponseEntity<List<Depoimento>> listarDepoimentos(@PathVariable  Integer id){
		List<Depoimento> listaDepoimentos = depoimentoService.listarDepoimentos(id);
		return new ResponseEntity<List<Depoimento>>(listaDepoimentos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Depoimento> listarDepoimentoPorId(@PathVariable Integer id) throws CodigoNotFoundException {
		Depoimento d = depoimentoService.listarDepoimentoPorId(id);
		return new ResponseEntity<Depoimento>(d, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarDepoimento(@PathVariable Integer id, @RequestBody DepoimentoForm depoimentoForm) throws CodigoNotFoundException {
		String msg = depoimentoService.atualizarDepoimento(id, depoimentoForm);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarDepoimento(@PathVariable Integer id) throws CodigoNotFoundException {
		String msg = depoimentoService.deletarDepoimento(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}

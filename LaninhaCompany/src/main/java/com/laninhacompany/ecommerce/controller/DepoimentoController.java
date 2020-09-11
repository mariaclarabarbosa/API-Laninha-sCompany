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

import com.laninhacompany.ecommerce.form.DepoimentoForm;
import com.laninhacompany.ecommerce.models.Depoimento;
import com.laninhacompany.ecommerce.service.DepoimentoService;

@RestController
@RequestMapping("/cliente/depoimentos")
public class DepoimentoController {

	@Autowired
	DepoimentoService depoimentoService;
	
	@PostMapping
	public void criarDepoimento(@RequestBody DepoimentoForm depoimentoForm) {
		depoimentoService.criarDepoimento(depoimentoForm);
	}
	
	@GetMapping
	public List<Depoimento> listarDepoimentos(){
		return depoimentoService.listarDepoimentos();
	}
	
	@GetMapping("/{id}")
	public Depoimento listarDepoimentoPorId(@PathVariable Integer id) {
		return depoimentoService.listarDepoimentoPorId(id);
	}
	
	@PutMapping("/{id}")
	public void atualizarDepoimento(@PathVariable Integer id, @RequestBody DepoimentoForm depoimentoForm) {
		depoimentoService.atualizarDepoimento(id, depoimentoForm);
	}
	
	@DeleteMapping("/{id}")
	public void deletarDepoimento(@PathVariable Integer id) {
		depoimentoService.deletarDepoimento(id);
	}
}

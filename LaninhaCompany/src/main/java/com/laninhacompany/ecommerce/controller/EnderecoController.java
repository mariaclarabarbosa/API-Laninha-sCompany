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

import com.laninhacompany.ecommerce.form.EnderecoForm;
import com.laninhacompany.ecommerce.models.Endereco;
import com.laninhacompany.ecommerce.service.EnderecoService;

@RestController
@RequestMapping("/cliente/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping
	public void inserirEndereco(@RequestBody EnderecoForm enderecoForm) {
		enderecoService.inserirEndereco(enderecoForm);
	}
	
	@GetMapping
	public List<Endereco> listarEnderecos(){
		return enderecoService.listarEnderecos();
	}
	
	@GetMapping("/{id}")
	public Endereco listarEnderecoPorId(@PathVariable Integer id) {
		return enderecoService.listarEnderecoPorId(id);
	}
	
	@PutMapping("/{id}")
	public void atualizarEndereco(@PathVariable Integer id, @RequestBody EnderecoForm enderecoForm) {
		enderecoService.atualizarEndereco(id, enderecoForm);
	}
	
	@DeleteMapping("/{id}")
	public void deletarEndereco(@PathVariable Integer id) {
		enderecoService.deletarEndereco(id);
	}
}

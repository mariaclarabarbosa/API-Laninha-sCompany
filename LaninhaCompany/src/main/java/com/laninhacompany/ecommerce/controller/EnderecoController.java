package com.laninhacompany.ecommerce.controller;

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

import com.laninhacompany.ecommerce.exceptions.EnderecoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.NullObjectException;
import com.laninhacompany.ecommerce.form.EnderecoForm;
import com.laninhacompany.ecommerce.models.Endereco;
import com.laninhacompany.ecommerce.service.EnderecoService;

@RestController
@RequestMapping("/cliente/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping
	public ResponseEntity<String> inserirEndereco(@RequestBody EnderecoForm enderecoForm) throws NullObjectException {
		String msg = enderecoService.inserirEndereco(enderecoForm);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> pegarEnderecoDoCliente(@PathVariable Integer id) throws EnderecoNotFoundException{
		Endereco e = enderecoService.pegarEnderecoDoCliente(id);
		return new ResponseEntity<Endereco>(e, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarEndereco(@PathVariable Integer id, @RequestBody EnderecoForm enderecoForm) throws EnderecoNotFoundException{
		String msg =enderecoService.atualizarEndereco(id, enderecoForm);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarEndereco(@PathVariable Integer id) throws EnderecoNotFoundException {
		String msg = enderecoService.deletarEndereco(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}

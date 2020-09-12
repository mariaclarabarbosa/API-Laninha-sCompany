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
import com.laninhacompany.ecommerce.models.Cliente;
import com.laninhacompany.ecommerce.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<String> cadastrarCliente(@Valid @RequestBody Cliente cliente) throws NullObjectException {
		String msg = clienteService.cadastrarCliente(cliente);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes(){
		List<Cliente> listaClientes = clienteService.listarClientes();
		return new ResponseEntity<List<Cliente>>(listaClientes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarClientePorId(@PathVariable Integer id) throws CodigoNotFoundException {
		Cliente c = clienteService.listarClientePorId(id);
		return new ResponseEntity<Cliente>(c, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarCliente(@PathVariable Integer id, @Valid @RequestBody Cliente cliente) throws CodigoNotFoundException {
		String msg = clienteService.atualizarCliente(id, cliente);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarCliente(@PathVariable Integer id) throws CodigoNotFoundException {
		String msg = clienteService.deletarCliente(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}

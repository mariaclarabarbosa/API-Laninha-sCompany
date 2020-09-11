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

import com.laninhacompany.ecommerce.models.Cliente;
import com.laninhacompany.ecommerce.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public void cadastrarCliente(@RequestBody Cliente cliente) {
		clienteService.cadastrarCliente(cliente);
	}
	
	@GetMapping
	public List<Cliente> listarClientes(){
		return clienteService.listarClientes();
	}
	
	@GetMapping("/{id}")
	public Cliente listarClientePorId(@PathVariable Integer id) {
		return clienteService.listarClientePorId(id);
	}
	
	@PutMapping("/{id}")
	public void atualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
		clienteService.atualizarCliente(id, cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable Integer id) {
		clienteService.deletarCliente(id);
	}
}

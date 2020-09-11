package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.models.Cliente;
import com.laninhacompany.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public void cadastrarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}

	public Cliente listarClientePorId(Integer id) {
		Optional<Cliente> opC = clienteRepository.findById(id);
		Cliente cliente = opC.get();
		return cliente;
	}

	public void atualizarCliente(Integer id, Cliente cliente) {
		Cliente cDB = listarClientePorId(id);
		
		if(cliente.getCelular() != null) {
			cDB.setCelular(cliente.getCelular());
		}
		if(cliente.getCpf() != null) {
			cDB.setCpf(cliente.getCpf());
		}
		if(cliente.getEmail() != null) {
			cDB.setEmail(cliente.getEmail());
		}
		if(cliente.getNome() != null) {
			cDB.setNome(cliente.getNome());
		}
		if(cliente.getRevendedor() != null) {
			cDB.setRevendedor(cliente.getRevendedor());
		}
		
		clienteRepository.save(cDB);
		
	}

	public void deletarCliente(Integer id) {
		clienteRepository.deleteById(id);
	}
}

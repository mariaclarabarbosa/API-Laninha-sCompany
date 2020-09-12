package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.exceptions.CodigoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.NullObjectException;
import com.laninhacompany.ecommerce.models.Cliente;
import com.laninhacompany.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public String cadastrarCliente(Cliente cliente) throws NullObjectException {
		if(cliente != null) {
			clienteRepository.save(cliente);
			return "Cliente cadastrado com sucesso!";
		}
		throw new NullObjectException("Para o cadastro do cliente, os campos devem ser preenchidos!");
	}

	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}

	public Cliente listarClientePorId(Integer id) throws CodigoNotFoundException {
		Optional<Cliente> opC = clienteRepository.findById(id);
		if(opC.isPresent()) {
			Cliente cliente = opC.get();
			return cliente;
		}
		throw new CodigoNotFoundException("Não foi encontrado um cliente com o id" + id);
	}

	public String atualizarCliente(Integer id, Cliente cliente) throws CodigoNotFoundException {
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
		return "Cliente atualizado com sucesso!";
		
	}

	public String deletarCliente(Integer id) throws CodigoNotFoundException {
		Cliente c = listarClientePorId(id);
		clienteRepository.delete(c);
		return "Cliente deletado com sucesso!";
		
	}
}

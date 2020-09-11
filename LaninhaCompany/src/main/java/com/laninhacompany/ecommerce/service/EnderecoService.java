package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.form.EnderecoForm;
import com.laninhacompany.ecommerce.models.Cliente;
import com.laninhacompany.ecommerce.models.Endereco;
import com.laninhacompany.ecommerce.repository.ClienteRepository;
import com.laninhacompany.ecommerce.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public void inserirEndereco(EnderecoForm enderecoForm) {
		Endereco endereco = new Endereco();
		endereco.setCep(enderecoForm.getCep());
		endereco.setComplemento(enderecoForm.getComplemento());
		endereco.setLogradouro(enderecoForm.getLogradouro());
		endereco.setNumero(enderecoForm.getNumero());
		Optional<Cliente> opC = clienteRepository.findById(enderecoForm.getId_cliente());
		Cliente cliente = opC.get();
		endereco.setCliente(cliente);
		enderecoRepository.save(endereco);
	}

	public List<Endereco> listarEnderecos() {
		return enderecoRepository.findAll();
	}

	public Endereco listarEnderecoPorId(Integer id) {
		Optional<Endereco> opE = enderecoRepository.findById(id);
		Endereco endereco = opE.get();
		return endereco;
	}

	public void atualizarEndereco(Integer id, EnderecoForm enderecoForm) {
		Endereco eDB = listarEnderecoPorId(id);
		
		if(enderecoForm.getCep() != null) {
			eDB.setCep(enderecoForm.getCep());
		}
		if(enderecoForm.getComplemento() != null) {
			eDB.setComplemento(enderecoForm.getComplemento());
		}
		if(enderecoForm.getLogradouro() != null) {
			eDB.setLogradouro(enderecoForm.getLogradouro());
		}
		if(enderecoForm.getNumero() != null) {
			eDB.setNumero(enderecoForm.getNumero());
		}
		
		enderecoRepository.save(eDB);
		
	}

	public void deletarEndereco(Integer id) {
		enderecoRepository.deleteById(id);
	}
}

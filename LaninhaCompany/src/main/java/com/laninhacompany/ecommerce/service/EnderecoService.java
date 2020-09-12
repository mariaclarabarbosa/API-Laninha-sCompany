package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.exceptions.CodigoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.EnderecoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.NullObjectException;
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

	public String inserirEndereco(EnderecoForm enderecoForm) throws NullObjectException {
		
		if(enderecoForm == null) {
			throw new NullObjectException("É necessário preencher todos os campos!");
		}
		Endereco endereco = new Endereco();
		endereco.setCep(enderecoForm.getCep());
		endereco.setComplemento(enderecoForm.getComplemento());
		endereco.setLogradouro(enderecoForm.getLogradouro());
		endereco.setNumero(enderecoForm.getNumero());
		Optional<Cliente> opC = clienteRepository.findById(enderecoForm.getId_cliente());
		Cliente cliente = opC.get();
		endereco.setCliente(cliente);
		enderecoRepository.save(endereco);
		return "Endereço cadastrado com sucesso!";
	}

	public Endereco pegarEnderecoDoCliente(Integer id) throws EnderecoNotFoundException {
		Optional<Cliente> opC = clienteRepository.findById(id);
		Cliente c = opC.get();
		Optional<Endereco> opE = enderecoRepository.findByCliente(c);
		if(opE.isPresent()) {
			Endereco endereco = opE.get();
			return endereco;
		}
		throw new EnderecoNotFoundException("O cliente não possui um endereço cadastrado!");
	}

	public String atualizarEndereco(Integer id, EnderecoForm enderecoForm) throws EnderecoNotFoundException {
		Endereco eDB = pegarEnderecoDoCliente(id);
		
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
		return("Endereço atualizado com sucesso!");
		
	}

	public String deletarEndereco(Integer id) throws EnderecoNotFoundException {
		Endereco e = pegarEnderecoDoCliente(id);
		enderecoRepository.delete(e);
		return "Endereço deletado com sucesso!";
	}
}

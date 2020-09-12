package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.exceptions.CodigoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.NullObjectException;
import com.laninhacompany.ecommerce.form.DepoimentoForm;
import com.laninhacompany.ecommerce.models.Cliente;
import com.laninhacompany.ecommerce.models.Depoimento;
import com.laninhacompany.ecommerce.models.Produto;
import com.laninhacompany.ecommerce.repository.ClienteRepository;
import com.laninhacompany.ecommerce.repository.DepoimentoRepository;
import com.laninhacompany.ecommerce.repository.ProdutoRepository;

@Service
public class DepoimentoService {

	@Autowired
	DepoimentoRepository depoimentoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	public String criarDepoimento(DepoimentoForm depoimentoForm) throws NullObjectException {
		if(depoimentoForm != null) {
			Depoimento depoimento = new Depoimento();
			depoimento.setMensagem(depoimentoForm.getMensagem());
			Optional<Cliente> opC = clienteRepository.findById(depoimentoForm.getId_cliente());
			Cliente cliente = opC.get();
			depoimento.setCliente(cliente);
			Optional<Produto> opP = produtoRepository.findById(depoimentoForm.getId_produto());
			Produto produto = opP.get();
			depoimento.setProduto(produto);
			depoimentoRepository.save(depoimento);
		}
		throw new NullObjectException("Para adicionar um depoimento é necessário colocar uma mensagem!");
	}

	public List<Depoimento> listarDepoimentos(Integer id) {
		Optional<Cliente>opC = clienteRepository.findById(id);
		Cliente cliente = opC.get();
		return depoimentoRepository.findAllByCliente(cliente);
	}

	public Depoimento listarDepoimentoPorId(Integer id) throws CodigoNotFoundException {
		Optional<Depoimento> opD = depoimentoRepository.findById(id);
		if(opD.isPresent()) {
			Depoimento depoimento = opD.get();
			return depoimento;
		}
		throw new CodigoNotFoundException("Não foi encontrado um depoimento com o id " + id);
	}

	public String atualizarDepoimento(Integer id, DepoimentoForm depoimentoForm) throws CodigoNotFoundException {
		Depoimento dDB = listarDepoimentoPorId(id);
		if(depoimentoForm.getMensagem() != null) {
			dDB.setMensagem(depoimentoForm.getMensagem());
		}
		depoimentoRepository.save(dDB);
		return "Depoimento atualizado com sucesso!";
		
	}

	public String deletarDepoimento(Integer id) throws CodigoNotFoundException {
		Depoimento d = listarDepoimentoPorId(id);
		depoimentoRepository.delete(d);
		return "Depoimento deletado com sucesso!";
	}
}

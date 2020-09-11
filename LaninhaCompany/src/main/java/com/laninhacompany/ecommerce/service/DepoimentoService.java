package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void criarDepoimento(DepoimentoForm depoimentoForm) {
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

	public List<Depoimento> listarDepoimentos() {
		return depoimentoRepository.findAll();
	}

	public Depoimento listarDepoimentoPorId(Integer id) {
		Optional<Depoimento> opD = depoimentoRepository.findById(id);
		Depoimento depoimento = opD.get();
		return depoimento;
	}

	public void atualizarDepoimento(Integer id, DepoimentoForm depoimentoForm) {
		Depoimento dDB = listarDepoimentoPorId(id);
		if(depoimentoForm.getMensagem() != null) {
			dDB.setMensagem(depoimentoForm.getMensagem());
		}
		depoimentoRepository.save(dDB);
		
	}

	public void deletarDepoimento(Integer id) {
		depoimentoRepository.deleteById(id);
	}
}

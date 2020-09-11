package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.models.Pagamento;
import com.laninhacompany.ecommerce.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	PagamentoRepository pagamentoRepository;

	public void inserirFormaDePagamento(Pagamento pagamento) {
		pagamentoRepository.save(pagamento);
	}

	public List<Pagamento> listarFormasDePagamento() {
		return pagamentoRepository.findAll();
	}

	public Pagamento listarFormaDePagamentoPorId(Integer id) {
		Optional<Pagamento> opP = pagamentoRepository.findById(id);
		Pagamento pagamento = opP.get();
		return pagamento;
	}

	public void atualizarFormaDePagamento(Integer id, Pagamento pagamento) {
		Pagamento pDB = listarFormaDePagamentoPorId(id);
		pDB.setTipo(pagamento.getTipo());
		pagamentoRepository.save(pDB);
	}

	public void deletarFormaDePagamento(Integer id) {
		pagamentoRepository.deleteById(id);
	}
}

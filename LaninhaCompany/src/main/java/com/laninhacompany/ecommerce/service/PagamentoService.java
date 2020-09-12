package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.exceptions.CodigoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.NullObjectException;
import com.laninhacompany.ecommerce.models.Pagamento;
import com.laninhacompany.ecommerce.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	PagamentoRepository pagamentoRepository;

	public String inserirFormaDePagamento(Pagamento pagamento) throws NullObjectException {
		if(pagamento != null) {
			pagamentoRepository.save(pagamento);
			return "Nova forma de pagamento adicionada com sucesso!";
		}
		throw new NullObjectException("É obrigatório especificar um tipo!");
	}

	public List<Pagamento> listarFormasDePagamento() {
		return pagamentoRepository.findAll();
	}

	public Pagamento listarFormaDePagamentoPorId(Integer id) throws CodigoNotFoundException {
		Optional<Pagamento> opP = pagamentoRepository.findById(id);
		if(opP.isPresent()) {
			Pagamento pagamento = opP.get();
			return pagamento;
		}
		throw new CodigoNotFoundException("Não foi encontrado uma forma de pagamento com o id" + id);
	}

	public String atualizarFormaDePagamento(Integer id, Pagamento pagamento) throws CodigoNotFoundException {
		Pagamento pDB = listarFormaDePagamentoPorId(id);
		pDB.setTipo(pagamento.getTipo());
		pagamentoRepository.save(pDB);
		return "Forma de pagamento atualizada com sucesso!";
	}

	public String deletarFormaDePagamento(Integer id) throws CodigoNotFoundException {
		Pagamento p = listarFormaDePagamentoPorId(id);
		pagamentoRepository.delete(p);
		return "Forma de pagamento deletada com sucesso!";
	}
}

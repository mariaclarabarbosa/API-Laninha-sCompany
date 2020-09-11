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

import com.laninhacompany.ecommerce.models.Pagamento;
import com.laninhacompany.ecommerce.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	PagamentoService pagamentoService;
	
	@PostMapping
	public void inserirFormaDePagamento(@RequestBody Pagamento pagamento) {
		pagamentoService.inserirFormaDePagamento(pagamento);
	}
	
	@GetMapping
	public List<Pagamento> listarFormasDePagamento(){
		return pagamentoService.listarFormasDePagamento();
	}
	
	@GetMapping("/{id}")
	public Pagamento listarFormaDePagamentoPorId(@PathVariable Integer id) {
		return pagamentoService.listarFormaDePagamentoPorId(id);
	}
	
	@PutMapping("/{id}")
	public void atualizarFormaDePagamento(@PathVariable Integer id, @RequestBody Pagamento pagamento) {
		pagamentoService.atualizarFormaDePagamento(id, pagamento);
	}
	
	@DeleteMapping("/{id}")
	public void deletarFormaDePagamento(@PathVariable Integer id) {
		pagamentoService.deletarFormaDePagamento(id);
	}
}

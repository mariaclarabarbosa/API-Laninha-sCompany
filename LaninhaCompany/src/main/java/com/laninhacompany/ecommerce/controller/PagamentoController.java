package com.laninhacompany.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laninhacompany.ecommerce.exceptions.CodigoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.NullObjectException;
import com.laninhacompany.ecommerce.models.Pagamento;
import com.laninhacompany.ecommerce.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	PagamentoService pagamentoService;
	
	@PostMapping
	public ResponseEntity<String> inserirFormaDePagamento(@RequestBody Pagamento pagamento) throws NullObjectException {
		String msg = pagamentoService.inserirFormaDePagamento(pagamento);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Pagamento>> listarFormasDePagamento(){
		List<Pagamento> listaPagamentos = pagamentoService.listarFormasDePagamento();
		return new ResponseEntity<List<Pagamento>>(listaPagamentos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pagamento> listarFormaDePagamentoPorId(@PathVariable Integer id) throws CodigoNotFoundException {
		Pagamento p = pagamentoService.listarFormaDePagamentoPorId(id);
		return new ResponseEntity<Pagamento>(p, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarFormaDePagamento(@PathVariable Integer id, @RequestBody Pagamento pagamento) throws CodigoNotFoundException {
		String msg =pagamentoService.atualizarFormaDePagamento(id, pagamento);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarFormaDePagamento(@PathVariable Integer id) throws CodigoNotFoundException {
		String msg = pagamentoService.deletarFormaDePagamento(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}

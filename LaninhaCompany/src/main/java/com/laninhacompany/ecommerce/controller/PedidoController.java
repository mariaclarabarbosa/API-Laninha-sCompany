package com.laninhacompany.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laninhacompany.ecommerce.exceptions.CodigoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.NullObjectException;
import com.laninhacompany.ecommerce.form.CarrinhoForm;
import com.laninhacompany.ecommerce.form.PedidoCarrinhoForm;
import com.laninhacompany.ecommerce.form.PedidoForm;
import com.laninhacompany.ecommerce.models.Carrinho;
import com.laninhacompany.ecommerce.models.Pedido;
import com.laninhacompany.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<String> fazerPedido(@RequestBody PedidoCarrinhoForm pedidoCarrinhoForm) throws NullObjectException {
		String msg = pedidoService.fazerPedido(pedidoCarrinhoForm);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<String> adicionarProdutoNoPedido(@PathVariable Integer id, @RequestBody CarrinhoForm carrinhoForm) throws NullObjectException, CodigoNotFoundException {
		String msg =  pedidoService.adicionarProdutoNoPedido(id, carrinhoForm);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Pedido>> listarPedidos(){
		List<Pedido> listaPedidos = pedidoService.listarPedidos();
		return new ResponseEntity<List<Pedido>>(listaPedidos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> listarPedidoPorId(@PathVariable Integer id) throws CodigoNotFoundException {
		Pedido p = pedidoService.listarPedidoPorId(id);
		return new ResponseEntity<Pedido>(p, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/{idC}")
	public ResponseEntity<Carrinho> listarCarrinhoPorId(@PathVariable Integer id, @PathVariable Integer idC) throws CodigoNotFoundException {
		Carrinho c = pedidoService.listarCarrinhoPorId(id, idC);
		return new ResponseEntity<Carrinho>(c, HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<String> atualizarPedido(@PathVariable Integer id, @RequestBody PedidoForm pedidoForm) throws CodigoNotFoundException {
		String msg =  pedidoService.atualizarPedido(id, pedidoForm);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarProdutoNoPedido(@PathVariable Integer id, @RequestBody CarrinhoForm carrinhoForm) throws CodigoNotFoundException {
		String msg =  pedidoService.atualizarProdutoNoPedido(id, carrinhoForm);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarPedido(@PathVariable Integer id) throws CodigoNotFoundException {
		String msg =  pedidoService.deletarPedido(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/{idC}")
	public ResponseEntity<String> deletarProdutoNoPedido(@PathVariable Integer id, @PathVariable Integer idC) throws CodigoNotFoundException {
		String msg =  pedidoService.deletarProdutoNoPedido(id, idC);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}

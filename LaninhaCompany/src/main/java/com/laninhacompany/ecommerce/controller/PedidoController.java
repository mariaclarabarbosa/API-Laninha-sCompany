package com.laninhacompany.ecommerce.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laninhacompany.ecommerce.form.CarrinhoForm;
import com.laninhacompany.ecommerce.form.PedidoCarrinhoForm;
import com.laninhacompany.ecommerce.form.PedidoForm;
import com.laninhacompany.ecommerce.models.Pedido;
import com.laninhacompany.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	@PostMapping
	public void fazerPedido(@RequestBody PedidoCarrinhoForm pedidoCarrinhoForm) {
		pedidoService.fazerPedido(pedidoCarrinhoForm);
	}
	
	@PostMapping("/{id}")
	public void adicionarProdutoNoPedido(@PathVariable Integer id, @RequestBody CarrinhoForm carrinhoForm) {
		pedidoService.adicionarProdutoNoPedido(id, carrinhoForm);
	}
	
	@GetMapping
	public List<Pedido> listarPedidos(){
		return pedidoService.listarPedidos();
	}
	
	@GetMapping("/{id}")
	public Pedido listarPedidoPorId(@PathVariable Integer id) {
		return pedidoService.listarPedidoPorId(id);
	}
	
	@PatchMapping("/{id}")
	public void atualizarPedido(@PathVariable Integer id, @RequestBody PedidoForm pedidoForm) {
		pedidoService.atualizarPedido(id, pedidoForm);
	}
	
	@PutMapping("/{id}-{idC}") //Não tá trocando o valor total
	public void atualizarProdutoNoPedido(@PathVariable Integer id, @PathParam("idC") Integer idC, @RequestBody CarrinhoForm carrinhoForm) {
		pedidoService.atualizarProdutoNoPedido(id, idC, carrinhoForm);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPedido(@PathVariable Integer id) {
		pedidoService.deletarPedido(id);
	}
	
	@DeleteMapping("/{id}-{idC}")
	public void deletarProdutoNoPedido(@PathVariable Integer id, @PathParam("idC") Integer idC) {
		pedidoService.deletarProdutoNoPedido(id, idC);
	}
}

package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.form.CarrinhoForm;
import com.laninhacompany.ecommerce.form.PedidoCarrinhoForm;
import com.laninhacompany.ecommerce.form.PedidoForm;
import com.laninhacompany.ecommerce.models.Carrinho;
import com.laninhacompany.ecommerce.models.Cliente;
import com.laninhacompany.ecommerce.models.Pagamento;
import com.laninhacompany.ecommerce.models.Pedido;
import com.laninhacompany.ecommerce.models.Produto;
import com.laninhacompany.ecommerce.repository.CarrinhoRepository;
import com.laninhacompany.ecommerce.repository.ClienteRepository;
import com.laninhacompany.ecommerce.repository.PagamentoRepository;
import com.laninhacompany.ecommerce.repository.PedidoRepository;
import com.laninhacompany.ecommerce.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	CarrinhoRepository carrinhoRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	public void fazerPedido(PedidoCarrinhoForm pedidoCarrinhoForm) {
		Pedido pedido = new Pedido();
		pedido.setData_pedido(pedidoCarrinhoForm.getData_pedido());
		Optional<Cliente> opC = clienteRepository.findById(pedidoCarrinhoForm.getId_cliente());
		Cliente cliente = opC.get();
		pedido.setCliente(cliente);
		Optional<Pagamento> opPag = pagamentoRepository.findById(pedidoCarrinhoForm.getId_pagamento());
		Pagamento pagamento = opPag.get();
		pedido.setPagamento(pagamento);
		
		Carrinho carrinho = new Carrinho();
		carrinho.setUnidades(pedidoCarrinhoForm.getUnidades());
		Optional<Produto> opProd = produtoRepository.findById(pedidoCarrinhoForm.getId_produto());
		Produto produto = opProd.get();
		carrinho.setProduto(produto);
		
		Double total = pedidoCarrinhoForm.getUnidades() * produto.getValor();
		pedido.setTotal(total);
		
		carrinho.setPedido(pedido);
		
		pedidoRepository.save(pedido);
		carrinhoRepository.save(carrinho);
	}

	public void adicionarProdutoNoPedido(Integer id, CarrinhoForm carrinhoForm) {
		Optional<Pedido> opPed = pedidoRepository.findById(id);
		Pedido pedido = opPed.get();
		Optional<Produto> opProd = produtoRepository.findById(carrinhoForm.getId_produto());
		Produto produto = opProd.get();
		
		Carrinho carrinho = new Carrinho();
		carrinho.setPedido(pedido);
		carrinho.setUnidades(carrinhoForm.getUnidades());
		carrinho.setProduto(produto);
		
		Double total = pedido.getTotal() + (carrinhoForm.getUnidades() * produto.getValor());
		pedido.setTotal(total);
		
		pedidoRepository.save(pedido);
		carrinhoRepository.save(carrinho);
		
	}

	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();
	}

	public Pedido listarPedidoPorId(Integer id) {
		Optional<Pedido> opPed = pedidoRepository.findById(id);
		Pedido pedido = opPed.get();
		return pedido;
	}

	public Carrinho listarCarrinhoPorId(Integer id, Integer idC) {
		Pedido pedido = listarPedidoPorId(id);
		List<Carrinho> listaCarrinho = carrinhoRepository.findAllByPedido(pedido);
		for(Carrinho carrinho : listaCarrinho) {
			if(carrinho.getId() == idC) {
				return carrinho;
			}
		}
		return null;
	}

	public void atualizarPedido(Integer id, PedidoForm pedidoForm) {
		Pedido pedido = listarPedidoPorId(id);

		if(pedidoForm.getId_pagamento() != null) {
			Optional<Pagamento> opPag = pagamentoRepository.findById(pedidoForm.getId_pagamento());
			Pagamento pagamento = opPag.get();
	
			pedido.setPagamento(pagamento);
			pedido.setData_pedido(pedidoForm.getData_pedido());
		}
		pedidoRepository.save(pedido);
		
	}
	

	public void atualizarProdutoNoPedido(Integer id, CarrinhoForm carrinhoForm) {
		Pedido pedido = listarPedidoPorId(id);
		Carrinho carrinho = listarCarrinhoPorId(carrinhoForm.getId(), id);
		Produto produtoVelho = carrinho.getProduto(); //Produto registrado anteriormente
		Double velhoTotal = pedido.getTotal() - (carrinho.getUnidades() * produtoVelho.getValor()); //O valor como estava antes da modificação 
		Produto produtoNovo = new Produto(); //Para receber o novo produto, caso seja modificado
		Double novoTotal; //novo total gerado com as modificações
		
		//Para modificar 
		if(carrinhoForm.getId_produto() != null) {
			Optional<Produto> opP = produtoRepository.findById(carrinhoForm.getId_produto());
			Produto produto = opP.get();
			produtoNovo = produto;
			carrinho.setProduto(produto);
		}
		if(carrinhoForm.getUnidades() != null){
			carrinho.setUnidades(carrinhoForm.getUnidades());
		}
		
		if(carrinhoForm.getId_produto() != null && carrinhoForm.getUnidades() != null) {
			novoTotal = velhoTotal + (produtoNovo.getValor() * carrinho.getUnidades());
			pedido.setTotal(novoTotal);
		} else if(carrinhoForm.getId_produto() != null && carrinhoForm.getUnidades() == null) {
			novoTotal = velhoTotal + (produtoNovo.getValor() * carrinho.getUnidades());
			pedido.setTotal(novoTotal);
		} else if(carrinhoForm.getId_produto() == null && carrinhoForm.getUnidades() != null) {
			novoTotal = velhoTotal + (produtoVelho.getValor() * carrinho.getUnidades());
			pedido.setTotal(novoTotal);
		}
		
		pedidoRepository.save(pedido);
		carrinhoRepository.save(carrinho);
	}

	public void deletarPedido(Integer id) {
		pedidoRepository.deleteById(id);
	}

	public void deletarProdutoNoPedido(Integer id, Integer idC) {
		Pedido pedido = listarPedidoPorId(id);
		Carrinho carrinho = listarCarrinhoPorId(idC, id);
		Produto p = carrinho.getProduto();
		Double novoValor = pedido.getTotal() - (carrinho.getUnidades() * p.getValor());
		pedido.setTotal(novoValor);
		pedidoRepository.save(pedido);
		carrinhoRepository.delete(carrinho);
	}
	
	
	
}

package com.laninhacompany.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laninhacompany.ecommerce.models.Carrinho;
import com.laninhacompany.ecommerce.models.Pedido;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {

	List<Carrinho> findAllByPedido(Pedido pedido);


}

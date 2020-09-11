package com.laninhacompany.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laninhacompany.ecommerce.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}

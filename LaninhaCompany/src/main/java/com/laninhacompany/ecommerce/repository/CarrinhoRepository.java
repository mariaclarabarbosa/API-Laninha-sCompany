package com.laninhacompany.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laninhacompany.ecommerce.models.Carrinho;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {

}

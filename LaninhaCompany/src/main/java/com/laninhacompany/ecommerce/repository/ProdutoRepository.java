package com.laninhacompany.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laninhacompany.ecommerce.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}

package com.laninhacompany.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laninhacompany.ecommerce.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
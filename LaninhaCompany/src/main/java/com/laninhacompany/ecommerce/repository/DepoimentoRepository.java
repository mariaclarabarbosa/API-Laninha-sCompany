package com.laninhacompany.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laninhacompany.ecommerce.models.Cliente;
import com.laninhacompany.ecommerce.models.Depoimento;

@Repository
public interface DepoimentoRepository extends JpaRepository<Depoimento, Integer> {

	List<Depoimento> findAllByCliente(Cliente cliente);

}

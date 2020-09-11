package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.models.Categoria;
import com.laninhacompany.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public void criarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}

	public Categoria listarCategoriaPorId(Integer id) {
		Optional<Categoria> opC = categoriaRepository.findById(id);
		Categoria c = opC.get();
		return c;
	}

	public void atualizarCategoria(Integer id, Categoria categoria) {
		Categoria cDB = listarCategoriaPorId(id);
		if(categoria.getNome() != null) {
			cDB.setNome(categoria.getNome());
		}
		if(categoria.getDescricao() != null) {
			cDB.setDescricao(categoria.getDescricao());
		}
		categoriaRepository.save(cDB);
		
	}

	public void deletarCategoria(Integer id) {
		Categoria cDB = listarCategoriaPorId(id);
		categoriaRepository.delete(cDB);
	}
}

package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.exceptions.CodigoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.NullObjectException;
import com.laninhacompany.ecommerce.models.Categoria;
import com.laninhacompany.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public String criarCategoria(Categoria categoria) throws NullObjectException {
		if(categoria != null) {
			categoriaRepository.save(categoria);
			return "Categoria criada com sucesso";
		}
		throw new NullObjectException("Para a inserção de uma nova categoria, os campos devem ser preenchidos!");
	}

	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}

	public Categoria listarCategoriaPorId(Integer id) throws CodigoNotFoundException {
		Optional<Categoria> opC = categoriaRepository.findById(id);
		if(opC.isPresent()) {
			Categoria c = opC.get();
			return c;
		}
		throw new CodigoNotFoundException("Não foi encontrada uma categoria com o código " + id);
	}

	public String atualizarCategoria(Integer id, Categoria categoria) throws CodigoNotFoundException {
		Categoria cDB = listarCategoriaPorId(id);
		if(categoria.getNome() != null) {
			cDB.setNome(categoria.getNome());
		}
		if(categoria.getDescricao() != null) {
			cDB.setDescricao(categoria.getDescricao());
		}
		categoriaRepository.save(cDB);
		return "A categoria foi atualizada com sucesso!";
		
	}

	public String deletarCategoria(Integer id) throws CodigoNotFoundException {
		Categoria cDB = listarCategoriaPorId(id);
		categoriaRepository.delete(cDB);
		return "Categoria deletada com sucesso!";
	}
}

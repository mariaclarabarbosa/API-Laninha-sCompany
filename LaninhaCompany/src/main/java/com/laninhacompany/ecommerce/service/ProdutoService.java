package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.form.ProdutoForm;
import com.laninhacompany.ecommerce.models.Categoria;
import com.laninhacompany.ecommerce.models.Produto;
import com.laninhacompany.ecommerce.repository.CategoriaRepository;
import com.laninhacompany.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CategoriaRepository categoriaRepository;

	public void inserirProduto(ProdutoForm produtoForm) {
		Produto produto = new Produto();
		produto.setNome(produtoForm.getNome());
		produto.setDescricao(produtoForm.getDescricao());
		produto.setMarca(produtoForm.getMarca());
		produto.setCod_anvisa(produtoForm.getCod_anvisa());
		produto.setEstoque(produtoForm.getEstoque());
		produto.setValor(produtoForm.getValor());
		Optional<Categoria> opC = categoriaRepository.findById(produtoForm.getId_categoria());
		Categoria categoria = opC.get();
		produto.setCategoria(categoria);
		produtoRepository.save(produto);
	}

	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	public Produto listarProdutoPorId(Integer id) {
		Optional<Produto> opP = produtoRepository.findById(id);
		Produto produto = opP.get();
		return produto;
	}

	public void atualizarProduto(Integer id, ProdutoForm produtoForm) {
		Produto pDB = listarProdutoPorId(id);
		
		if(produtoForm.getCod_anvisa() != null) {
			pDB.setCod_anvisa(produtoForm.getCod_anvisa());
		}
		if(produtoForm.getDescricao() != null) {
			pDB.setDescricao(produtoForm.getDescricao());
		}
		if(produtoForm.getEstoque() != null) {
			pDB.setEstoque(produtoForm.getEstoque());
		}
		if(produtoForm.getId_categoria() != null) {
			Optional<Categoria> opC = categoriaRepository.findById(produtoForm.getId_categoria());
			Categoria c = opC.get();
			pDB.setCategoria(c);
		}
		if(produtoForm.getMarca() != null){
			pDB.setMarca(produtoForm.getMarca());
		}
		if(produtoForm.getNome() != null) {
			pDB.setNome(produtoForm.getNome());
		}
		if(produtoForm.getValor() != null) {
			pDB.setValor(produtoForm.getValor());
		}
		
		produtoRepository.save(pDB);
		
	}

	public void deletarProduto(Integer id) {
		produtoRepository.deleteById(id);
	}
}

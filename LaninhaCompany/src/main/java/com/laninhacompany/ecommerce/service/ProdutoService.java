package com.laninhacompany.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laninhacompany.ecommerce.exceptions.CodigoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.NullObjectException;
import com.laninhacompany.ecommerce.form.ProdutoForm;
import com.laninhacompany.ecommerce.models.Categoria;
import com.laninhacompany.ecommerce.models.Depoimento;
import com.laninhacompany.ecommerce.models.Produto;
import com.laninhacompany.ecommerce.repository.CategoriaRepository;
import com.laninhacompany.ecommerce.repository.DepoimentoRepository;
import com.laninhacompany.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	DepoimentoRepository depoimentoRepository;

	public String inserirProduto(ProdutoForm produtoForm) throws NullObjectException {
		if(produtoForm == null) {
			throw new NullObjectException("Todos os campos são de preenchimento obrigatório!");
		}
		
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
		return "Produto cadastrado com sucesso!";
	}

	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	public Produto listarProdutoPorId(Integer id) throws CodigoNotFoundException {
		Optional<Produto> opP = produtoRepository.findById(id);
		if(opP.isPresent()) {
			Produto produto = opP.get();
			return produto;
		}
		throw new CodigoNotFoundException("Não foi encontrado um produto com o id " + id);
	}

	public String atualizarProduto(Integer id, ProdutoForm produtoForm) throws CodigoNotFoundException {
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
			if(opC.isEmpty()) {
				throw new CodigoNotFoundException("Não foi encontrado uma categoria com o id " + id);
			}
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
		return "Produto atualizado com sucesso";
		
	}

	public String deletarProduto(Integer id) throws CodigoNotFoundException {
		Produto p = listarProdutoPorId(id);
		produtoRepository.delete(p);
		return "Produto deletado com sucesso!";
	}

	public List<Depoimento> listarDepoimentosDoProduto(Integer id) throws CodigoNotFoundException {
		Produto p = listarProdutoPorId(id);
		return depoimentoRepository.findAllByProduto(p);
	}
}

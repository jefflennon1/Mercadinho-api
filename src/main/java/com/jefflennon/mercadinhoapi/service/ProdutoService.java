package com.jefflennon.mercadinhoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jefflennon.mercadinhoapi.model.Produto;
import com.jefflennon.mercadinhoapi.repositoty.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> getTodos() {
		return repository.findAll();
	}
	
	public void salvar(Produto produto) throws Exception {
		validaCamposObrigatorios(produto);
		repository.save(produto);
	}

	private void validaCamposObrigatorios(Produto produto) throws Exception {
		if(produto.getCategoria() == null || produto.getNome() == null || produto.getPreco() <= 0) {
			throw new Exception("[ERROR] - Por favor verifique os campos obrigatórios e tente novamente!");
		}
	}
}

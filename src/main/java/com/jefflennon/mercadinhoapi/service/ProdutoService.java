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
		try {
			return repository.findAll();
		} catch (Exception e) {
			System.out.println("[error] "+e.getMessage());
		}
		return null;
	}
}

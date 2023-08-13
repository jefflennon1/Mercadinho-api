package com.jefflennon.mercadinhoapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jefflennon.mercadinhoapi.model.Produto;
import com.jefflennon.mercadinhoapi.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutosResouces {
	
	@Autowired
	private ProdutoService produtoService; 

	
	@GetMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> todos() {
		return produtoService.getTodos();
	}
	 
}

package com.jefflennon.mercadinhoapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jefflennon.mercadinhoapi.model.Produto;
import com.jefflennon.mercadinhoapi.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutosResouces {
	
	@Autowired
	private ProdutoService service; 

	@GetMapping(path = "/buscar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(@RequestParam("id") Long id) { 
		try { 
			Produto produto = service.getProduto(id);		
			return ResponseEntity.ok(produto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> todos() { 
		try { 
			List<Produto> produtos = service.getTodos();		
			return ResponseEntity.ok(produtos);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	 
	@PostMapping(path= "/salvar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salvar(@RequestBody Produto produto) {
		try {
			service.salvar(produto);
			URI location = URI.create(String.format("/produto?id=%s", produto.getId()));
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

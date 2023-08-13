package com.jefflennon.mercadinhoapi.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jefflennon.mercadinhoapi.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	 
}

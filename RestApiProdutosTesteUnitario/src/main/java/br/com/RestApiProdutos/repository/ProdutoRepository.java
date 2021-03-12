package br.com.RestApiProdutos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.RestApiProdutos.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

	
}

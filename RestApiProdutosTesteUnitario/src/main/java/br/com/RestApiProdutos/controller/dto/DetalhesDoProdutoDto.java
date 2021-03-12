package br.com.RestApiProdutos.controller.dto;

import java.math.BigDecimal;

import br.com.RestApiProdutos.model.Produto;

public class DetalhesDoProdutoDto {

	private long id;
	private String descricao;
	private BigDecimal valor;
	private Integer quantidade;
	
	public DetalhesDoProdutoDto (Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.valor = produto.getValor();
		this.quantidade = produto.getQuantidade();
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	
	
	
}

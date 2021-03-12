package br.com.RestApiProdutos.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.*;

import br.com.RestApiProdutos.model.Produto;
import br.com.RestApiProdutos.repository.ProdutoRepository;


public class atualizacaoProdutoForm {

	@NotNull @NotEmpty @NotBlank
	private String descricao;
	@NotNull @NotEmpty 
	private BigDecimal valor;
	@NotNull @NotEmpty  
	private Integer quantidade;
	
	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getOne(id);
		produto.setDescricao(this.descricao);
		produto.setValor(this.valor);
		
		return produto;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}

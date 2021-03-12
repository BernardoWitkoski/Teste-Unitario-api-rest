package br.com.RestApiProdutos.controller.form;

import java.math.BigDecimal;


import javax.validation.constraints.*;



public class ProdutoForm {

	@NotNull @NotEmpty @NotBlank
	private String descricao;
	@NotNull @NotEmpty
	private BigDecimal valor;
	@NotNull @NotEmpty
	private Integer quantidade;

	
	
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

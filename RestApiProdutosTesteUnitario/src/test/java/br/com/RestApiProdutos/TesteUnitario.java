package br.com.RestApiProdutos;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.RestApiProdutos.controller.ProdutoController;
import br.com.RestApiProdutos.controller.dto.ProdutoDto;

public class TesteUnitario {

	@Test
	void DeveriaListarTodosProdutos() {
		ProdutoController mock = 
				Mockito.mock(ProdutoController.class);
		List<ProdutoDto> todosProdutos = mock.listaProdutos();
		assertTrue(todosProdutos.isEmpty());
	}
}

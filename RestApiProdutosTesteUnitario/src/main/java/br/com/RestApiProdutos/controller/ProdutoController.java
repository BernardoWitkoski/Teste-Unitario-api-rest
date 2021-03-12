package br.com.RestApiProdutos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.RestApiProdutos.controller.dto.DetalhesDoProdutoDto;
import br.com.RestApiProdutos.controller.dto.ProdutoDto;
import br.com.RestApiProdutos.controller.form.atualizacaoProdutoForm;
import br.com.RestApiProdutos.model.Produto;
import br.com.RestApiProdutos.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	//GET todos os produtos
	@GetMapping("/produtos")
	@ApiOperation(value="Lista todos os produtos")
	public List<ProdutoDto> listaProdutos() {
		List<Produto> produtos = produtoRepository.findAll();
		return ProdutoDto.converter(produtos);
	}
	
	//GET produtos por id
		@GetMapping("/produtos/{id}")
		@ApiOperation(value="Retorna produto por ID")
		public ResponseEntity<DetalhesDoProdutoDto> listaProdutoPorId(@PathVariable long id) {
			Optional<Produto> produto = produtoRepository.findById(id);
			if(produto.isPresent()) {
				return ResponseEntity.ok(new DetalhesDoProdutoDto(produto.get()));
			}
			return ResponseEntity.notFound().build(); //404
	}
		
		
	//POST 
	@PostMapping("/produto")
	@ApiOperation(value="Cadastra um produto")
	@Transactional 
	public ResponseEntity<ProdutoDto> cadastraProduto(@Valid @RequestBody Produto produto, 
			UriComponentsBuilder uriBuilder) {
		produtoRepository.save(produto);
		
		URI uri = uriBuilder.path
				("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}
	
	
	//DELETE
	@DeleteMapping("/produtos/{id}")
	@ApiOperation(value="Deleta um produto")
	@Transactional
	public ResponseEntity deletaProduto(@Valid @PathVariable Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		if(optional.isPresent()) {
			produtoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build(); //404
	}
	
	//PUT
	@PutMapping("/produto/{id}")
	@ApiOperation(value="Atualiza um produto")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizaProduto
	(@Valid  @PathVariable Long id, @RequestBody atualizacaoProdutoForm form) {
		Optional<Produto> optional = produtoRepository.findById(id);
		if(optional.isPresent()) {
			Produto produto = form.atualizar(id, produtoRepository);
			return ResponseEntity.ok(new ProdutoDto(produto));
		}
		return ResponseEntity.notFound().build();
	}	
	
}

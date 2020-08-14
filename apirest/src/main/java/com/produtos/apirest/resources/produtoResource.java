package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.produtoRepository;

@RestController
@RequestMapping(value="/api")
public class produtoResource {
	
	@Autowired
	produtoRepository ProdutoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return ProdutoRepository.findAll();
	}
	@GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		return ProdutoRepository.findById(id);
	}
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto){
		return ProdutoRepository.save(produto);
	}

}

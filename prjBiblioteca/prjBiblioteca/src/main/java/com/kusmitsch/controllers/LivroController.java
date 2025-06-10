package com.kusmitsch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kusmitsch.entities.Livro;
import com.kusmitsch.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController{
	
private final LivroService livroService;
	
	@Autowired
	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}
	
	@PostMapping
	public Livro createLivro(@RequestBody Livro livro) {
		return livroService.saveLivro(livro);
	}
	
	@GetMapping
	public List<Livro> getAllLivros(){
		return livroService.getAllLivro();
	}
	
	@GetMapping("/{id}")
	public Livro getLivro (@PathVariable Long id) {
		return livroService.getLivroById(id);
		
	}
	@GetMapping("/busca/{nome}")
	public List<Livro> listarLivrosPorNome(@PathVariable String nome) {
	    return livroService.buscaPorNome(nome);
	}
	
}
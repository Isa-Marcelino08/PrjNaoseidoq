package com.kusmitsch.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kusmitsch.entities.Livro;
import com.kusmitsch.repositories.LivroRepositorio;

@Service
public class LivroService {
	private final LivroRepositorio  livroRepository;
	
	@Autowired
	public LivroService(LivroRepositorio livroRepository) {
		this.livroRepository = livroRepository;
		
	}
	
	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public 	Livro getLivroById(Long id) {
		return livroRepository.findById(id).orElse(null);
	}

	public List<Livro> getAllLivro(){
		return livroRepository.findAll();
	}

	public List<Livro> buscaPorNome(String nome){
		return livroRepository.buscarPorTitulo(nome);
	}
	
	
}
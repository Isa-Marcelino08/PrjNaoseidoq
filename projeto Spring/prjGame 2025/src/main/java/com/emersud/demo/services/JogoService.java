package com.emersud.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emersud.demo.entities.Jogo;
import com.emersud.demo.repositories.JogoRepository;

@Service
public class JogoService {
	
	private final JogoRepository jogoRepository;
	
	@Autowired
	public JogoService (JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
		
	}
	
	public Jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	
	public List<Jogo> getAllJogos(){
		return jogoRepository.findAll();
	}
	
	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}
	
	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}
	
	//agora vs se viram para o update
	
	public Jogo updateJogo(Long id, Jogo novoJogo) {
		Optional<Jogo> jogoOptional = jogoRepository.findById(id);		
		if(jogoOptional.isPresent()) {
			Jogo JogoExistente = jogoOptional.get();
			JogoExistente.setName(novoJogo.getName());
			JogoExistente.setPlatform(novoJogo.getPlatform());
			return jogoRepository.save(JogoExistente);			
			
		}else {
			return null;
		}
		
	}
	

}

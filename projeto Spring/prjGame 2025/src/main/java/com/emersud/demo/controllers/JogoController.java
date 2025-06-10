package com.emersud.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emersud.demo.entities.Jogo;
import com.emersud.demo.services.JogoService;

@RestController
@RequestMapping("/Jogos")
public class JogoController {
	
	private final JogoService jogoService;
	
	@Autowired
	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}
	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getJogo(@PathVariable Long id){
		Jogo jogo = jogoService.getJogoById(id);
		
		if (jogo !=null) {
			return ResponseEntity.ok(jogo);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public Jogo createJogo(@RequestBody Jogo jogo) {
		return jogoService.saveJogo(jogo);
	}
	
	@GetMapping
	public List<Jogo> getAllJogos (){
		return jogoService.getAllJogos();
	}
	
	@PutMapping("/{id}")
	public Jogo updateJogo(@PathVariable Long id,@RequestBody Jogo novojogo) {
		return jogoService.updateJogo(id, novojogo);
	}
	
	@DeleteMapping("/{id}")
	public void deleteJogo(@PathVariable Long id) {
		jogoService.deleteJogo(id);
	}
	
	
	
	
	
	

}

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Viagem;
import com.example.serviceImpl.ViagemServiceImpl;


@RestController
@RequestMapping("api/viagens")
public class ViagemController {
	
	@Autowired
	private ViagemServiceImpl service;
	
	
	@GetMapping
	public ResponseEntity<List<Viagem>> findAll() {
		List<Viagem> viagens = service.getAllViagens();
		return ResponseEntity.ok().body(viagens);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Viagem> getViagemById(@PathVariable("id") long ViagemId) {
		return new ResponseEntity<Viagem>(service.getViagemById(ViagemId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Viagem> saveViagem(@RequestBody Viagem viagem) {
		return new ResponseEntity<Viagem> (service.saveViagem (viagem), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Viagem> updateViagem(@PathVariable("id") long id, @RequestBody Viagem viagem) {
		return new ResponseEntity<Viagem> (service.updateViagem(viagem, id), HttpStatus.OK); 
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteViagem(@PathVariable("id") long id) {
		service.deleteViagem(id);
		
		return new ResponseEntity<String>("Viagem deletado com sucesso.", HttpStatus.OK);
	}

}

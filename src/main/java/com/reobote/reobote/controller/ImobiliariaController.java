package com.reobote.reobote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.reobote.reobote.domain.Imobiliaria;
import com.reobote.reobote.dto.ImobiliariaDto;

import com.reobote.reobote.service.ImobiliariaService;




import java.util.List;


@RestController
@RequestMapping("/imobiliarias")
public class ImobiliariaController {


	// O Spring precisa do construtor
	// Ou do @Autowired
	// Mas uma boa prática é sempre colocar um construtor


	@Autowired
	private ImobiliariaService imobialiariaService;



	//Get e Post  
	@GetMapping //lista  ALL Imobiliaria e imovel  
	public ResponseEntity<List<Imobiliaria>> findAll() { // Corrigir. 
		return ResponseEntity.ok(this.imobialiariaService.findAll());
	} 


	@GetMapping("{cnpj}")// Busca imobiliaria  pelo CNPJ  
	public ResponseEntity<ImobiliariaDto> findById(@PathVariable (value="cnpj") String cnpj) {
		ImobiliariaDto dto = this.imobialiariaService.findOne(cnpj);
		return ResponseEntity.ok(dto);



	}    

	@PostMapping("/cadastra")//Cadastro de imobiliaria  
	public Imobiliaria create(@RequestBody ImobiliariaDto dto) {
		return imobialiariaService.save(dto);
	}
}

package com.reobote.reobote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.reobote.reobote.dto.ImovelDto;

import com.reobote.reobote.service.ImovelService;


@RestController
@RequestMapping("/imovel")

public class ImovelController {

	//@Autowired
	private ImovelService imovelservice;  



	//Contrutoro 
	public ImovelController (ImovelService imovelservice ) {
		this.imovelservice = imovelservice;
	}



	@PostMapping("/{cnpj}")// Post -  Cadastra Imobiliaria pelo CPNPJ
	public ResponseEntity<ImovelDto> addImovel(@PathVariable("cnpj") String cnpj,@RequestBody ImovelDto dto){
		this.imovelservice.addImovel(dto,cnpj );
		return ResponseEntity.ok(dto);
	}



	//Ajustar. 
	@GetMapping("{cnpj}")// Busca imobiliaria  pelo CNPJ  
	public ResponseEntity<ImovelDto> findById(@PathVariable (value="cnpj") String cnpj,@RequestParam("contractCode") String contractCode) {
		//return ResponseEntity.ok(this.imovelRepository.listImovel(cnpj,contractCode));
		return ResponseEntity.ok(this.imovelservice.findOne(cnpj, contractCode));

	}       


	//Teste 2 
	//@GetMapping(path = {"/{contractCode}"})
	//public ResponseEntity findById(@PathVariable String contractCode){
	//   return ResponseEntity.ok(contractCode);
	//}



}

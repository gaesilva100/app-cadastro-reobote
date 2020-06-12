package com.reobote.reobote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reobote.reobote.domain.Imobiliaria;
import com.reobote.reobote.dto.ImobiliariaDto;
import com.reobote.reobote.dto.ImobiliariaFactory;
import com.reobote.reobote.repository.ImobiliariaRepository;

@Service
public class ImobiliariaService {
	
	private ImobiliariaRepository imobiliariaRepository;
	private ImobiliariaFactory imobiliariaFactory;
	
	public ImobiliariaService(ImobiliariaRepository imobiliariaRepository, ImobiliariaFactory imobialiariaFactory) {
		this.imobiliariaRepository = imobiliariaRepository;
		this.imobiliariaFactory = imobialiariaFactory;
	}
	
	
	
	public Imobiliaria save(ImobiliariaDto imobiliariaDto){
		Imobiliaria imobiliaria = imobiliariaFactory.create(imobiliariaDto);
		return this.imobiliariaRepository.save(imobiliaria);  // DTO  " boas Patricas. )
	}
	
	// Repository - correto seria pelo factory.  
	public List<Imobiliaria> findAll(){
		return this.imobiliariaRepository.findAll();
	}
	
	
	public ImobiliariaDto findOne (String cnpj) {
		
		Imobiliaria imobialiara = this.imobiliariaRepository.findByCnpj(cnpj);
		ImobiliariaDto dto = imobiliariaFactory.parse(imobialiara);
		return dto;
	} 


}

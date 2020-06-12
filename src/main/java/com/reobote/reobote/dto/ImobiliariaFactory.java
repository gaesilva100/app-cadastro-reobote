package com.reobote.reobote.dto;
import org.springframework.stereotype.Service;

import com.reobote.reobote.domain.Imobiliaria;

@Service
public class ImobiliariaFactory {
	
	
	//Cadastra Usando o Padrão DTO 
	public Imobiliaria create (ImobiliariaDto dto) {
		Imobiliaria imobiliaria = new Imobiliaria();
		imobiliaria.setTradingName(dto.getTradingName());
		imobiliaria.setTelephone(dto.getTelephone());
		imobiliaria.setCompanyName(dto.getCompanyName());
		imobiliaria.setCnpj(dto.getCnpj());
		return imobiliaria;
				
	}
	
	// Busca utilizando o padrão DTO 
	public ImobiliariaDto parse  (Imobiliaria imobiliaria) {
		ImobiliariaDto dto = new ImobiliariaDto();
		dto.setTradingName(imobiliaria.getTradingName());
		dto.setTelephone(imobiliaria.getTelephone());
		dto.setTradingName(imobiliaria.getTradingName());
		dto.setCnpj(dto.getCnpj());
		return dto;
		
	}
	
	//Teste 1 
	public ImobiliariaDto all (Imobiliaria imobiliaria) {
		ImobiliariaDto dto = new ImobiliariaDto();
		return dto; 
	}

	
	

}

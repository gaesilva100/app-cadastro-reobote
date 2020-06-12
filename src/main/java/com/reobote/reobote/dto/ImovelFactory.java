package com.reobote.reobote.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.reobote.reobote.domain.Imovel;

@Service
public class ImovelFactory {

	//Cadastro usando o padrão DTO 
	public Imovel create (ImovelDto dto){
		//create recebe um imovelDTO > e retorna um imovel. 
		Imovel imovel = new Imovel(); 
		imovel.setAddress(dto.getAddress());
		imovel.setContractCode(dto.getContractCode());
		imovel.setImages(new ArrayList<>());
		return imovel;

	}
	//Busca utilizando o padrão DTO 
	public ImovelDto parse (Imovel imovel) {
		ImovelDto dto = new ImovelDto();
		dto.setContractCode(imovel.getContractCode());
		dto.setAddress(imovel.getAddress());
		return dto;
	}






}

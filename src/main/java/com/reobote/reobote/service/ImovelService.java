package com.reobote.reobote.service;



import org.springframework.stereotype.Service;


import com.reobote.reobote.domain.Imovel;

import com.reobote.reobote.dto.ImovelDto;
import com.reobote.reobote.dto.ImovelFactory;
import com.reobote.reobote.repository.ImobiliariaRepository;
import com.reobote.reobote.repository.ImovelRepository;



@Service
public class ImovelService {


	
	private  ImovelFactory imovelFactory;
	private  ImovelRepository imovelRepository;


	// o spring indentifica que o imobi e um componete do Spring   @Autowired  Não precisa .
	// public ImovelService (final ImobiariaRepository imobiariaRepository,ImovelFactory imovelFactory){ // Nome do Construtor deve ser o nome da Classe.
	//     this.imobiariaRepository = imobiariaRepository;
	//     this.imovelFactory = imovelFactory;
	// }

	public ImovelService(ImobiliariaRepository imobiliariaRepository, ImovelFactory imovelFactory,ImovelRepository imovelRepository) {
		//this.imobiliariaRepository = imobiliariaRepository;
		this.imovelFactory = imovelFactory;
		this.imovelRepository = imovelRepository;
	}


	public Imovel addImovel(ImovelDto dto,String cnpj) {
		Imovel imovel = this.imovelFactory.create(dto);
		this.imovelRepository.addImovel(cnpj, imovel);
		return imovel;

	}


	public ImovelDto findOne (String cnpj,String contractCode ) {

		Imovel imovel =this.imovelRepository.listImovel(cnpj,contractCode);
		ImovelDto dto = imovelFactory.parse(imovel);
		return dto;
	} 




}


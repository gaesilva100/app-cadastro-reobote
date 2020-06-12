package com.reobote.reobote.repository;



import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.reobote.reobote.domain.Imobiliaria;
import com.reobote.reobote.domain.Imovel;

@Repository 
public class ImovelRepository {

	private MongoTemplate mongotemplate;

	public ImovelRepository(MongoTemplate mongotemplate) {
		this.mongotemplate = mongotemplate;
	}


	public void addImovel(String cnpj,Imovel imovel) {
		Query  query = new Query(Criteria.where("cnpj").is(cnpj));
		Update update =new Update().addToSet("buildings",imovel);
		//Tentativa//log.info(mongoOps.findOne(new Query(where("name").is("Joe")), Person.class))
		this.mongotemplate.updateFirst(query, update , Imobiliaria.class);
	}


	//lista usando o contract code 
	public Imovel listImovel(String cnpj,String contractCode) {
		Query  query = new Query(Criteria.where("cnpj").is(cnpj).and("buildings.contractCode").is(contractCode));
		Imobiliaria imobiliaria = mongotemplate.findOne(query, Imobiliaria.class);
		// 14/05 - pq o meu Debug não funciona ?  Stenio  
		return imobiliaria.getBuildings() // Metodo get 
				.stream() // Sequencial  >> 
				.filter(mv->contractCode.equals(mv.getContractCode())) // filtrar as imobiliarias que tem o numero de contrato = ao que eu estou passando 
				.findFirst() //  Pega o primeiro que ele Filtrou. 
				.orElse(null); // Caso o retorno seja negativo ele retorna nulo


	}


}

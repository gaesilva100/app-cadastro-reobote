package com.reobote.reobote.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.reobote.reobote.domain.Imobiliaria;


import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
@Repository 
public class ImgRepository {
	
	//Creat by : Gabriel Erick 
	// 15/05
	
  private MongoTemplate mongotemplate;
  public ImgRepository (MongoTemplate mongotemplate) {
	  this.mongotemplate = mongotemplate;
  }
  
  //
  public void addImg(String cnpj,String contractcode,String image) {
	  Query query = new Query (Criteria.where("cnpj").is(cnpj).and("buildings.contractCode").is(contractcode));
	  Update update =new Update().addToSet("buildings",image);
	  this.mongotemplate.updateFirst(query, update, Imobiliaria.class);
	  
	  
  }
 
  
  
}

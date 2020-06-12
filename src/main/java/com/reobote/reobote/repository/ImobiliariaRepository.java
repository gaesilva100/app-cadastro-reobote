package com.reobote.reobote.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.reobote.reobote.domain.Imobiliaria;

@Repository
public interface ImobiliariaRepository extends MongoRepository<Imobiliaria,Long> {

     Imobiliaria findByCnpj(String cnpj); //Consulta banco.
     //Imobiliaria findByImovel(String contractCode);
    
     
  
     
}

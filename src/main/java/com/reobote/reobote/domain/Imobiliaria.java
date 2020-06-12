package com.reobote.reobote.domain;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "imobiliarias")
public class Imobiliaria {

    @Id
    private String id;
    private String tradingName;
    private String companyName;
    private String cnpj;
    private String telephone;
    private List<Imovel> buildings;
 
    

	


    public List<Imovel> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Imovel> buildings) {
		this.buildings = buildings;
	}

	public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}



package com.reobote.reobote.domain;

import java.util.List;

public class Imovel {
	
	
	private String contractCode;
	private Address address; 
	private List<Image> images ;
	
	
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}

	
}

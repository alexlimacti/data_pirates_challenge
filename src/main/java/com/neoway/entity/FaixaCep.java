package com.neoway.entity;

public class FaixaCep {

	public String localidade;
	public String faixaCep;

	public FaixaCep(String localidade, String faixaCep) {
		this.localidade = localidade;
		this.faixaCep = faixaCep;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getFaixaCep() {
		return faixaCep;
	}

	public void setFaixaCep(String faixaCep) {
		this.faixaCep = faixaCep;
	}

}

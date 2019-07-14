package com.neoway.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.neoway.entity.FaixaCep;

public class FaixaCepRepository {

	public void save(List<FaixaCep> faixasCep) {
		try {
			FileWriter writeFile = new FileWriter("faixacep.json");
			writeFile.write(converterParaJson(faixasCep));
            writeFile.close();
		} catch (IOException e) {
			System.out.println("Error generating file");
		}
	}
	
	public String converterParaJson(List<FaixaCep> list) {
	    Gson gson = new Gson();
	    StringBuilder stringBuilder = new StringBuilder();
	    for(FaixaCep faixaCep : list)
	        stringBuilder.append(gson.toJson(faixaCep));
	    return stringBuilder.toString();
	}

}

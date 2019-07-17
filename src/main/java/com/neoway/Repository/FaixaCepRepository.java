package com.neoway.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.neoway.entity.FaixaCep;

public class FaixaCepRepository {

	public static final String JSON = "faixacep.json";

	public void save(List<FaixaCep> faixasCep) {
		try {

			FileWriter writeFile = new FileWriter(JSON, false);
			writeFile.write(new Gson().toJson(faixasCep));
			writeFile.close();
			System.out.println("Finally! Generated file: " + new File(JSON).getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Error generating file");
		}
	}

}

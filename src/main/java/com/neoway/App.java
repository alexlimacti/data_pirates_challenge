package com.neoway;

import java.util.ArrayList;
import java.util.List;

import com.neoway.servico.FaixaCepServico;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Initializing...");
		List<String>ufs = new ArrayList<String>();
		ufs.add("SC");
		ufs.add("SP");
		FaixaCepServico fcs = new FaixaCepServico();
		fcs.getFaixaCep(ufs);
	}
}

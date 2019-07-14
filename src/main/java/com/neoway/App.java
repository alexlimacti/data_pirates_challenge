package com.neoway;

import com.neoway.servico.FaixaCepServico;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		

		FaixaCepServico fcs = new FaixaCepServico();
		//FaixaCepRepository fcr = new FaixaCepRepository();
		fcs.getFaixaCep("BA");
	
		
		
	}
}

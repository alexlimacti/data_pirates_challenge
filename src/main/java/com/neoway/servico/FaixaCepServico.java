package com.neoway.servico;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FaixaCepServico {
	public static final String CORREIOS_CHARSET = "ISO-8859-1";
	List<NameValuePair> postParams;

	public FaixaCepServico() {
	}

	public void getFaixaCep(String uf) throws Exception {
		Connection conexao = Jsoup
				.connect("http://www.buscacep.correios.com.br/sistemas/buscacep/resultadoBuscaFaixaCEP.cfm");
		conexao.data("UF", uf);
		conexao.data("Localidade", "");

		Document documento = null;
		try {
			documento = Jsoup.parse(new String(conexao.method(Method.POST).execute().bodyAsBytes(),
					FaixaCepServico.CORREIOS_CHARSET));
		} catch (Exception e) {
			System.out.println("Falha ao localizar faixas do estado " + uf);
			return;
		}

		if (documento == null || documento.select("table.tmptabela").isEmpty()) {
			return;
		}
		for (Element tr : documento.select("table.tmptabela tr")) {
			if (tr.select("td").isEmpty()) {
				continue;
			}
			System.out.println(tr.select("td").text());
		}
	}

	public List<NameValuePair> getInputParams(String uf) throws UnsupportedEncodingException {
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		paramList.add(new BasicNameValuePair("Localidade", ""));
		paramList.add(new BasicNameValuePair("UF", uf));
		return paramList;
	}

}

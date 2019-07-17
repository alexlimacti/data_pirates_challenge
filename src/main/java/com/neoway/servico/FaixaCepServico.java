package com.neoway.servico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;

import com.neoway.Repository.FaixaCepRepository;
import com.neoway.entity.FaixaCep;

public class FaixaCepServico {
	public static final String CORREIOS_CHARSET = "ISO-8859-1";
	List<NameValuePair> postParams;

	public void getFaixaCep(List<String> ufs) throws Exception {

		System.out.println("Connecting...");
		List<FaixaCep> faixas = new ArrayList<FaixaCep>();
		for (String uf : ufs) {
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

			System.out.println("Please wait a moment, Data Collecting: " + uf);

			while (documento != null || !documento.select("table.tmptabela").isEmpty()) {
				for (Element tr : documento.select("table.tmptabela tr")) {
					if (tr.select("td").isEmpty()) {
						continue;
					}
					if (!tr.select("td").get(0).text().equals(uf)) {
						faixas.add(new FaixaCep(tr.select("td").get(0).text(), tr.select("td").get(1).text()));
					}
				}
				Connection.Response res;
				try {
					FormElement form = documento.select("[name=Proxima]").forms().get(0);
					Connection post = form.submit();

					res = post.execute();
				} catch (Exception e) {
					break;
				}

				documento = res.parse();
			}
		}
		System.out.println("Please wait a moment, Json Generating...");

		FaixaCepRepository repositorio = new FaixaCepRepository();
		repositorio.save(faixas);
	}

	public void imprimirJson() {
		try {
			String json = new String(Files.readAllBytes(Paths.get(FaixaCepRepository.JSON)));
			json = json.replace("[{", "[\n {\n    ");
			json = json.replace("]", "\n]");
			json = json.replace(",{", ",\n {\n    ");
			json = json.replace("}", "\n }");
			json = json.replace(",", ",\n    ");
			System.out.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

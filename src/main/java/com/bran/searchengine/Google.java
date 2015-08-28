package com.bran.searchengine;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Google implements SearchEngine {

	private final String URL = "https://www.google.com/search?q=";
	private final String NAME = "Google";

	@Override
	public String getSearchEngineName() {
		return NAME;
	}

	@Override
	public SearchResultGroup getSearchResults(String query) {
		Document doc;
		SearchResultGroup srg = new SearchResultGroup();
		srg.setSearchEngineName(getSearchEngineName());
		try {
			doc = Jsoup
					.connect(URL + query)
					.timeout(5000)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
					.ignoreHttpErrors(true).get();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		Elements results = doc.getElementsByClass("rc");

		for (int i = 0; i < results.size(); i++) {
			Element e = results.get(i);
			SearchResult result = new SearchResult();
			result.setUrl(e.getElementsByTag("a").first().attr("href"));
			result.setTitle(e.getElementsByTag("a").first().text());
			result.setDescription(e.getElementsByClass("st").first().text());

			srg.addSearchResult(result);
		}

		return srg;
	}

}

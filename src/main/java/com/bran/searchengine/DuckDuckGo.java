package com.bran.searchengine;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DuckDuckGo implements SearchEngine {

	private final String URL = "https://duckduckgo.com/html/?q=";
	private final String NAME = "DuckDuckGo";

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
		Elements results = doc.getElementById("links").getElementsByClass("results_links");

		for (int i = 0; i < results.size(); i++) {
			Element e = results.get(i);
			SearchResult sr = new SearchResult();
			sr.setUrl(e.getElementsByClass("links_main").first().getElementsByTag("a").first().attr("href"));
			sr.setTitle(e.getElementsByClass("links_main").first().getElementsByTag("a").first().text());
			sr.setDescription(e.getElementsByClass("snippet").first().text());
			srg.addSearchResult(sr);
		}

		return srg;
	}
}

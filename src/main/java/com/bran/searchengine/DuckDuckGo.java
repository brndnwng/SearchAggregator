package com.bran.searchengine;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bran.searchengine.models.SearchResult;

public class DuckDuckGo extends SearchEngine {

	public DuckDuckGo() {
		URL = "https://duckduckgo.com/html/?q=";
		NAME = "DuckDuckGo";
	}

	@Override
	protected List<SearchResult> parseResults(Document doc) {
		Elements results = doc.getElementById("links").getElementsByClass("results_links");
		List<SearchResult> resultsList = new ArrayList<>();
		for (int i = 0; i < results.size(); i++) {
			Element e = results.get(i);
			SearchResult sr = new SearchResult();

			Element title = e.getElementsByClass("links_main").first().getElementsByTag("a").first();
			sr.setUrl(title.attr("href"));
			sr.setTitle(title.text());

			sr.setDescription(e.getElementsByClass("snippet").first().text());

			resultsList.add(sr);
		}
		return resultsList;
	}
}

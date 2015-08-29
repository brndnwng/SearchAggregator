package com.bran.searchengine;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bran.searchengine.models.SearchResult;

public class Bing extends SearchEngine {

	public Bing() {
		URL = "http://www.bing.com/search?q=";
		NAME = "Bing";
	}

	@Override
	protected List<SearchResult> parseResults(Document doc) {
		Elements results = doc.select("li[class=b_algo]");

		List<SearchResult> resultsList = new ArrayList<>();
		for (int i = 0; i < results.size(); i++) {
			Element e = results.get(i);
			SearchResult sr = new SearchResult();

			Element title = e.getElementsByTag("a").first();
			sr.setUrl(title.attr("href"));
			sr.setTitle(title.text());

			sr.setDescription(e.getElementsByClass("b_caption").first().getElementsByTag("p").first().text());

			resultsList.add(sr);
		}
		return resultsList;
	}

}

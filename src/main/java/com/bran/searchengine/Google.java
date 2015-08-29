package com.bran.searchengine;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bran.searchengine.models.SearchResult;

public class Google extends SearchEngine {

	public Google() {
		URL = "https://www.google.com/search?q=";
		NAME = "Google";
	}

	@Override
	protected List<SearchResult> parseResults(Document doc) {
		Elements results = doc.getElementsByClass("rc");

		List<SearchResult> resultList = new ArrayList<>();
		for (int i = 0; i < results.size(); i++) {
			Element e = results.get(i);
			SearchResult result = new SearchResult();

			Element title = e.getElementsByTag("a").first();
			result.setUrl(title.attr("href"));
			result.setTitle(title.text());

			result.setDescription(e.getElementsByClass("st").first().text());
			resultList.add(result);
		}
		return resultList;
	}

}

package com.bran.searchengine;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;

import com.bran.searchengine.models.SearchResult;
import com.bran.searchengine.models.SearchResultGroup;
import com.bran.utils.JsoupUtils;
/**
 * Implementations of this class can be passed into the SearchAggregator.
 * 
 * Implementations should override parseResults which should be the code used to parse the actual search engine page
 * @author bwong
 *
 */
public abstract class SearchEngine {

	protected String URL = "http://change.this.placeholder";
	protected String NAME = "SearchEngine";

	public String getSearchEngineName() {
		return NAME;
	}

	public SearchResultGroup getSearchResults(String query) {
		if (StringUtils.isEmpty(query)) return null;
		SearchResultGroup srg = new SearchResultGroup();
		srg.setSearchEngineName(getSearchEngineName());

		try {
			srg.setSearchResults(parseResults(JsoupUtils.getDocument(URL + URLEncoder.encode(query, "UTF-8"))));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}

		return srg;
	}

	protected abstract List<SearchResult> parseResults(Document doc);

}

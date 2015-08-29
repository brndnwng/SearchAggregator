package com.bran.search.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bran.searchengine.SearchEngine;
import com.bran.searchengine.models.SearchResultGroup;

/**
 * Simple aggregator which calls all the search engines and combines them into a list
 * 
 * @author bwong
 *
 */
public class SearchAggregator {

	private final List<SearchEngine> searchEngines = new ArrayList<SearchEngine>();

	public SearchAggregator(SearchEngine... engines) {
		for (int i = 0; i < engines.length; i++) {
			searchEngines.add(engines[i]);
		}
	}

	public List<SearchEngine> getSearchEngines() {
		return searchEngines;
	}

	public void addSearchEngine(SearchEngine se) {
		this.searchEngines.add(se);
	}

	public List<SearchResultGroup> getSearchResults(String query) {
		return searchEngines.parallelStream().map((engine) -> engine.getSearchResults(query))
				.collect(Collectors.toList());
	}
}

package com.bran.searchengine.models;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class SearchResultGroup {
	private String searchEngineName = StringUtils.EMPTY;
	private List<SearchResult> searchResults;

	public SearchResultGroup() {
		this.searchResults = new ArrayList<>();
	}

	public String getSearchEngineName() {
		return searchEngineName;
	}

	public void setSearchEngineName(String searchEngineName) {
		this.searchEngineName = searchEngineName;
	}

	public List<SearchResult> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<SearchResult> searchResults) {
		this.searchResults = searchResults;
	}

	public void addSearchResult(SearchResult result) {
		this.searchResults.add(result);
	}
}

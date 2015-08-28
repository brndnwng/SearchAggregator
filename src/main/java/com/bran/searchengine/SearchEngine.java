package com.bran.searchengine;

public interface SearchEngine {

	public String getSearchEngineName();

	public SearchResultGroup getSearchResults(String query);

}

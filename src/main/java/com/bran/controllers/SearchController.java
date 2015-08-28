package com.bran.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bran.searchengine.SearchAggregator;
import com.bran.searchengine.SearchResultGroup;

@RestController
public class SearchController {

	private final SearchAggregator searchAggregator;

	@Autowired
	public SearchController(SearchAggregator searchAggregator) {
		this.searchAggregator = searchAggregator;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, value = "/")
	@ResponseBody
	public List<SearchResultGroup> index(@RequestParam(value = "query", required = true) String query) {
		return searchAggregator.getSearchResults(query);
	}
}

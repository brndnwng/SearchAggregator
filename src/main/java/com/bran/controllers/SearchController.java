package com.bran.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bran.search.service.SearchAggregator;
import com.bran.searchengine.models.SearchResultGroup;

@RestController
public class SearchController {

	private final SearchAggregator searchAggregator;

	@Autowired
	public SearchController(SearchAggregator searchAggregator) {
		this.searchAggregator = searchAggregator;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, value = "/search")
	@ResponseBody
	public List<SearchResultGroup> index(@RequestParam(value = "query", required = true) String query) {
		if (StringUtils.isEmpty(query)) throw new IllegalArgumentException("Missing or empty param: query");
		return searchAggregator.getSearchResults(query);
	}

	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}

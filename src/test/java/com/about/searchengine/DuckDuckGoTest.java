package com.about.searchengine;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.bran.searchengine.DuckDuckGo;
import com.bran.searchengine.models.SearchResultGroup;

public class DuckDuckGoTest {
	@Test
	public void ddg_test() {
		DuckDuckGo b = new DuckDuckGo();
		SearchResultGroup srg = b.getSearchResults("brandon%20wong");
		assertFalse(srg.getSearchResults().isEmpty());
	}
}

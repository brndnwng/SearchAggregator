package com.about.searchengine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bran.searchengine.Bing;
import com.bran.searchengine.models.SearchResultGroup;

public class BingTest {

	@Test
	public void bing_test() {
		Bing b = new Bing();
		SearchResultGroup srg = b.getSearchResults("brandon%20wong");
		assertFalse(srg.getSearchResults().isEmpty());
	}

	@Test
	public void emptyParam() {
		Bing b = new Bing();
		SearchResultGroup srg = b.getSearchResults("");
		assertTrue(srg == null);
	}

	@Test
	public void testEncode() {
		Bing b = new Bing();
		SearchResultGroup srg = b.getSearchResults("brandon wong");
		assertFalse(srg.getSearchResults().isEmpty());
	}
}

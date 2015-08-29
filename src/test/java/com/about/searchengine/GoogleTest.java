package com.about.searchengine;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.bran.searchengine.Google;
import com.bran.searchengine.models.SearchResultGroup;

public class GoogleTest {
	@Test
	public void google_test() {
		Google b = new Google();
		SearchResultGroup srg = b.getSearchResults("brandon%20wong");
		assertFalse(srg.getSearchResults().isEmpty());
	}
}

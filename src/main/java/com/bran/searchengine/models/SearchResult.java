package com.bran.searchengine.models;

import org.apache.commons.lang3.StringUtils;

public class SearchResult {

	private String url = StringUtils.EMPTY;
	private String title = StringUtils.EMPTY;
	private String description = StringUtils.EMPTY;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package com.bran.application;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.bran.searchengine.Bing;
import com.bran.searchengine.DuckDuckGo;
import com.bran.searchengine.Google;
import com.bran.searchengine.SearchAggregator;

@SpringBootApplication
@ComponentScan("com.bran.controllers")
public class Application {

	@Bean
	public Google google() {
		return new Google();
	}

	@Bean
	public DuckDuckGo duckduckgo() {
		return new DuckDuckGo();
	}

	@Bean
	public Bing bing() {
		return new Bing();
	}

	@Bean
	public SearchAggregator searchAggregator() {
		return new SearchAggregator(google(),duckduckgo(), bing());
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

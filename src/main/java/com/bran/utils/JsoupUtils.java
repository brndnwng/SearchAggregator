package com.bran.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupUtils {
	
	public static Document getDocument(String url){
		Document doc;
		try {
			doc = Jsoup
					.connect(url)
					.timeout(5000)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
					.ignoreHttpErrors(true).get();
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		return doc;
	}

}

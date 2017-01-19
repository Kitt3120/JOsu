package me.kitt3120.josu.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	public static void showPlainWebsite(String link) throws IOException{
		StringBuilder stringBuilder = new StringBuilder();
		URL url = new URL(link);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
		conn.setRequestProperty("X-HTTP-Method-Override", "GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			stringBuilder.append(inputLine);
		}
		in.close();
		System.out.println(decodeNumericEntities(stringBuilder.toString()));
	}

	public static String getStringFromWebsite(String link) throws MalformedURLException, IOException{
		StringBuilder stringBuilder = new StringBuilder();
		URL url = new URL(link);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.155 Safari/537.36");
		conn.setRequestProperty("X-HTTP-Method-Override", "GET");
		conn.setRequestProperty("Accept-Charset", "UTF-8");
		conn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			stringBuilder.append(inputLine);
		}
		in.close();
		return stringBuilder.toString();
	}
	
	public static String getStringFromWebsite(URL url) throws MalformedURLException, IOException{
		StringBuilder stringBuilder = new StringBuilder();
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.155 Safari/537.36");
		conn.setRequestProperty("X-HTTP-Method-Override", "GET");
		conn.setRequestProperty("Accept-Charset", "UTF-8");
		conn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			stringBuilder.append(inputLine);
		}
		in.close();
		return stringBuilder.toString();
	}
	
	public static boolean containsWord(String text, String word){
		boolean contains = false;
		for(String s : text.split(" ")){
			if(s.equalsIgnoreCase(word)) contains = true;
		}
		return contains;
	}
	
	public static String decodeNumericEntities(String s) {
	    StringBuffer sb = new StringBuffer();
	    Matcher m = Pattern.compile("\\&#(\\d+);").matcher(s);
	    while (m.find()) {
	        int uc = Integer.parseInt(m.group(1));
	        m.appendReplacement(sb, "");
	        sb.appendCodePoint(uc);
	    }
	    m.appendTail(sb);
	    return sb.toString();
	}

}

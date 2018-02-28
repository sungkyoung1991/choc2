package com.sample.choc2.common;


import java.net.URLEncoder;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class CrawlingJsoup {




	/*
	 * 2018.02.21 show3rg@gmail.com 
	 * 
	 * class에 들어간 라이브러리는 JSoup
	 * JSoup은 필요한 데이터를 크롤링 하기 위한 라이브러리 
	 * 
	 * 예제는 헤라 오피셜사이트를 기준으로 제작
	 * 
	 * 실행순서는 
	 * 파라미터에서 받는 모델 이름으로 검색 > 모델명에 대한 검색 결과 도출 > 
	 * 모델 상세정보에 접근 > JSoup를 이용하여 데이터 크롤링 > 크롤링한 데이터를 파싱하여 원하는 형태로 가공 
	 * 
	 */
	public void CrawlingParser()throws Exception{
		/*
		 * Jsoup.connect() : 파싱할 웹 사이트 URL을 입력해 파싱 데이터가 Document 형태로 반환된다.
		 * target에 크롤링 데이터를 삽입하여 파싱 
		 */
		String param="로지사틴";
		Document doc = Jsoup.connect("https://www.hera.com/kr/ko/misc/search.html?_charset_=UTF-8&q="+param).get();
		Elements link = doc.select("section.search-section");
		link = doc.select("ul.search-list li a");
		
		String target = link.toString();
		
		if(target != null) {
			if(target.contains("href")) {
				
				target = target.split("href=\"")[1].split("\"")[0];
				System.out.println(target);
				
			}else {
				System.out.println("a tag 주소가 없는데용?");
			}
		}
		Document docDetail = Jsoup.connect(target).get();
		
		Elements ingredients = docDetail.select("div.additional");
		String targetDetail = ingredients.toString();
		
		if(targetDetail != null) {
			targetDetail = targetDetail.split("주요 성분<span class=\"a11y\">펼치기/접기</span></button> \n" + 
					"   <div class=\"a\">\n" + 
					"    ")[1].split("</div> </li>")[0];
			System.out.println(targetDetail);
			String[] targetArray = targetDetail.split(", ");
			
					
			for(String i: targetArray) {
				System.out.println("성분 : "+i+"\n");
			}
		}
		
		/*

		for(Element e: link){
			System.out.println("[ title : " + e.toString()+"] \n");
			System.out.println("------------------------------------------------------------");
		}
		

		/*
		 * 문서로부터 html  tag 를 모두 제거 하고 순수 문자열만 얻고자 할 때는 String text = doc.text(); 사용
		 * 문서 전체가 필요하다면 doc.toString()을 사용 
		 */		



	}
	
	
}

package com.sample.choc2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.sample.choc2.common.domain.CrawlingVO;


//JUnit 테스트 클래스를 실행시킬 환경(클래스)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/config/*.xml"})
public class CrawlingTest {
	private WebDriver driver;

    //xPath
    String xpathClick = "//*[@id=\"buyInfo\"]/a";
    String xpathBrand = "//p[@class=\"prd_brand\"]";
    String xpathPrdName = "//*[@class=\"prd_info\"]/*[@class=\"prd_name\"]";
    String xpathPrice = "//*[@class=\"prd_info\"]/ul/li/span[@class=\"tx_cont cur_price\"]/span[@class=\"tx_num\"]";
    String xpathImage = "//div[@class=\"prd_detail_box\"]/div[@class=\"left_area\"]/div[@class=\"prd_img\"]/img";
    LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
    CrawlingVO crawlingVO = new CrawlingVO();
	@Before
    public void setUp(){
	    	System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver"); // 다운받은 ChromeDriver 위치를 넣어줍니다.
        driver = new ChromeDriver(); // Driver 생성   
    }

	@After
	public void tearDown() {
		driver.quit(); // Driver 종료
	}

	@Test
	public void test_crawling() { // 타이틀 확인하는 테스트 코드
		//driver.get("http://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000014447&dispCatNo=1000001000100010001"); // URL로 접속하기
		
		// xPath로 경로 접근하여 크롤링하기 
		driver.get("http://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000014447&dispCatNo=1000001000100010001"); // URL로 접속하기
		String brand = driver.findElement(By.xpath(xpathBrand)).getText();
		System.out.println(brand.split("브랜드")[0]);
		
		String prdName = driver.findElement(By.xpath(xpathPrdName)).getText();
		System.out.println(prdName);
		
		String price = driver.findElement(By.xpath(xpathPrice)).getText();
		System.out.println(price);
		
		WebElement image = driver.findElement(By.xpath(xpathImage));
		System.out.println(image.getAttribute("src").toString());
		
		
		driver.findElement(By.xpath(xpathClick)).click();
		
		for(int i=1; i<= 9; i++) {
			String index = String.valueOf(i);
			String xpathList = "//*[@id=\"artcInfo\"]/dl[" +index + "]/dd";
			String infoData = driver.findElement(By.xpath(xpathList)).getText();
			if(infoData.contains("■")) {
				infoData = infoData.split("■")[1];
			}
			System.out.println(infoData);
		}
		


	}
}

/* 클래스이름으로 Element 가져오기
WebElement buyinfo = driver.findElement(By.className("goods_buyinfo")); 
buyinfo.click();

List<WebElement> column = driver.findElements(By.className("detail_info_list"));


System.out.println("===========================================================");
// <key : value>에 담는다. 
for(int i=0;i<=8;i++) {
	String keyName="cosmetic"+i;
	map.put(keyName, column.get(i).getText());
}
for(int i=0;i<=8;i++) {
	if(map.get("cosmetic"+i)==map.get("cosmetic6")) {
		map.put("cosmetic6", map.get("cosmetic6").replaceAll(" ",""));
		map.put("cosmetic6", map.get("cosmetic6").replaceAll("\\s", ""));
	}
	if(map.get("cosmetic"+i).contains("■")) {
	map.put("cosmetic"+i, map.get("cosmetic"+i).split("■")[1]);
	}else {
		map.put("cosmetic"+i, map.get("cosmetic"+i).split("여부 ")[1]);	
	}
	
	System.out.println("key : " + "cosmetic"+i +" / value : " + map.get("cosmetic"+i));
	
}
*/	




// 뒤죽박죽 안좋음 
//Iterator<String> keys2 = map.keySet().iterator();
//while(keys2.hasNext()) {
//	String key = keys2.next();
//	System.out.print("key: "+key);
//	System.out.print(", value: "+map.get(key)+'\n');
//}

//driver.get("http://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000014447&dispCatNo=1000001000100010001"); // URL로 접속하기
//WebElement coolestWidgetEvah = driver.findElement(By.id("coolestWidgetEvah")); // id로 Element 가져오기
//WebElement cheese = driver.findElements(By.className("cheese")); // 클래스이름으로 Element 가져오기
//WebElement iframe = driver.findElement(By.tagName("iframe")); // 태그이름으로 Element 가져오기
////Assert.assertThat(driver.getTitle(), is("URL의 Title")); // Title 확인 작업


//List<WebElement> xPath = driver.findElements(
//By.xpath("//div[@class=\"tabConts prd_detail_cont show\"]/div[@id=\"artcInfo\"]/dl@[class=\"detail_info_list\"]/dd"));
//List<WebElement> xPath = driver.findElements(
//By.xpath("//div[@id=\"Wrapper\"]/div[id=\"Container\"]/div[@class=\"tabConts prd_detail_cont show\"]"
//		+ "/div[@id=\"artcInfo\"]/dl[@class=\"detail_info_list\"]/dd"));

//System.out.println(xPath.get(0));
//		for(int i=0;i<=xPath.size();i++) {
//String keyName="cosmetic"+i;
//map.put(keyName, xPath.get(i).getText());
//}

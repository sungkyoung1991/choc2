package com.sample.choc2;

import java.util.HashMap;
import java.util.Iterator;
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


//JUnit 테스트 클래스를 실행시킬 환경(클래스)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/config/*.xml"})
public class CrawlingTest {
	private WebDriver driver;
	String product;
    String brand;
    String price;
    String imagePath; 
    
    String mount; // 용량					key : cosmetic0
    String skinType;// 피부타입			key : cosmetic1
    String term;// 사용기간 				key : cosmetic2
    String method; //사용방법 				key : cosmetic3
    String manufacturer; //제조사 			key : cosmetic4
    String origination;// 제조국 			key : cosmetic5
    String ingredient;// 성분 			key : cosmetic6
	String functional;// 기능성 화장품 		key : cosmetic7
    String precautions;// 주의사항			key : cosmetic8
    
    Map<String,String> map = new HashMap<String,String>();
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
		driver.get("http://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000014447&dispCatNo=1000001000100010001"); // URL로 접속하기


		WebElement buyinfo = driver.findElement(By.className("goods_buyinfo")); // 클래스이름으로 Element 가져오기
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

		
		// 뒤죽박죽 안좋음 
//		Iterator<String> keys2 = map.keySet().iterator();
//		while(keys2.hasNext()) {
//			String key = keys2.next();
//			System.out.print("key: "+key);
//			System.out.print(", value: "+map.get(key)+'\n');
//		}
		

		
		
//		mount = column.get(0).toString();
//		term = column.get(2).toString();
//		manufacturer = column.get(3).toString();
//		origination = column.get(4).toString();
//		ingredient = column.get(5).toString();
//		functional = column.get(6).toString();
//		precautions = column.get(7).toString();
//		
//		WebElement iframe = driver.findElement(By.tagName("iframe")); // 태그이름으로 Element 가져오기
		//Assert.assertThat(driver.getTitle(), is("URL의 Title")); // Title 확인 작업
//		Assert.assertThat(driver.getTitle(), null, null); // Title 확인 작업
	}
}



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

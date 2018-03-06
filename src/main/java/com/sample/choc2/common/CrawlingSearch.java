package com.sample.choc2.common;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sample.choc2.common.domain.CrawlingVO;
import com.sample.choc2.service.crawling.CrawlingService;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrawlingSearch {
	@Autowired
	@Qualifier("crawlingServiceImpl")
	private CrawlingService crawlingService;
	
	public void setCrawlingService(CrawlingService crawlingService) {
		this.crawlingService = crawlingService;
	}
	WebDriver driver;
	private static final Logger logger = LoggerFactory.getLogger(CrawlingSearch.class);
	public CrawlingVO CrawlingOlive(String index,CrawlingVO crawlingVO) throws Exception{
		
		try {//---------------------------------------------------try
			 ChromeDriverManager.getInstance().setup();
		//System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver"); // 다운받은 ChromeDriver 위치를 넣어줍니다. 
		
		driver = new ChromeDriver(); // Driver 생성   
		String xpathClick = "//*[@id=\"buyInfo\"]/a";
	    String xpathBrand = "//p[@class=\"prd_brand\"]";
	    String xpathPrdName = "//*[@class=\"prd_info\"]/*[@class=\"prd_name\"]";
	    String xpathPrice = "//*[@class=\"prd_info\"]/ul/li/span[@class=\"tx_cont cur_price\"]/span[@class=\"tx_num\"]";
	    String xpathImage = "//div[@class=\"prd_detail_box\"]/div[@class=\"left_area\"]/div[@class=\"prd_img\"]/img";
	    //CrawlingVO crawlingVO = new CrawlingVO();

	    //Map<String,String> map = new HashMap<String,String>();
		/*
		 * Oliveyoung 검색창을 활용하여 모델명, 브랜드명을 파라미터로 받아
		 * 화장품 정보를 색출 해내는 기능.
		 */
//		String testParam="케라틴 스무드 샴푸";
		//logger.info("메소드 안에 들어오는 index값 : "+index);
		//String arg1;
		//String arg2;
		ArrayList<String> arg1 = new ArrayList<String>();
		ArrayList<String> arg2 = new ArrayList<String>();
		Document doc= 
				Jsoup.connect("https://m.oliveyoung.co.kr/m/search/getSearchMain.do?query="+index+"#load_SearchLst").get();
		
		Elements url =doc.select("div.goods");
		url =doc.select("div.box");
		url =doc.select("a");
		url = doc.select("a[href]");
		
			/* 	for문으로 리스트를 만들어 안쪽 링크이동에 필요한 데이터를 추출 
			 *	하단 for문 자체기능은 href가 포함된 모든 태그를 담는다
			 *	그 역할을 arrt()가 하고있다.  
			 */
		for(Element target : url) {
//		System.out.println("href :" + target.attr("href"));
			
			String targets = target.attr("href").toString();
			if(targets.contains("moveGoodsDetail")) {
				//http tag 안쪽 필요한 데이터 arg1 arg2를 파싱 
				//javascript:common.link.moveGoodsDetail('A000000014447','1000001000100010001');
				
				
				//System.out.println("target :" + targets.toString());
				arg1.add(targets.split("\'")[1].split("\',\'")[0]);
				arg2.add(targets.split("\',\'")[1].split("\'")[0]);
				//System.out.println("targets 파싱 : "+arg1+", "+arg2);
				
				
				//=--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-selenium-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-
				
				
				
			}
		}
		System.out.println("=--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-selenium-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-");
		
		for(int i=0; i<1;i++) {
			try {
			System.out.println("url :"+"http://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo="+arg1.get(0)+"&dispCatNo="+arg2.get(0));
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("이런! 없는 상품이에요 ! ");
			}
			
		driver.get("http://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo="+arg1.get(0)+"&dispCatNo="+arg2.get(0)); // URL로 접속하기
		
		// xPath로 경로 접근하여 크롤링하기 
				//driver.get("http://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000014447&dispCatNo=1000001000100010001"); // URL로 접속하기
				String prdName = driver.findElement(By.xpath(xpathPrdName)).getText();
				crawlingVO.setProductName(prdName);
				System.out.println(crawlingVO.getProductName());		
				
				String brand = driver.findElement(By.xpath(xpathBrand)).getText();
				crawlingVO.setBrand(brand.split("브랜드")[0]);
				System.out.println(crawlingVO.getBrand());
				
				String price = driver.findElement(By.xpath(xpathPrice)).getText();
				crawlingVO.setPrice(price);
				System.out.println(crawlingVO.getPrice());
				
				WebElement image = driver.findElement(By.xpath(xpathImage));
				crawlingVO.setImagePath(image.getAttribute("src").toString());
				System.out.println(crawlingVO.getImagePath());
				

				driver.findElement(By.xpath(xpathClick)).click();
		
				for(int j=1; j<= 9; j++) {
					String num = String.valueOf(j);
					String xpathList = "//*[@id=\"artcInfo\"]/dl[" +num + "]/dd";
					String infoData = driver.findElement(By.xpath(xpathList)).getText();
					if(infoData.contains("■")) {
						infoData = infoData.split("■")[1];
					}
					//System.out.println(infoData);
					switch (j) {
					case 1:
						crawlingVO.setMount(infoData);
						System.out.println(crawlingVO.getMount());
						break;
					case 2:
						crawlingVO.setSkinType(infoData);
						System.out.println(crawlingVO.getSkinType());
						break;
					case 3:
						crawlingVO.setTerm(infoData);
						System.out.println(crawlingVO.getTerm());
						break;
					case 4:
						crawlingVO.setMethod(infoData);
						System.out.println(crawlingVO.getMethod());
						break;
					case 5:
						crawlingVO.setManufacturer(infoData);
						System.out.println(crawlingVO.getManufacturer());
						break;
					case 6:
						crawlingVO.setOrigination(infoData);
						System.out.println(crawlingVO.getOrigination());
						break;
					case 7:
						crawlingVO.setIngredient(infoData);
						System.out.println(crawlingVO.getIngredient());
						break;
					case 8:
						crawlingVO.setFunctional(infoData);
						System.out.println(crawlingVO.getFunctional());
						break;
					case 9:
						crawlingVO.setPrecautions(infoData);
						System.out.println(crawlingVO.getPrecautions());
						
						break;
			
					default:
						break;
					}
				}
				
				logger.info("test : "+crawlingVO);
				//crawlingService.createOvlieCrawling(crawlingVO);
		}
		return crawlingVO;

		}catch(Exception e) {
			e.printStackTrace();
			
		}finally{
			driver.quit(); // Driver 종료
			//return ;
		}
		return crawlingVO;
		

		 
	}
}
/*
 * 		WebElement buyinfo = driver.findElement(By.className("goods_buyinfo")); // 클래스이름으로 Element 가져오기
		buyinfo.click();//동적 사이트 버튼 클릭 
		List<WebElement> column = driver.findElements(By.className("detail_info_list"));
		
		
		System.out.println("===========================================================");
		// <key : value>에 담는다. 
			for(int j=0;j<=8;j++) {
				String keyName="cosmetic"+j;
				map.put(keyName, column.get(j).getText());
			}
			for(int k=0;k<=8;k++) {
				if(map.get("cosmetic"+k)==map.get("cosmetic6")) {
					map.put("cosmetic6", map.get("cosmetic6").replaceAll(" ",""));
					map.put("cosmetic6", map.get("cosmetic6").replaceAll("\\s", ""));
				}
				if(map.get("cosmetic"+k).contains("■")) {
				map.put("cosmetic"+k, map.get("cosmetic"+k).split("■")[1]);
				}else {
					map.put("cosmetic"+k, map.get("cosmetic"+k).split("여부 ")[1]);	
				}
				
				System.out.println("key : " + "cosmetic"+k +" / value : " + map.get("cosmetic"+k));
				
			}
 * */
//System.out.println("--------------url----------------\n"+url.toString());

//https://m.oliveyoung.co.kr/m/goods/getGoodsDetail.do?goodsNo=A000000111760&dispCatNo=1000001000100010002
//HTML 기본 정보
//
//<구성요소 속성1="속성1 값" 속성2="속성2 값">구성요소 값</구성요소>
//
//종류
//
//구성요소.text(); : 구성요소 값을 반환(태그는 포함하지 않음)
//구성요소.attr("속성이름"); : 구성요소 "속성이름"에 대한 값을 반환
//구성요소.html(); : 구성요소 값을 반환(태그도 포함)
//구성요소.outerHtml(); : 구성요소를 반환(태그와 값 모두)

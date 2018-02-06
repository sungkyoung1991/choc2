package com.sample.choc2.common;

//import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	/*
	 * 외부에서 입력되는 데이터
	 * page > 현재 조회하는 페이지의 번호
	 * perPageNum > 한 페이지당 출력하는 데이터의 개수 
	 * 
	 * totalCount > DB에서 계산되는 데이터 
	 * 
	 * 
	 * 계산을 통해서 만들어지는 데이터 
	 * totalCount > 게시물의 총 갯
	 * startPage > 시작 페이지 번호 
	 * endPage > 끝 페이지 번호 
	 * prev > 이전 페이지 링크 
	 * next > 이후 페이지 링크  
	 * displayPageNum > 화면에 보여지는 페이지의 수( 페이지 번호의 수 )
	 * 
	 * */
	  private int totalCount;
	  private int startPage;
	  private int endPage;
	  private boolean prev;
	  private boolean next;

	  private int displayPageNum = 10;

	  private Criteria cri;

	  public void setCri(Criteria cri) {
	    this.cri = cri;
	  }

	  public void setTotalCount(int totalCount) {
	    this.totalCount = totalCount;

	    calcData();
	  }

	  
	  /*
	   * 페이징 연산 처리
	   * ex) 현재 페이지 13페이지 startPage는 11페이지가 돼야 하고, endPage는 20이 돼야한다.
	   * 	13/10 페이지 번호를 몇개씩 보여 줄 것인가 =1.3 > 1.3을 올림 = 2 >>>>페이지 번호 10개 씩 두 번째로 보여지는 페이지, 첫번째는 1~10 두번째는 11~20
	   * 2*10(페이지 번호 수의 개수) = 20 끝 페이지의 번호 
	   * 20 - 9 = 11 시작 페이지의 번호 
	   * 현재 페이지 번호 / 페이지 번호의 수 
	   * 
	   * */
	  private void calcData() {
		  //끝 페이지 구하기 
	    endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
	    //시작페이지 구하기
	    startPage = (endPage - displayPageNum) + 1;
	    // totalCount, endpage 재계
	    int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

	    if (endPage > tempEndPage) {
	      endPage = tempEndPage;
	    }
	    // 이전 다음버튼 활성화, 비활성화  
	    prev = startPage == 1 ? false : true;

	    next = endPage * cri.getPerPageNum() >= totalCount ? false : true;

	  }

	  public int getTotalCount() {
	    return totalCount;
	  }

	  public int getStartPage() {
	    return startPage;
	  }

	  public int getEndPage() {
	    return endPage;
	  }

	  public boolean isPrev() {
	    return prev;
	  }

	  public boolean isNext() {
	    return next;
	  }

	  public int getDisplayPageNum() {
	    return displayPageNum;
	  }

	  public Criteria getCri() {
	    return cri;
	  }
	  
	  /* UriComponents > path나 query에 해당하는 문자열 들을 추가해서 원하는 URI를 생성할 때 사용
	   * ex) localhost:8080/board/update?page=13&perPageNum=10 이런식의
	   * 
	   *  jsp에서 사용 
	   *  필요한 데이터를 생성하는데 사용한다.	
	   * 
	   * */
	  public String makeQuery(int page) {
		  
		  UriComponents uriComponents=
				  UriComponentsBuilder.newInstance()
				  .queryParam("page", page)
				  .queryParam("perPageNum", cri.getPerPageNum())
				  .build();
		  
		  return uriComponents.toString();
	  }
	  //검색기능 없을 때 
   public String makeSearch(int page) {
		  UriComponents uriComponents = 
				  UriComponentsBuilder.newInstance()
				  .queryParam("page", page)
				  .queryParam("perPageNum", cri.getPerPageNum())
		  			.queryParam("searchType", ((SearchCriteria) cri).getSearchType())
		  			.queryParam("keyword",encoding(((SearchCriteria)cri).getKeyword())).build();
		  
		  return uriComponents.toString();
	  }
   	//검색 기능 있을 때 데이터 유지를 위해 사용 

   
	private String encoding(String keyword) {
		// TODO Auto-generated method stub
		if(keyword == null || keyword.trim().length() == 0) {
			return "";
		}
		try {
			return URLEncoder.encode(keyword,"UTF-8");
			
		}catch(UnsupportedEncodingException e) {
			return "";
		}
	}

}
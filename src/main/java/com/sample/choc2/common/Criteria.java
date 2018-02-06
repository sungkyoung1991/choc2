package com.sample.choc2.common;

public class Criteria {
	/*	Criteria (검색 기준, 분류)
	 *	page > 현재 페이지 
	 *  perPageNum > 현재 보여지는 게시물의 갯
	*/
	  private int page; 	//현재 페이지
	  private int perPageNum; //현재 페이지에 보여줄 게시물 갯수

	  
	  // 생성자 기본 
	  public Criteria() {
	    this.page = 1;	//1페이지
	    this.perPageNum = 10;	//10개씩 보여줌
	  }

	  
	  // setter getter...
	  public void setPage(int page) {

	    if (page <= 0) {
	      this.page = 1;
	      return;
	    }

	    this.page = page;
	  }

	  public void setPerPageNum(int perPageNum) {

	    if (perPageNum <= 0 || perPageNum > 100) {
	      this.perPageNum = 10;
	      return;
	    }

	    this.perPageNum = perPageNum;
	  }

	  public int getPage() {
	    return page;
	  }
	  
	  
	  // 시작 데이터 번호 = ( 페이지 번호 - 1 ) * ( 페이지 당 보여지는 게시물의 개수 ) ex) (2-1)*10  = 20 20부터~29까지 10개씩 보여줌
	  // method for MyBatis SQL Mapper -
	  public int getPageStart() {

	    return (this.page - 1) * perPageNum;
	  }

	  // method for MyBatis SQL Mapper
	  public int getPerPageNum() {

	    return this.perPageNum;
	  }

	  @Override
	  public String toString() {
	    return "Criteria [page=" + page + ", "
	        + "perPageNum=" + perPageNum + "]";
	  }
	}
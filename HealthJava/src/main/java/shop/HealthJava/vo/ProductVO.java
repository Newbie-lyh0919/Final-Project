package shop.HealthJava.vo;

import lombok.Data;

@Data
public class ProductVO {

	/*-- 상품 table
	CREATE TABLE tbl_product(
	    product_no   number(38) primary key , -- 상품 글 번호
	    product_title varchar2(100) NOT NULL ,-- 상품 명
	    product_price number(38) NOT NULL , -- 상품 가격
	    product_maker varchar2(100) NOT NULL , -- 제조사
	    product_type varchar2(100) NOT NULL ,-- 분류1
	    product_type2 varchar2(100) NOT NULL ,-- 분류2
	    product_cont1 varchar2(4000) NOT NULL , -- 상품사진
	    product_cont2 varchar2(4000) , -- 상품사진
	    product_cont3 varchar2(4000) , -- 상품사진
	    product_cont4 varchar2(4000) , -- 상품사진
	    product_cont5 varchar2(4000) NOT NULL , -- 상품내용사진
	    product_cont6 varchar2(4000) , -- 상품내용사진
	    product_cont7 varchar2(4000) ,-- 상품내용사진
	    product_cont8 varchar2(4000) ,  -- 상품내용사진
	    product_score number(38) default 0 , -- 상품 평점 ( 리뷰 평균값 가져옴 )
	    product_count number(38) , -- 상품 재고
	    product_date date -- 상품 등록 날짜(sysdate)
	);*/
	
private int product_no;
	
	private String product_cont1 ;
	private String product_cont2 ;
	private String product_cont3 ;
	private String product_cont4 ;
	
	private String product_cont5 ;
	private String product_cont6 ;
	private String product_cont7 ;
	private String product_cont8 ;
	
	private String product_title;
	
	private String product_price;
	
	private String product_maker;
	
	private String product_type;
	private String product_type2;
	
	private String product_score;
	
	private String product_count;
	
	
	private String product_date;//등록날짜
	

	
	//페이징 쪽나누기 관련변수
    private int startrow;//시작행 번호
    private int endrow;//끝행 번호
    
    //검색기능
    private String search_type;//검색어
    private String search_field;//검색필드 
    
    
    //
    private int page_count;
	
}
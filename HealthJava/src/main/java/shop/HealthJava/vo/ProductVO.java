package shop.HealthJava.vo;

import lombok.Data;

@Data
public class ProductVO {

	private int product_no; //상품 글번호
	private String product_title; //상품명
	private int product_price; //상품 가격
	private String product_maker; //제조사
	private String product_type; //소분류
	private String product_type2; //소분류
	private String product_cont1; // 상품 내용(사진)
	private String product_cont2;
	private String product_cont3;
	private String product_cont4;
	private String product_cont5;
	private String product_cont6;
	private String product_cont7;
	private String product_cont8;
	private int product_score; // 별점
	private int product_count; // 재고
	private String product_date; //상품 등록날짜


	//검색필드
	private String search_type;
	private String search_field;

}

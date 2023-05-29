package shop.HealthJava.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDetailVO {
	
	/*-- 주문상세내역 table 
	CREATE TABLE tbl_order_detail (
	    order_detail_no NUMBER(38) , -- 주문no
	    order_no NUMBER(38) , -- 주문내역 no
	    product_no NUMBER(38) , -- 상품 no
	    order_date DATE , 
	    order_detail_pname VARCHAR2(100) , -- 제품명 = 상품명 
	    order_detail_cnt VARCHAR2(100) , -- 수량
	    order_detail_price VARCHAR2(100) , -- 가격
	    CONSTRAINT pk_order_detail PRIMARY KEY (order_detail_no),
	    CONSTRAINT fk_order_detail_order_no FOREIGN KEY (order_no) REFERENCES tbl_order(order_no),
	    CONSTRAINT fk_order_detail_product_no FOREIGN KEY (product_no) REFERENCES tbl_product(product_no)
	);*/
	
	private int order_detail_no; // 주문no
	private int order_no; // 주문 내역 no
	private int product_no; // 상품 no
	private String order_detail_pname; // 제품명
	private String order_detail_cnt; // 수량
	private String order_detail_price; // 금액 
	private String order_date; // 주문 일자 
	private String user_id;
	private String order_detail_pcont;// 상품이미지

}

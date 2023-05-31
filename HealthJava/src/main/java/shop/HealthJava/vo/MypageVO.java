 package shop.HealthJava.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class MypageVO {
	
	/*-- 상품 후기 table 
	create table tbl_reviews (
	    re_no NUMBER PRIMARY KEY , -- 후기 no
	    re_pro_no NUMBER(38) REFERENCES tbl_product(product_no) , --제품no : F
	    re_mem_id VARCHAR2(100) , -- 회원 아이디 
	    re_title VARCHAR2(100) , -- 리뷰 제목
	    re_content VARCHAR2(4000) ,  --리뷰 내용
	    re_image1 VARCHAR2(4000)  , --사진 등록1
	    re_image2 VARCHAR2(4000)  , -- 사진등록2
	    re_image3 VARCHAR2(4000)  , -- 사진등록3
	    re_score NUMBER(38) , --별점 score
	    re_date DATE --등록일
	);
	*/

	private int re_no; // 후기no
	private int re_pro_no; // 제품 no
	private String re_mem_id; // 회원 아이디
	private String re_title; // 후기 제목
	private String re_content; // 후기 내용
	private String re_image1; // 사진등록 1
	private String re_image2; // 사진등록 2
	private String re_image3; // 사진등록 3
	private int re_score; // 리뷰 별점 
	private String re_date; // 등록일
	
	/*-- 장바구니 table
	create table tbl_cart (
	   cart_no NUMBER PRIMARY KEY , -- 장바구니 no
	   cart_mem_id VARCHAR(100) , -- 회원 아이디 , 비회원 아이디 :랜덤값 
	   cart_pro_id VARCHAR(100) REFERENCES tbl_product(product_no)  , -- 제품 고유번호 : F 상품no
	   cart_cnt  NUMBER(38)  -- 구매 수량
	);*/
	
	private int cart_no; // 장바구니 no
	private String cart_mem_id; // 회원아이디, 비회원일 때 : 랜덤값
	private String cart_pro_id; // 제품 no
	private int cart_cnt; // 구매 수량
	
	/*--  찜 목록 table 
	create table tbl_like (
	    like_no NUMBER PRIMARY KEY , -- 찜 no
	    like_mem_id VARCHAR(100)  REFERENCES tbl_member(user_id)  , -- 회원ID : F
	    like_pro_id VARCHAR(100)  -- 제품 고유번호 : F상풍no
	);*/
	
	private int like_no; // 찜no
	private String like_mem_id; // 회원 id 
	private String like_pro_id; // 제품 no
	
	/*-- 결제 table 
	create table tbl_order (
	    order_no NUMBER PRIMARY KEY , -- 주문번호 no
	    order_id VARCHAR2(100) , -- 회원 1, 비회원 2
	    order_date DATE , -- 주문일자 
	    order_name VARCHAR2(100) , -- 수령자 
	    order_phone VARCHAR2(100) ,-- 수령자 연락처 
	    order_post VARCHAR2(100) , -- 수령자 우편번호 
	    order_road VARCHAR2(100) , -- 수령자 주소 
	    order_detail VARCHAR2(100) , -- 수령자 상세주소
	    order_total NUMBER(38) , -- 총 금액
	    order_type VARCHAR2(100) -- 결제 수단 : 1 무통장금액_메일발송안내, 2 카드결제 3. 카카오페이/네이버페이 
	);*/
	
	private int order_no; // 주문번호 no
	private String order_id; // 1.회원 2.비회원
	private int order_date; // 주문일자
	private String order_name; // 수령자
	private String order_phone; // 연락처
	private String order_post; // 우편번호
	private String order_road; // 주소
	private String order_detail; // 상세주소
	private int order_total; // 총 금액
	private String order_type; // 결제 수단 : 1.무통장금액 _메일발송안내, 2.카드결제, 3.카카오페이/네이버페이
	
	/*-- 주문상세내역 table 
	create table tbl_order_detail (
	    order_detail_no NUMBER PRIMARY KEY , -- 주문 no
	    order_detail_fno NUMBER  REFERENCES tbl_product(product_no) , -- 주문번호 no  : F = 상품no
	    order_detail_pname VARCHAR2(100)  REFERENCES tbl_product(product_title)  , --제품명 = 상품명F
	    order_detail_cnt VARCHAR2(100) , -- 수량 
	    order_detail_price VARCHAR2(100) -- 가격
	);*/
	
	private int order_detail_no; // 주문no
	private int order_detail_fno; // 재품no
	private String order_detail_pname; // 상품명
	private String order_detail_cnt; // 수량
	private String order_detail_price; // 가격
	
	/*-- 교환, 환불 table : 신청용
	create table tbl_refund (
	    refund_no NUMBER PRIMARY KEY , -- 교환, 환불 no
	    refund_order_no NUMBER PRIMARY KEY  REFERENCES tbl_product(product_no) , -- 주문번호 no : F = 상품no
	    refund_category VARCHAR2(100) , -- 카테고리 : 1.교환, 2. 환불, 3.기타
	    refund_cont VARCHAR2(4000) , -- 사유(내용) 
	    refund_image varchar2(1000) , --사진
	    refund_state varchar2(100) , -- 상태 : 1대기, 2접수중, 3접수완료 
	    refund_date DATE -- 등록일자
	);*/
	
	private int refund_no; // 교환, 환불 no
	private int refund_order_no; // 제품 no
	private String refund_category; // 카테고리 : 1.교환, 2.환불. 3.기타
	private String refund_cont; // 사유(내용)
	private String refund_image; // 사진
	private String refund_state; // 상태 : 1.대기, 2.접수중, 3.접수완료
	private String date; // 등록일자 
	
	/*-- 쿠폰 table 
	create table tbl_coupon (
	    coupon_no NUMBER PRIMARY KEY , -- 쿠폰 no
	    coupon_name VARCHAR2(100) , --쿠폰명
	    coupon_dc NUMBER(38) ,-- 쿠폰
	    coupon_mem_id VARCHAR(100)  -- 회원 아이디 , 비회원 아이디 :랜덤값  : F
	);*/
	
	private int coupon_no; // 쿠폰 no
	private String coupon_name; // 쿠폰명
	private int coupon_dc; // 쿠폰할인율
	private String coupon_mem_id; // 회원아읻, 비회원아이디 (랜덤값)
	
	
}
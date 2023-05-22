package shop.HealthJava.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LikeVO {
	
	/*--  찜 목록 table 
	CREATE TABLE tbl_like (
	    like_no NUMBER PRIMARY KEY, -- 찜 no
	    user_no NUMBER(38) , -- 회원 번호를 참조하는 외래 키
	    product_no NUMBER(38) ,-- 제품 고유번호 : F = 상품no
	    CONSTRAINT fk_like_user_no FOREIGN KEY (user_no) REFERENCES tbl_member(user_no),
	    CONSTRAINT fk_like_product_no FOREIGN KEY (product_no) REFERENCES tbl_product(product_no)
	);*/
	
	private int like_no; // 찜no
	private int user_no; // 회원 no _ user_id 불러오기 
	private int product_no; // 제품 no
}

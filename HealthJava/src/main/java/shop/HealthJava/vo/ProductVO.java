package shop.HealthJava.vo;

import lombok.Data;

@Data
public class ProductVO {
	
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

package shop.HealthJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.HealthJava.service.ProductService;

@Controller
public class ProductController { // 상품 페이지 관련 컨트롤러

	@Autowired
	private ProductService productService;
	
	// ??? 폼 / ex)상품 페이지 메인 폼
	@RequestMapping("/product_random") // 매핑 및 반환타입, 페이지 경로 예시
	public ModelAndView product_random() {
		System.out.println("??? 폼 접속 시도");
		ModelAndView product_random = new ModelAndView("product/product"); // 페이지 경로
		System.out.println("??? 폼 접속 완료");
		
		return product_random; // 페이지 경로 반환
	} // end product_random()
	
	
}

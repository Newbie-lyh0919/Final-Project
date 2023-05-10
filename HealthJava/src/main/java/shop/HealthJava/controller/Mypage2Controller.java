package shop.HealthJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.HealthJava.service.Mypage2Service;

@Controller
public class Mypage2Controller { // 마이페이지2 관련 컨트롤러

	@Autowired
	private Mypage2Service mypage2Service;
	
	// ??? 폼 / ex)마이페이지2 메인 폼
	@RequestMapping("/mypage2_random") // 매핑 및 반환타입, 페이지 경로 예시
	public ModelAndView mypage2_random() {
		System.out.println("??? 폼 접속 시도");
		ModelAndView mypage2_random = new ModelAndView("mypage2/mypage2"); // 페이지 경로
		System.out.println("??? 폼 접속 완료");
		
		return mypage2_random; // 페이지 경로 반환
	} // end mypage2_random()
	
	
}

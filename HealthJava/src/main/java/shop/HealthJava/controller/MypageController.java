package shop.HealthJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.HealthJava.service.MypageService;

@Controller
public class MypageController { // 마이페이지 관련 컨트롤러

	@Autowired
	private MypageService mypageService;
	
	// ??? 폼 / ex)마이페이지 메인 폼
	@RequestMapping("/mypage_random") // 매핑 및 반환타입, 페이지 경로 예시
	public ModelAndView mypage_random() {
		System.out.println("??? 폼 접속 시도");
		ModelAndView mypage_random = new ModelAndView("mypage/mypage"); // 페이지 경로
		System.out.println("??? 폼 접속 완료");
		
		return mypage_random; // 페이지 경로 반환
	} // end mypage_random()
	
	
}

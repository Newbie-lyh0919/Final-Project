package shop.HealthJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.HealthJava.service.MemberService;

@Controller
public class MemberController { // 사용자 관련 컨트롤러

	@Autowired
	private MemberService memberService;
	
	// ??? 폼 / ex)사용자 메인 폼
	@RequestMapping("/member_random") // 매핑 및 반환타입, 페이지 경로 예시
	public ModelAndView member_random() {
		System.out.println("??? 폼 접속 시도");
		ModelAndView member_random = new ModelAndView("member/member"); // 페이지 경로
		System.out.println("??? 폼 접속 완료");
		
		return member_random; // 페이지 경로 반환
	} // end member_random()
	
	
}

package shop.HealthJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.HealthJava.service.AdminService;

@Controller
public class AdminController { // 관리자 관련 컨트롤러

	@Autowired
	private AdminService adminService;
	
	// ??? 폼 / ex)관리자 메인 폼
	@RequestMapping("/admin_random") // 매핑 및 반환타입, 페이지 경로 예시
	public ModelAndView admin_random() {
		System.out.println("??? 폼 접속 시도");
		ModelAndView admin_random = new ModelAndView("admin/admin"); // 페이지 경로
		System.out.println("??? 폼 접속 완료");
		
		return admin_random; // 페이지 경로 반환
	} // end admin_random()
	
	
}

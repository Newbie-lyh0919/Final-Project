package shop.HealthJava.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import shop.HealthJava.service.MyPageService;

@Controller
public class MypageController {
	
	//@Autowired
	//private MyPageService myPageService;
	
	//마이페이지 메인화면
	@RequestMapping("/myPage_Main")
	public ModelAndView myPage_Main(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/myPage_Main");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
	
	//마이페이지 비밀번호 변경
	@RequestMapping("/myPage_changePwd")
	public ModelAndView myPage_changePwd(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/myPage_changePwd");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
	
	//마이페이지 주문취소
	@RequestMapping("/myPage_orderCancel")
	public ModelAndView myPage_orderCancel(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/myPage_orderCancel");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
	
	//마이페이지 주문상세
	@RequestMapping("/myPage_orderDedails")
	public ModelAndView myPage_orderDedails(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/myPage_orderDedails");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
	
	//마이페이지 배송지 수정
	@RequestMapping("/myPage_updateAddress")
	public ModelAndView myPage_updateAddress(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/myPage_updateAddress");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
	
	//마이페이지 회원 정보 수정
	@RequestMapping("/myPage_updateInfo")
	public ModelAndView myPage_updateInfo(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/myPage_updateInfo");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}

	//마이페이지 회원 탈퇴
	@RequestMapping("/myPage_user_Withdrawal")
	public ModelAndView myPage_user_Withdrawal(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/myPage_user_Withdrawal");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
	
	//마이페이지 장바구니
	@RequestMapping("/basket")
	public ModelAndView basket(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/basket");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
	
	//마이페이지 찜
	@RequestMapping("/like")
	public ModelAndView like(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/like");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
	
	//마이페이지 리뷰
	@RequestMapping("/review")
	public ModelAndView reviewlike(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/review");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
	
	//마이페이지 리뷰 작성
	@RequestMapping("/review_write")
	public ModelAndView review_write(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/review_write");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
}

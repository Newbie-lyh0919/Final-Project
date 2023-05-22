package shop.HealthJava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.HealthJava.service.MypageService;
import shop.HealthJava.vo.AddrVO;
import shop.HealthJava.vo.CartVO;
import shop.HealthJava.vo.LikeVO;
import shop.HealthJava.vo.MemberVO;
import shop.HealthJava.vo.OrderDetailVO;
import shop.HealthJava.vo.OrderVO;

@Controller
public class MypageController {
	
	@Autowired
	private MypageService myPageService;
	
	
	//마이페이지 메인화면
	@RequestMapping("/myPage_Main")
	public String myPage_Main(Model model, HttpServletRequest request, HttpServletResponse response ) {
		return "/mypage/myPage_Main";
	}
		
	// 마이페이지 주문ㆍ배송 : tbl_order (주문내역 table)
	@RequestMapping("/myPage_order")
	public String myPage_orderCancel(OrderVO ovo, Model model, HttpServletRequest request, HttpServletResponse response ) {
		
		System.out.println("주문ㆍ배송 접속 중");
		
		int order_count = this.myPageService.getOrderCount(ovo); // 총 주문 건수
		List<OrderVO> olist = this.myPageService.getOrderList(ovo); // 주문 내역 list
		
		System.out.println("주문내역 리스트 : "+olist);
		System.out.println("총 주문건수 : "+order_count);
		
		model.addAttribute("order_count", order_count);
		model.addAttribute("olist", olist);
		//ModelAndView wm=new ModelAndView("mypage/myPage_orderCancel");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		System.out.println("주문ㆍ배송 접속 완료닷!");
		return "/mypage/myPage_order";
	}
	
	// 마이페이지 교환/반품/환불 : tbl_order_detail , tbl_refund (교환,환불,반품 신청용 table)
	@RequestMapping("/myPage_orderDetails")
	public String myPage_orderDetails(OrderDetailVO odv, Model model, HttpServletRequest request) {
		
		System.out.println("교환/반품/환불 접속중");
		int order_no = Integer.parseInt(request.getParameter("order_no") != null ? request.getParameter("order_no") : "0");
		List<OrderDetailVO> orderDetailList = this.myPageService.getOrderDetailList(odv); // 주문상세 내역 list order_no 기준
		
		System.out.println("주문 상세 내역 리스트 : "+ orderDetailList);
		System.out.println("주문내역 : "+ order_no);
		
		model.addAttribute("order_no", order_no);
		model.addAttribute("orderDetailList", orderDetailList); 
		
		//ModelAndView wm=new ModelAndView("mypage/myPage_orderDetails");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		System.out.println("교환/반품/환불 접속 완료했당, 휴~");
		return "mypage/myPage_orderDetails";
	}

	//마이페이지 찜 : tbl_like(찜목록 table) : like_no, user_id, product_id
	@RequestMapping("/myPage_like")
	public String myPage_like(LikeVO lv, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session ) {
		
		System.out.println("찜목록 접속중");
		// 찜목록 조회 
		List<LikeVO> Llist = this.myPageService.getLikeProductsList(lv); 
		System.out.println("찜목록 : "+Llist);
		
		//3. 뷰페이지로 전달
		model.addAttribute("Llist", Llist);
		//ModelAndView wm=new ModelAndView("mypage/myPage_like");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		System.out.println("찜목록 접속 완료다요");
		return "mypage/myPage_like";
	}
	
	//마이페이지 장바구니 : tbl_cart
	@RequestMapping("/myPage_cart")
	public String myPage_basket(@ModelAttribute CartVO cvo, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session ) {
		System.out.println("장바구니 접속중");
		// 로그인 된 사용자의 정보 가져오기
		String user_id = (String)session.getAttribute("id");
		cvo.setCart_mem_id(user_id);
		System.out.println(user_id);
		
		List<CartVO> clist = this.myPageService.getCartList(cvo); // 장바구니 리스트 조회
		System.out.println("장바구니 목록 : "+clist);
		model.addAttribute("clist", clist);
		//ModelAndView wm=new ModelAndView("mypage/myPage_basket");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		System.out.println("장바구니 접속 완료~");
		return "mypage/myPage_cart";
	}	
	
	//문의 내역 확인
	@RequestMapping("/myPage_inquiry")
	public ModelAndView myPage_inquiry(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/myPage_inquiry");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
	
	
	//마이페이지 배송지 리스트 : tbl_member, tbl_addr
	@RequestMapping("/myPage_updateAddress")
	public String myPage_updateAddress(Model model, HttpSession session,HttpServletRequest request, HttpServletResponse response, @ModelAttribute MemberVO mvo, @ModelAttribute AddrVO avo ) throws Exception {
		System.out.println("배송지 리스트 접속중~");
		
		// tbl_member table : 회원 가입시 기본 주소 _user_id
		String user_id = (String) session.getAttribute("id"); 
		mvo.setUser_id(user_id);
		System.out.println(user_id);
		
		List<MemberVO> mlist = this.myPageService.getMemberAddrList(mvo); // 배송지 리스트 조회
		System.out.println(mlist);
		model.addAttribute("mlist", mlist);
		
		// tbl_addr : 배송지 추가 
		avo.setUser_id(user_id);
		System.out.println(user_id);
		
		List<AddrVO> alist = this.myPageService.getAddrList(avo); // 배송지 추가 리스트 조회
		System.out.println(alist);
		model.addAttribute("alist", alist);
	    
		//ModelAndView wm = new ModelAndView("mypage/myPage_updateAddress"); //생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		System.out.println("배송지 리스트 접속완료했슴돠!");
		return "mypage/myPage_updateAddress";
	}
	
	//마이페이지 배송지 추가 : tbl_addr
	@RequestMapping("/addr_ok")
	public ModelAndView addr_ok(AddrVO av ,HttpSession session,HttpServletRequest request, HttpServletResponse response ) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		this.myPageService.insertAddr(av); //배송지 추가
		//ModelAndView wm = new ModelAndView("mypage/addAddressPopup"); //생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		return  new ModelAndView("redirect:/myPage_updateAddress");
	}
	
	//마이페이지 리뷰
	@RequestMapping("/myPage_review")
	public ModelAndView myPage_review(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/myPage_review");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}
	
	//마이페이지 리뷰 작성
	@RequestMapping("/myPage_review_write")
	public ModelAndView review_write(HttpServletRequest request, HttpServletResponse response ) {
		
		ModelAndView wm=new ModelAndView("mypage/myPage_review_write");//생성자 인자값으로 뷰페이지 경로 설정=>/WEB-INF/
		
		return wm;
	}

}

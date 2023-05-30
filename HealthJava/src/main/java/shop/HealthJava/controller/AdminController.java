package shop.HealthJava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.HealthJava.service.AdminService;
import shop.HealthJava.vo.CSClientVO;
import shop.HealthJava.vo.MemberVO;
import shop.HealthJava.vo.ProductVO;

@Controller
public class Admincontroller {

	@Autowired
	private AdminService adminService;
		
	//관리자- 메인/회원관리
	@RequestMapping("/admin_main")
	public String Admin_Member(MemberVO mvo, Model model, HttpServletRequest request, HttpServletResponse response) {
		
	int member_count = this.adminService.getMemberCount(mvo); //관리자 - 검색에 따른 회원수
	List<MemberVO> mlist = this.adminService.getMemberListBySearch(mvo); //관리자 - 회원 리스트 조회	
	System.out.println(mlist);
	
	model.addAttribute("member_count", member_count);
	model.addAttribute("mlist", mlist);
		return "/admin/aMlist";
	}
	
	//관리자-회원정보 관리
	@RequestMapping("/admin_member_edit")
	public String admin_member_edit(MemberVO mvo, Model model, HttpServletRequest request, HttpServletResponse response) {

		int user_no = Integer.parseInt(request.getParameter("user_no"));
		
		mvo = this.adminService.getMemberInfo(user_no);
		
		model.addAttribute("mvo", mvo);
		
		return "/admin/aMlist_edit";
	}
	
	//관리자-회원정보 수정
	@RequestMapping("/member_edit_ok")
	public String member_edit_ok(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		String user_name = request.getParameter("user_name");
		String user_birth = request.getParameter("user_birth");
		String user_gender = request.getParameter("user_gender");
		String postCode = request.getParameter("postCode");
		String roadAddr = request.getParameter("roadAddr");
		String detailAddr = request.getParameter("detailAddr");
		String user_email = request.getParameter("user_email");
		String user_phone = request.getParameter("user_phone");
		
		MemberVO mvo = new MemberVO();
		mvo.setUser_no(user_no);
		mvo.setUser_name(user_name);
		mvo.setUser_birth(user_birth);
		mvo.setUser_gender(user_gender);
		mvo.setPostCode(postCode);
		mvo.setRoadAddr(roadAddr);
		mvo.setDetailAddr(detailAddr);
		mvo.setUser_email(user_email);
		mvo.setUser_phone(user_phone);
		
		this.adminService.MemberEdit(mvo);
		
		int member_count = this.adminService.getMemberCount(mvo);			
		List<MemberVO> mlist = this.adminService.getMemberListBySearch(mvo);			
		
		model.addAttribute("member_count", member_count);
		model.addAttribute("mlist", mlist);	
		
		return "/admin/aMlist";
	}
	
	//관리자-블랙리스트 관리 VIEW페이지
	@RequestMapping("/admin_member_black")
	public String admin_member_black(MemberVO mvo, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		
		mvo = this.adminService.getMemberInfo(user_no);
		
		model.addAttribute("mvo", mvo);
		
		return "/admin/aMlist_black";
	}
	
	//관리자-블랙리스트 관리 ok
	@RequestMapping("/admin_member_black_ok")
	public String admin_member_black_ok(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		int user_state = Integer.parseInt(request.getParameter("user_state"));
		
		MemberVO mvo = new MemberVO();
		mvo.setUser_no(user_no); mvo.setUser_state(user_state);
		
		this.adminService.MemberBlack(mvo);
		
		
		int member_count = this.adminService.getMemberCount(mvo);			
		List<MemberVO> mlist = this.adminService.getMemberListBySearch(mvo);			
		
		model.addAttribute("member_count", member_count);
		model.addAttribute("mlist", mlist);	
		
		return "/admin/aMlist";
	}

	//관리자 문의게시판
	@RequestMapping("/admin_CSBoard")
	public String Admin_CSBoard(CSClientVO cvo, Model model, HttpServletRequest request, HttpServletResponse response) {
		
	int CSBoard_count = this.adminService.getCSBoardCount(cvo);			
	List<CSClientVO> clist = this.adminService.getCSBoardListBySearch(cvo);			
	System.out.println(clist);
	System.out.println(CSBoard_count);
	
	model.addAttribute("CSBoard_count", CSBoard_count);
	model.addAttribute("clist", clist);	
	
		return "/admin/aCSBoard";
	}

	//관리자 문의게시판 내용보기
	@RequestMapping("/admin_CSBoard_cont")
	public String admin_CSBoard_cont(CSClientVO cvo, Model model, HttpServletRequest request, HttpServletResponse response) {
		int client_no = Integer.parseInt(request.getParameter("client_no")); 
		
		String state = request.getParameter("state"); //내용보기
		
		cvo = this.adminService.getClientCont(client_no); // 2-2. 문의 게시판 : 내용보기 
		String client_cont = cvo.getClient_cont().replace("\n", "<p>"); 
		// textarea에서 글내용 입력할때 엔터키를 친 부분은 다음 줄로 줄 바꿈해서 보여준다.
		
		model.addAttribute("cvo", cvo);
		model.addAttribute("client_cont", client_cont);
		model.addAttribute("client_cont_reply", cvo.getClient_cont_reply());
		
		if(state.equals("cont")) {
			return "/admin/aCSBoard_cont"; //내용보기
		}else if(state.equals("reply")) {
			return "/admin/aCSBoard_reply"; //답변글
		}
		
		return null;
	}
	
	//관리자 문의게시판 댓글 ok
	@RequestMapping("/admin_CSBoard_reply_ok")
	public String admin_CSBoard_reply_ok(CSClientVO cvo, Model model, HttpServletRequest request, HttpServletResponse response) {

		int client_no = Integer.parseInt(request.getParameter("client_no"));
		String client_title = request.getParameter("client_title");
		String client_cont = request.getParameter("client_cont");
		String user_id = request.getParameter("user_id");
		String client_category = request.getParameter("client_category");
		String client_cont_reply = request.getParameter("client_cont_reply");
		
		// 컨트롤러에서 모델 DAO로 여러개의 값을 하나의 객체로 만들어서 효율적으로 한꺼번에 전달함.
		cvo.setClient_no(client_no);
		cvo.setClient_title(client_title);
		cvo.setClient_cont(client_cont);
		cvo.setClient_category(client_category);
		cvo.setUser_id(user_id);
		cvo.setClient_cont_reply(client_cont_reply);	
		
		this.adminService.replyBoard(cvo);// 2-2.문의게시판 : 답변 저장		
		
		int CSBoard_count = this.adminService.getCSBoardCount(cvo);			
		List<CSClientVO> clist = this.adminService.getCSBoardListBySearch(cvo);			
		System.out.println(clist);
		System.out.println(CSBoard_count);
		
		model.addAttribute("CSBoard_count", CSBoard_count);
		model.addAttribute("clist", clist);	
				
		return "/admin/aCSBoard";
	}
	
	//관리자 상품 목록 관리
	@RequestMapping("/admin_GsList")
	public String Admin_GsList(ProductVO pvo, Model model, HttpServletRequest request, HttpServletResponse response) {
		
	int product_count = this.adminService.getProductCount(pvo);			
	List<ProductVO> plist = this.adminService.getProductListBySearch(pvo);			
	System.out.println(plist);
	
	model.addAttribute("product_count", product_count);
	model.addAttribute("plist", plist);
		return "/admin/aGslist";
	}

}

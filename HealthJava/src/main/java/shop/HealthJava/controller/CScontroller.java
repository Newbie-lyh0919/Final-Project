package shop.HealthJava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.HealthJava.service.CSService;
import shop.HealthJava.vo.CSClientVO;
import shop.HealthJava.vo.CSFAQVO;
import shop.HealthJava.vo.CSNoticeVO;

@Controller
public class CScontroller {

	@Autowired
	private CSService csService;

	//CS - 공지사항
	@RequestMapping("/notice")
	public String notice(CSNoticeVO nvo, Model model, HttpServletRequest request, HttpServletResponse response) {

		int page = 1;
		int limit = 10;

		String search_type = null; //검색 타입 (제목,작성자)
		String search_field = null; //검색어

		if (request.getParameter("page") != null) {// get으로 전달된 페이지번호가 있는 경우 실행
			page = Integer.parseInt(request.getParameter("page"));// 페이지 번호를 정수 숫자로 변경
		}

		search_type = request.getParameter("search_type");
		if (request.getParameter("search_field") != null) {// 검색어가 있는 경우
			search_field = request.getParameter("search_field").trim();// 양쪽 공백을 제거해서 저장
		}

		nvo.setSearch_type(search_type);
		//		nvo.setSearch_field("%" + search_field + "%");
		nvo.setSearch_field(search_field);

		int listcount = this.csService.getNoticeListCount(nvo);
		System.out.println(listcount);
		List<CSNoticeVO> nlist = this.csService.getCSNoticeList(page, limit, nvo);

		System.out.println(nlist);

		// 페이징
		int maxpage = (int) ((double) listcount / limit + 0.95); // 총 페이지수
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1; // 시작페이지
		int endpage = maxpage; // 마지막 페이지
		if (endpage > startpage + 10 - 1)
			endpage = startpage + 10 - 1;

		model.addAttribute("nlist", nlist);
		model.addAttribute("page", page);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("listcount", listcount);
		model.addAttribute("search_type", search_type);
		model.addAttribute("search_field", search_field);

		return "/cs/notice";
	}

	//CS - 공지사항 글 작성 VIEW
	@RequestMapping("/notice_write")
	public String notice_write(CSNoticeVO nvo, Model model, HttpServletRequest request, HttpServletResponse response) {

		return "/cs/notice_write";
	}

	//CS - 공지사항 글 작성 OK
	@RequestMapping("/notice_write_ok")
	public String contact_write_ok(CSNoticeVO nvo, Model model, HttpServletRequest request, HttpServletResponse response) {

		String notice_title=request.getParameter("notice_title");
		String notice_cont=request.getParameter("notice_cont");

		nvo.setNotice_title(notice_title);
		nvo.setNotice_cont(notice_cont);

		this.csService.insertNotice(nvo);

		return "/cs/notice";
	}


	//CS - FAQ
	@RequestMapping("/FAQ")
	public String FAQ(CSFAQVO cvo,Model model, HttpServletRequest request, HttpServletResponse response) {

		String faq_category = null;
		faq_category = request.getParameter("faq_category");

		List<CSFAQVO> clist = this.csService.getCSFAQList(faq_category);
		System.out.println(clist);
		model.addAttribute("clist", clist);
		return "/cs/FAQ";
	}

	//CS - FAQ 글 작성 VIEW
	@RequestMapping("/FAQ_write")
	public String FAQ_write(CSFAQVO cvo,Model model, HttpServletRequest request, HttpServletResponse response) {

		return "/cs/FAQ_write";
	}	

	//CS - FAQ 글 작성 OK
	@RequestMapping("/FAQ_write_ok")
	public String FAQ_write_ok(CSFAQVO cvo,Model model, HttpServletRequest request, HttpServletResponse response) {


		String faq_category=request.getParameter("faq_category");
		String faq_title=request.getParameter("faq_title");
		String faq_cont=request.getParameter("faq_cont");


		cvo.setFaq_title(faq_title);
		cvo.setFaq_cont(faq_cont);
		cvo.setFaq_category(faq_category);

		this.csService.insertFAQ(cvo);

		return "/cs/FAQ";
	}	

	//CS - 1:1문의
	@RequestMapping("/contact")
	public String contact(CSClientVO cvo, Model model, HttpServletRequest request, HttpServletResponse response) {

		List<CSClientVO> clist = this.csService.getCSClientList();

		request.setAttribute("clist", clist);
		System.out.println(clist);
		return "/cs/contact";
	}

	//CS - 1:1 문의글 작성 VIEW
	@RequestMapping("/contact_write")
	public String contact_write(CSClientVO cvo, Model model, HttpServletRequest request, HttpServletResponse response) {

		return "/cs/contact_write";
	}

	//CS - 1:1 문의글
	@RequestMapping("/contact_write_ok")
	public String contact_write_ok(CSClientVO cvo, Model model, HttpServletRequest request, HttpServletResponse response) {


		String user_id = request.getParameter("user_id");;
		String client_category = request.getParameter("client_category");
		String client_title = request.getParameter("reg-title");
		String client_cont = request.getParameter("editordata");

		cvo.setUser_id(user_id);
		cvo.setClient_category(client_category);
		cvo.setClient_title(client_title);
		cvo.setClient_cont(client_cont);


		this.csService.insertContact(cvo);//문의 저장

		List<CSClientVO> clist = this.csService.getCSClientList();

		request.setAttribute("clist", clist);
		System.out.println(clist);

		return "/cs/contact";
	}


}

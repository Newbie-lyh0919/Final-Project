package shop.HealthJava.controller;
//package shop.HealthJava.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import shop.HealthJava.service.AdminService;
//import shop.HealthJava.service.CSService;
//import shop.HealthJava.vo.CSClientVO;
//import shop.HealthJava.vo.MemberVO;
//import shop.HealthJava.vo.ProductQnAVO;
//import shop.HealthJava.vo.ProductVO;
//
//@Controller
//public class Admin_AjaxController_backup {
//
//	@Autowired
//	private AdminService adminService;
//
//	@Autowired
//	private CSService csService;
//	
//
//	/*회원 목록 AJAX
//	 * 
//	 */
//	//Ajax 회원관리 데이터 Response
//	@ResponseBody
//	@RequestMapping(value = "/member_search")
//	public List<MemberVO> member_search (Model model, MemberVO mvo, String search_field, String search_type) throws Exception{
//		
//		search_field = "%" + search_field + "%" ;
//		
//		//System.out.println("search_type : " + search_type);
//		//System.out.println("search_field : " + search_field);
//		
//		mvo.setSearch_type(search_type);
//		mvo.setSearch_field(search_field);
//			
//		List<MemberVO> mlist = this.adminService.getMemberListBySearch(mvo);			
//		//System.out.println(mlist);
//		model.addAttribute("mlist", mlist);
//		return mlist;
//	}
//	
//	@ResponseBody
//	@RequestMapping(value = "/CSBoard_search")
//	public List<CSClientVO> CSBoard_search (Model model, CSClientVO cvo, String search_field, String search_type) throws Exception{
//		
//		search_field = "%" + search_field + "%" ;
//		
//		//System.out.println("search_type : " + search_type);
//		//System.out.println("search_field : " + search_field);
//		
//		cvo.setSearch_type(search_type);
//		cvo.setSearch_field(search_field);
//		
//		List<CSClientVO> clist = this.adminService.getCSBoardListBySearch(cvo);			
//		//System.out.println(clist);
//		model.addAttribute("clist", clist);
//		return clist;
//	}
//	
//	@ResponseBody
//	@RequestMapping(value = "/product_search")
//	public List<ProductVO> product_search (Model model, ProductVO pvo, String search_field, String search_type) throws Exception{
//		
//		search_field = "%" + search_field + "%" ;
//		
//		//System.out.println("search_type : " + search_type);
//		//System.out.println("search_field : " + search_field);
//		
//		pvo.setSearch_type(search_type);
//		pvo.setSearch_field(search_field);
//		
//		List<ProductVO> plist = this.adminService.getProductListBySearch(pvo);			
//		//System.out.println(plist);
//		model.addAttribute("plist", plist);
//		return plist;
//	}
//	
//	@ResponseBody
//	@RequestMapping(value = "/GsQNA_search")
//	public List<ProductQnAVO> GsQNA_search (Model model, ProductQnAVO qvo, String search_field, String search_type) throws Exception{
//		
//		search_field = "%" + search_field + "%" ;
//		
//		//System.out.println("search_type : " + search_type);
//		//System.out.println("search_field : " + search_field);
//		
//		qvo.setSearch_type(search_type);
//		qvo.setSearch_field(search_field);
//		
//		List<ProductQnAVO> qlist = this.adminService.getGsQNAListBySearch(qvo);			
//		//System.out.println(clist);
//		model.addAttribute("qlist", qlist);
//		return qlist;
//	}
//	
////	@ResponseBody
////	@RequestMapping(value = "/contact_pwdCheck", method = RequestMethod.POST)
////	public boolean contact_pwdCheck(
////	  Model model,
////	  @RequestParam("contact_password") String contact_password,
////	  @RequestParam("client_no") String client_no
////	) throws Exception {
////	    boolean flag = false;
////
////	    System.out.println("contact_password=" +  contact_password);
////	    System.out.println(client_no);
////
////	    return flag;
////	}
////	
//
//}

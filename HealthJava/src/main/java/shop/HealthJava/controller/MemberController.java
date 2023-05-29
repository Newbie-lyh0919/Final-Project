package shop.HealthJava.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pwdconv.PwdChange;
import shop.HealthJava.service.MemberService;
import shop.HealthJava.vo.MemberVO;

@Controller
public class MemberController { // 사용자 관련 컨트롤러

	@Autowired
	private MemberService memberService;

	// 로그인 폼 
	@RequestMapping("/member_login") // 매핑 및 반환타입, 페이지 경로 예시
	public ModelAndView member_login() {
		// System.out.println("로그인 폼 접속 시도");
		ModelAndView member_login = new ModelAndView("member/member_login"); // 페이지 경로
		// System.out.println("로그인 폼 접속 완료");
		return member_login; // 페이지 경로 반환
	} // end member_login()

	// 회원가입 폼
	@RequestMapping("/member_join")
	public ModelAndView member_join() {
		//String[] phone = { "010", "011", "02" };
		//String[] email = { "naver.com", "daum.net", "nate.com", "gmail.com", "직접입력" };

		ModelAndView jm = new ModelAndView("member/member_join");
		//jm.addObject("phone", phone);
		//jm.addObject("email", email);
		//jm.setViewName("member/member_Join"); // 뷰페이지 경로(뷰리졸브 경로)=> /WEB-INF/views/member/member_Join.jsp
		return jm;
	} //end member_join()
	
	// 회원저장
	@RequestMapping("/member_join_ok")
	public ModelAndView member_join_ok(MemberVO m) {
		// member_join.jsp의 네임 피라미터 이름과 빈클래스의 변수명이 같으면 MemberVO m에서 m에 가입폼에서 입력한 정보가 저장되어 있다.
		
		m.setUser_pwd(PwdChange.getPassWordToXEMD5String(m.getUser_pwd()));// 비번 암호화
		this.memberService.insertMember(m); // 회원저장
		
		return new ModelAndView("redirect:/member_login");
	} //end member_join_ok()


	// 아이디 중복 검색 
	@RequestMapping("/member_idcheck")
	public ModelAndView member_idcheck(String id, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MemberVO db_id = this.memberService.idCheck(id); // 아이디에 해당하는 회원정보를 DB로 부터 검색
		
		int re = -1;// 중복 아이디가 없을때 반환값
		
		if (db_id != null) { // 중복 아이디가 있는 경우
			re = 1;
		}
		out.println(re);// 값 반환
		
		return null;
	} //end member_idcheck()
	
	/*	
	//비밀번호 찾기
	@RequestMapping("/pwd_find")
	public ModelAndView pwd_find() {
		return new ModelAndView("member/pwd_find");
	} // end pwd_find()

	// 비번찾기 결과
	@RequestMapping("/pwd_find_ok")
	public ModelAndView pwd_find_ok(@RequestParam("pwd_id") String pwd_id, String pwd_name, HttpServletResponse response, MemberVO m) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		m.setMem_id(pwd_id);
		m.setMem_name(pwd_name);
		MemberVO pm = this.memberService.pwdMember(m); // 아이디와 회원이름을 기준으로 DB로 부터 회원정보 검색
		// Q) 아이디와 회원이름을 기준으로 회원정보를 검색해 보는 pwdMember()메서드를 작성해 보자. select 아이디명은 p_find이다.

		//System.out.println("DB로 부터 검색한 회원이름:" + pm.getMem_name());		
		if(pm == null) { // 회원 정보가 없는 경우
			out.println("<script>");
			out.println("alert('회원으로 검색되지 않습니다.\\n 올바른 회원정보를 입력해주세요.');"); // \\n: 엔터키와 동일하다.
			out.println("history.back();");
			out.println("</script>");
		} else { // 회원 정보가 있는 경우 
			Random r = new Random(); //가독성이 더 좋아서 랜덤을 더 많이 쓴다고 함.
			int pwd_random = r.nextInt(100000); // 0 이상 100,000 미만 사이의 정수 숫자 난수를 발생
			String ran_pwd = Integer.toString(pwd_random); // 임시 정수 비번을 문자열로 변경 
			m.setMem_pwd(PwdChange.getPassWordToXEMD5String(ran_pwd)); // 임시 비번 암호화

			this.memberService.updatePwd(m); // 오라클 DB의 비번을 암호화된 임시비번으로 수정.
			// Q) 암호화된 임시 비번으로 수정되게 한다. update 아이디명은 p_edit로 하고, 개발자 test까지 완료 한다.

			ModelAndView fm = new ModelAndView("member/pwd_find_ok"); // 생성자 인자값으로 뷰페이지 경로와 파일명 설정
			fm.addObject("pwd_ran", ran_pwd); // 임시번호 저장
			System.out.println("아이디 : "+pwd_name+", 임시 번호 : "+ran_pwd);
			return fm;
		}
		return null;
	} // end pwd_find_ok()
	 */
	
	// 로그인 인증 처리
	@RequestMapping("/member_login_ok")
	public ModelAndView member_login_ok(String login_id, String login_pwd, HttpServletResponse response, HttpSession session) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		MemberVO m = this.memberService.loginCheck(login_id); // 아이디와  상태값이 2가 아닌 경우만 로그인 인증 처리

		if(m == null) { // 비회원일 경우
			out.println("<script>");
			out.println("alert('가입이 안된 회원입니다.');"); 
			out.println("history.back();");
			out.println("</script>");
		} else { // 회원인 경우

			// 비밀번호가 다른 경우
			if(!m.getUser_pwd().equals(PwdChange.getPassWordToXEMD5String(login_pwd))) {
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다.');"); 
				out.println("history.go(-1);");
				out.println("</script>");
			}else { // 비밀번호가 같은 경우
				session.setAttribute("id", login_id); //세션 id 키 이름에 아이디 저장

				return new ModelAndView("redirect:/myPage_Main");
			}

		}
		return null;
	} // end member_login_ok

	//로그 아웃 
	@RequestMapping("/member_logout")
	public ModelAndView member_logout(HttpServletResponse response, HttpSession session) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		session.invalidate(); // 세션 만료  : 로그아웃 처리 

		out.println("<script>");
		out.println("alert('로그아웃 되었습니다.');"); 
		out.println("location='member_login';");
		out.println("</script>");

		return null;
	} // end member_logout
	
	//id찾기
	@RequestMapping("/find_id")
	public ModelAndView pwd_find() {
		return new ModelAndView("member/find_id");
	} // end pwd_find()

	// id찾기 결과
	@RequestMapping("/find_id_ok")
	public ModelAndView find_id_ok(@RequestParam("username") String username, String userphone, HttpServletResponse response, MemberVO m) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		m.setUser_name(username);
		m.setUser_phone(userphone);
		MemberVO pm = this.memberService.idMember(m); // 아이디와 회원이름을 기준으로 DB로 부터 회원정보 검색
		// Q) 아이디와 회원이름을 기준으로 회원정보를 검색해 보는 pwdMember()메서드를 작성해 보자. select 아이디명은 p_find이다.

		//System.out.println("DB로 부터 검색한 회원이름:" + pm.getMem_name());		
		if(pm == null) { // 회원 정보가 없는 경우
			out.println("<script>");
			out.println("alert('회원으로 검색되지 않습니다.\\n 올바른 회원정보를 입력해주세요.');"); // \\n: 엔터키와 동일하다.
			out.println("history.back();");
			out.println("</script>");
		} else { // 회원 정보가 있는 경우 
			
			ModelAndView fm = new ModelAndView("member/find_id_ok"); // 생성자 인자값으로 뷰페이지 경로와 파일명 설정
			fm.addObject("findId", pm.getUser_id());
			System.out.println("아이디 : "+pm.getUser_id());
			return fm;
		}
		return null;
	} // end pwd_find_ok()

	// 회원 정보 수정폼  : MypageController로 이동
	@RequestMapping("/myPage_updateInfo")
	public ModelAndView member_edit(HttpServletResponse response, HttpSession session) throws Exception {
		response.setContentType("text/html;charset=UTF-8");

		String id = (String)session.getAttribute("id"); // 세션아이디를 구함

		if(isLogin(session, response)) { // 로그인 된 상태 : ture
			MemberVO em = this.memberService.getMember(id); // 아이디에 해당하는 회원정보를 구함
			ModelAndView m = new ModelAndView("mypage/myPage_updateInfo");
			
			m.addObject("em", em);
			return m;
		}
		return null;
	} // end member_edit
	
	// 정보 수정 완료 
	@RequestMapping("/member_update_ok")
	public ModelAndView member_update_ok(MemberVO m, HttpServletResponse response, HttpSession session) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id=(String)session.getAttribute("id");

		if(isLogin(session, response)) {
			m.setUser_id(id);
			//m.setUser_pwd(PwdChange.getPassWordToXEMD5String(m.getUser_pwd())); // 정식 비밀번호 암호화

			this.memberService.updateMember(m); // 회원 정보 수정

			out.println("<script>");
			out.println("alert('회원 정보 수정이 완료 되었습니다.');"); 
			out.println("location='myPage_updateInfo';");
			out.println("</script>");
		}

		return null;
	} // end member_update_ok

	//마이페이지 비밀번호 변경폼 : MypageController 로 이동
	@RequestMapping("/myPage_changePwd")
	public ModelAndView myPage_changePwd(HttpServletResponse response, HttpSession session) throws Exception {
		response.setContentType("text/html;charset=UTF-8");

		String id = (String)session.getAttribute("id"); // 세션아이디를 구함

		if(isLogin(session, response)) { // 로그인 된 상태 : ture
			MemberVO em = this.memberService.getMember(id); // 아이디에 해당하는 회원정보를 구함
			ModelAndView m = new ModelAndView("mypage/myPage_changePwd");
			
			//m.addObject("em", em);

			return m;
		}

		return null;
	}
	
	/*
	//마이페이지 비밀번호 변경완료
	@RequestMapping("/changePwd_ok")
	public ModelAndView myPage_changePwd_ok(HttpServletRequest request, HttpServletResponse response, HttpSession session, String user_pwd ) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = (String)session.getAttribute("id"); // 세션아이디를 구함
		
		if(isLogin(session, response)) { // 로그인 된 상태 : ture
			user_pwd = PwdChange.getPassWordToXEMD5String(user_pwd);//비밀번호 암호화
			MemberVO db_pwd = this.memberService.getMember(id);//db에 저장되있는 id에 해당하는 pwd
			
			if(!db_pwd.getUser_pwd().equals(user_pwd)) {
				out.println("<script>");
				out.println("alert('비밀번호가 다릅니다!');"); 
				out.println("history.back();");
				out.println("</script>");
			} else {
				//MemberVO dm = new MemberVO();
				//dm.setUser_id(id);
				
				this.memberService.updatePwd(id);//비밀번호 수정

				out.println("<script>");
				out.println("alert('비밀번호 수정이 완료 되었습니다.');"); 
				out.println("location='myPage_changePwd';");
				out.println("</script>");

			}
			
		}		
		return null;
	}
	*/
	
	// 비밀번호 수정 완료 
	@RequestMapping("/changePwd_ok")
	public ModelAndView myPage_changePwd_ok(MemberVO m, HttpServletResponse response, HttpSession session, String user_pwd, String new_pwd ) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id=(String)session.getAttribute("id");

		if(isLogin(session, response)) {
			user_pwd = PwdChange.getPassWordToXEMD5String(user_pwd);//비밀번호 암호화
			//m.setUser_id(id);
			m.setUser_pwd(PwdChange.getPassWordToXEMD5String(m.getUser_pwd())); // 정식 비밀번호 암호화
			MemberVO db_pwd = this.memberService.getMember(id);//db에 저장되있는 id에 해당하는 pwd
			if(!db_pwd.getUser_pwd().equals(user_pwd)) {
				out.println("<script>");
				out.println("alert('비밀번호가 다릅니다!');"); 
				out.println("history.back();");
				out.println("</script>");
			} else {
				//MemberVO dm = new MemberVO();
				m.setUser_id(id);
				new_pwd = PwdChange.getPassWordToXEMD5String(new_pwd);//비밀번호 암호화
				m.setUser_pwd(new_pwd);
				this.memberService.updatePwd(m); // 회원 정보 수정

				out.println("<script>");
				out.println("alert('비밀번호 수정이 완료 되었습니다.');"); 
				out.println("location='myPage_changePwd';");
				out.println("</script>");

			}

		}
		return null;
	} // end myPage_changePwd_ok
	
	// 회원 탈퇴
	@RequestMapping("/myPage_user_Withdrawal")
	public ModelAndView member_del(HttpSession session, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = (String)session.getAttribute("id"); // 세션아이디를 구함

		if(id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요.');"); 
			out.println("location='member_login';");
			out.println("</script>");
		} else {
			MemberVO dm = this.memberService.getMember(id);

			ModelAndView m = new ModelAndView("mypage/myPage_user_Withdrawal");
			m.addObject("dm", dm);
			return m;
		}

		return null;
	}//member_del()
	
	
	//회원탈퇴 완료
	@RequestMapping("/user_Withdrawal_ok")
	public ModelAndView member_del_ok(HttpServletResponse response, HttpSession session,
			String user_pwd, String del_cont) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요.');"); 
			out.println("location='member_login';");
			out.println("</script>");
		} else {
			user_pwd = PwdChange.getPassWordToXEMD5String(user_pwd);//비밀번호 암호화
			MemberVO db_pwd = this.memberService.getMember(id);
			
			if(!db_pwd.getUser_pwd().equals(user_pwd)) {
				out.println("<script>");
				out.println("alert('비밀번호가 다릅니다!');"); 
				out.println("history.back();");
				out.println("</script>");
			} else {
				MemberVO dm = new MemberVO();
				dm.setUser_id(id);
				dm.setDel_cont(del_cont);
				
				this.memberService.delMem(dm);//회원탈퇴

				session.invalidate();//세션만료
				
				out.println("<script>");
				out.println("alert('회원탈퇴했습니다!');"); 
				out.println("location='member_login'");
				out.println("</script>");
			}
		}		
		return null;
	}//member_del_ok()


	// 로그인을 하지 않은 상황에서 주소창을 쳐서 들어가는것을 막고 로그인페이지로 넘기기
	public static boolean isLogin(HttpSession session, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		String id = (String)session.getAttribute("id"); // 세션아이디를 구함

		if(id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요.');"); 
			out.println("location='member_login';");
			out.println("</script>");
			return false;
		}
		return true; // 로그인 된 경우 
	} // end isLogin
	
}

package shop.HealthJava.service;

import shop.HealthJava.vo.MemberVO;

public interface MemberService {

	void insertMember(MemberVO m);//회원저장

	MemberVO idCheck(String id);	//아이디중복검색

	MemberVO loginCheck(String login_id); //로그인 인증

	MemberVO idMember(MemberVO m); //id찾기

	MemberVO getMember(String id); //회원정보 불러오기

	void updateMember(MemberVO m); //회원정보수정완료

	void delMem(MemberVO dm); //회원탈퇴

	void updatePwd(MemberVO m); //비밀번호 수정

}

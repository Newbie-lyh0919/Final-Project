package shop.HealthJava.dao;

import shop.HealthJava.vo.MemberVO;

public interface MemberDAO {
	void insertMember(MemberVO m);//회원저장

	MemberVO idCheck(String id);	//아이디에 해당하는 회원정보검색

	MemberVO loginCheck(String login_id);//로그인 인증

	MemberVO findId(MemberVO m); //id찾기

	MemberVO getMember(String id);//회원정보 불러오기


}

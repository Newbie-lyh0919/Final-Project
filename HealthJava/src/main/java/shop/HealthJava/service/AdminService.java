package shop.HealthJava.service;

import java.util.List;

import shop.HealthJava.vo.CSClientVO;
import shop.HealthJava.vo.MemberVO;
import shop.HealthJava.vo.ProductVO;

public interface AdminService{
	
	//관리자 - 회원 리스트 조회
	List<MemberVO> getMemberListBySearch(MemberVO mvo);

	//관리자 - 검색에 따른 회원수
	int getMemberCount(MemberVO mvo);

	//관리자 - 회원번호에 따른 정보조회
	MemberVO getMemberInfo(int user_no);
	
	//관리자 - 회원정보 수정
	void MemberEdit(MemberVO mvo);

	//관리자 - 검색에 따른 상품수
	int getProductCount(ProductVO pvo);

	//관리자 - 상품 리스트 조회
	List<ProductVO> getProductListBySearch(ProductVO pvo);

	//관리자 - 문의게시판 글 개수
	int getCSBoardCount(CSClientVO cvo);
	
	//관리자 - 문의게시판 리스트 조회
	List<CSClientVO> getCSBoardListBySearch(CSClientVO cvo);

	//관리자 - 문의게시판 내용보기
	CSClientVO getClientCont(int client_no);

	//관리자 - 문의게시판 댓글ok
	void replyBoard(CSClientVO cvo);
	
	//관리자 - 회원유형 수정(블랙리스트)
	void MemberBlack(MemberVO mvo);

}

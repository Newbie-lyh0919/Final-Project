package shop.HealthJava.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.HealthJava.vo.CSClientVO;
import shop.HealthJava.vo.MemberVO;
import shop.HealthJava.vo.ProductVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private SqlSession sqlSession;

	//관리자 - 회원 정보 조회
	@Override
	public List<MemberVO> getMemberListBySearch(MemberVO mvo) {
		return this.sqlSession.selectList("member_list", mvo);
	}
	
	//관리자 - 검색에 따른 회원수
	@Override
	public int getMemberCount(MemberVO mvo) {
		return this.sqlSession.selectOne("member_count", mvo);
	}
	
	//관리자 - 회원번호에 따른 정보조회
	@Override
	public MemberVO getMemberInfo(int user_no) {
		return this.sqlSession.selectOne("member_info", user_no);
	}

	//관리자 - 회원정보 수정
	@Override
	public void MemberEdit(MemberVO mvo) {
		this.sqlSession.update("member_edit", mvo);
	}

	//관리자 - 검색에 따른 상품수
	@Override
	public int getProductCount(ProductVO pvo) {
		return this.sqlSession.selectOne("product_count", pvo);
	}

	//관리자 - 상품 리스트 조회
	@Override
	public List<ProductVO> getProductListBySearch(ProductVO pvo) {
		return this.sqlSession.selectList("product_list", pvo);
	}

	//관리자 - 문의게시판 글 개수
	@Override
	public int getCSBoardCount(CSClientVO cvo) {
		return this.sqlSession.selectOne("CSBoard_count", cvo);
	}

	//관리자 - 문의게시판 리스트 조회
	@Override
	public List<CSClientVO> getCSBoardListBySearch(CSClientVO cvo) {
		return this.sqlSession.selectList("CSBoard_list", cvo);
	}

	//관리자 - 문의게시판 내용보기
	@Override
	public CSClientVO getClientCont(int client_no) {
		return this.sqlSession.selectOne("CSBoard_cont", client_no);
	}

	//관리자 - 문의게시판 댓글ok
	@Override
	public void replyBoard(CSClientVO cvo) {
		this.sqlSession.update("CSBoard_reply", cvo);
	}

	@Override
	public void MemberBlack(MemberVO mvo) {
		this.sqlSession.update("member_black", mvo);
	}
}

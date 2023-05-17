package shop.HealthJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.HealthJava.dao.AdminDAO;
import shop.HealthJava.vo.CSClientVO;
import shop.HealthJava.vo.MemberVO;
import shop.HealthJava.vo.ProductVO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDao;
	
	//관리자 - 회원 정보 조회
	@Override
	public List<MemberVO> getMemberListBySearch(MemberVO mvo) {
		return this.adminDao.getMemberListBySearch(mvo);
	}

	//관리자 - 검색에 따른 회원수
	@Override
	public int getMemberCount(MemberVO mvo) {
		return this.adminDao.getMemberCount(mvo);
	}

	//관리자 - 회원번호에 따른 정보조회
	@Override
	public MemberVO getMemberInfo(int user_no) {
		return this.adminDao.getMemberInfo(user_no);
	}

	//관리자 - 회원정보 수정
	@Override
	public void MemberEdit(MemberVO mvo) {
		this.adminDao.MemberEdit(mvo);
	}

	//관리자 - 검색에 따른 상품수
	@Override
	public int getProductCount(ProductVO pvo) {
		return this.adminDao.getProductCount(pvo);
	}

	//관리자 - 상품 리스트 조회
	@Override
	public List<ProductVO> getProductListBySearch(ProductVO pvo) {
		return this.adminDao.getProductListBySearch(pvo);
	}

	//관리자 - 문의게시판 글 개수
	@Override
	public int getCSBoardCount(CSClientVO cvo) {
		return this.adminDao.getCSBoardCount(cvo);
	}

	//관리자 - 문의게시판 리스트 조회
	@Override
	public List<CSClientVO> getCSBoardListBySearch(CSClientVO cvo) {
		return this.adminDao.getCSBoardListBySearch(cvo);
	}

	//관리자 - 문의게시판 내용보기
	@Override
	public CSClientVO getClientCont(int client_no) {
		return this.adminDao.getClientCont(client_no);
	}

	//관리자 - 문의게시판 댓글ok
	@Override
	public void replyBoard(CSClientVO cvo) {
		this.adminDao.replyBoard(cvo);
	}

	//관리자 - 회원유형 수정(블랙리스트)
	@Override
	public void MemberBlack(MemberVO mvo) {
		this.adminDao.MemberBlack(mvo);
	}
}

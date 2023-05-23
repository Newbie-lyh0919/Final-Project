package shop.HealthJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.HealthJava.dao.MypageDAO;
import shop.HealthJava.vo.AddrVO;
import shop.HealthJava.vo.CartVO;
import shop.HealthJava.vo.LikeVO;
import shop.HealthJava.vo.MemberVO;
import shop.HealthJava.vo.OrderDetailVO;
import shop.HealthJava.vo.OrderVO;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	private MypageDAO mypageDao;
	
	// 주문 내역 list
	@Override
	public List<OrderVO> getOrderList(OrderVO ovo) {
		return this.mypageDao.getOrderList(ovo);
	}

	// 총 주문 건수
	@Override
	public int getOrderCount(OrderVO ovo) {
		return this.mypageDao.getOrderCount(ovo);
	}

	// 주문상세 내역 list order_no 기준
	@Override
	public List<OrderDetailVO> getOrderDetailList(OrderDetailVO odv) {
		return this.mypageDao.getOrderDetailList(odv);
	}

	// 찜목록 조회
	@Override
	public List<LikeVO> getLikeProductsList(LikeVO lv) {
		return this.mypageDao.getLikeProductList(lv);
	}

	// 장바구니 목록 조회
	@Override
	public List<CartVO> getCartList(CartVO cvo) {
		return this.mypageDao.getCartList(cvo);
	}

	// 배송지 리스트 조회
	@Override
	public List<MemberVO> getMemberAddrList(MemberVO mvo) {
		return this.mypageDao.getMemberAddrList(mvo);
	}

	//배송지 추가
	@Override
	public void insertAddr(AddrVO av) {
		this.mypageDao.insertAddr(av);
	}

	 // 배송지 추가 리스트 조회
	@Override
	public List<AddrVO> getAddrList(AddrVO avo) {
		return this.mypageDao.getAddrList(avo);
	}

	//장바구니 삭제
	@Override
	public void delCartList(CartVO cvo) {
		this.mypageDao.deleteCart(cvo);
		
	}

	//장바구니 전체삭제
	@Override
	public void delallCartList(CartVO cvo) {
		this.mypageDao.deleteAllCart(cvo);
		
	}

	//배송지 수정조회
	@Override
	public AddrVO getOneAddr(int addr_no) {
		return this.mypageDao.selectOneAddr(addr_no);
		
	}

	//추가배송지 수정
	@Override
	public void updateAddr(AddrVO avo) {
		this.mypageDao.updateAddr(avo);
		
	}

	//추가 배송지 삭제
	@Override
	public void deleteAddr(int addr_no) {
		this.mypageDao.deleteAddr(addr_no);
		
	}

}

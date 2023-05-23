package shop.HealthJava.dao;

import java.util.List;

import shop.HealthJava.vo.AddrVO;
import shop.HealthJava.vo.CartVO;
import shop.HealthJava.vo.LikeVO;
import shop.HealthJava.vo.MemberVO;
import shop.HealthJava.vo.OrderDetailVO;
import shop.HealthJava.vo.OrderVO;

public interface MypageDAO {

	List<OrderVO> getOrderList(OrderVO ovo); // 주문 내역 list
	int getOrderCount(OrderVO ovo); // 총 주문 건수
	List<OrderDetailVO> getOrderDetailList(OrderDetailVO odv); // 주문상세 내역 list order_no 기준
	
	List<LikeVO> getLikeProductList(LikeVO lv); // 찜목록 조회	
	
	List<CartVO> getCartList(CartVO cvo); // 장바구니 목록 조회
	
	List<MemberVO> getMemberAddrList(MemberVO mvo); // 배송지 리스트
	void insertAddr(AddrVO av); //배송지 추가
	List<AddrVO> getAddrList(AddrVO avo); // 배송지 추가 리스트 조회
	void deleteCart(CartVO cvo); //장바구니 삭제
	void deleteAllCart(CartVO cvo); //장바구니 전체삭제
	AddrVO selectOneAddr(int addr_no); //추가배송지 수정조회
	void updateAddr(AddrVO avo); //추가배송지 수정
	void deleteAddr(int addr_no); //추가배송지 삭제
	
}

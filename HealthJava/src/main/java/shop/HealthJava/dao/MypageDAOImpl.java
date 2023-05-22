package shop.HealthJava.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.HealthJava.vo.AddrVO;
import shop.HealthJava.vo.CartVO;
import shop.HealthJava.vo.LikeVO;
import shop.HealthJava.vo.MemberVO;
import shop.HealthJava.vo.OrderDetailVO;
import shop.HealthJava.vo.OrderVO;

@Repository
public class MypageDAOImpl implements MypageDAO {
	
	@Autowired
	private SqlSession sqlSession;

	// 주문 내역 list
	@Override
	public List<OrderVO> getOrderList(OrderVO ovo) {
		return this.sqlSession.selectList("order_list", ovo);
	}

	// 총 주문 건수
	@Override
	public int getOrderCount(OrderVO ovo) {
		return this.sqlSession.selectOne("order_count", ovo);
	}

	// 주문상세 내역 list order_no 기준
	@Override
	public List<OrderDetailVO> getOrderDetailList(OrderDetailVO odv) {
		return this.sqlSession.selectList("orderDetail_list", odv);
	}

	// 찜목록 조회
	@Override
	public List<LikeVO> getLikeProductList(LikeVO lv) {
		return this.sqlSession.selectList("likeP_list", lv);
	}
	
	// 장바구니 목록 조회
	@Override
	public List<CartVO> getCartList(CartVO cvo) {
		return this.sqlSession.selectList("cart_list", cvo);
	}

	// 배송지 리스트 조회
	@Override
	public List<MemberVO> getMemberAddrList(MemberVO mvo) {
		return this.sqlSession.selectList("memAddr_list", mvo);
	}

	//배송지 추가
	@Override
	public void insertAddr(AddrVO av) {
		this.sqlSession.insert("addr_in",av);
	}

	 // 배송지 추가 리스트 조회
	@Override
	public List<AddrVO> getAddrList(AddrVO avo) {
		return this.sqlSession.selectList("addr_list", avo);
	}

	
}

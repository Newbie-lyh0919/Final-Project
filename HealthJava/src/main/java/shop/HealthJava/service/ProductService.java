package shop.HealthJava.service;

import java.util.List;

import shop.HealthJava.vo.CartVO;
import shop.HealthJava.vo.LikeVO;
import shop.HealthJava.vo.OrderDetailVO;
import shop.HealthJava.vo.ProductVO;
import shop.HealthJava.vo.ProductVO2;

public interface ProductService {
	
	
	ProductVO getProductContent(int product_no);

	void insertProduct(ProductVO f);

	void deleteProduct(int product_no);

	void updateProduct(ProductVO f);


	public List<ProductVO2> getReviewList(int product_no);

	void insertQna(ProductVO2 f);

	void insertLike(LikeVO f);

	void deleteLike(LikeVO f);

	LikeVO getLikeList(LikeVO f);

	void insertCart(CartVO c);

	void insertOrderDetail(OrderDetailVO o);

	List<ProductVO> getListNew(ProductVO f, String kind, String kind2);
}

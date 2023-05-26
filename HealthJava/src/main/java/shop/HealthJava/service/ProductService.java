package shop.HealthJava.service;

import java.util.List;

import shop.HealthJava.vo.CartVO;
import shop.HealthJava.vo.LikeVO;
import shop.HealthJava.vo.OrderDetailVO;
import shop.HealthJava.vo.ProductVO;
import shop.HealthJava.vo.ProductVO2;

public interface ProductService {
	
	List<ProductVO> getProductListByKind(String type);
	
	List<ProductVO> getProductListByKind1(String type);

	ProductVO getProductContent(int product_no);

	void insertProduct(ProductVO f);

	void deleteProduct(int product_no);

	void updateProduct(ProductVO f);

	List<ProductVO> getProductListByKind2(String kind);

	List<ProductVO> getProductListByKind3(String kind);
	
	List<ProductVO> getProductListByKind4(String kind);

	List<ProductVO> getProductListByKind5(String kind);

	int getListCount(ProductVO b);
	
	List<ProductVO> getProductList(ProductVO b);

	int getListCount1(String kind);

	List<ProductVO> getProductList1(ProductVO b);
	
	List<ProductVO> getProductList2(ProductVO b);
	
	List<ProductVO> getProductList3(ProductVO b);
	
	List<ProductVO> getProductList4(ProductVO b);
	
	List<ProductVO> getProductList5(ProductVO b);

	
	List<ProductVO> searchProductList(ProductVO f);
	
	
	
	public List<ProductVO2> getReviewList(int product_no);

	void insertQna(ProductVO2 f);

	void insertLike(LikeVO f);

	void deleteLike(LikeVO f);

	LikeVO getLikeList(LikeVO f);

	void insertCart(CartVO c);

	void insertOrderDetail(OrderDetailVO o);
}

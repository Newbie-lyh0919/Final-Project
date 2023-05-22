package shop.HealthJava.dao;

import java.util.List;

import shop.HealthJava.vo.ProductVO;

public interface ProductDAO {
	
	List<ProductVO> getProductListByKind(String type);
	
	List<ProductVO> getProductListByKind1(String type2);

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
	
	int count(ProductVO f);
}
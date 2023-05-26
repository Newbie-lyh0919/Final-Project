package shop.HealthJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.HealthJava.dao.ProductDAO;
import shop.HealthJava.vo.CartVO;
import shop.HealthJava.vo.LikeVO;
import shop.HealthJava.vo.OrderDetailVO;
import shop.HealthJava.vo.ProductVO;
import shop.HealthJava.vo.ProductVO2;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDao;

	@Override
	public List<ProductVO> getProductListByKind(String kind) {
		
		return this.productDao.getProductListByKind(kind);
	}
	
	@Override
	public List<ProductVO> getProductListByKind1(String kind) {
		
		return this.productDao.getProductListByKind1(kind);
	}

	@Override
	public ProductVO getProductContent(int product_no) {
		
		return this.productDao.getProductContent(product_no);
	}

	@Override
	public void insertProduct(ProductVO f) {
		
		this.productDao.insertProduct(f);
		
	}

	@Override
	public void deleteProduct(int product_no) {
		this.productDao.deleteProduct(product_no);
		
	}

	@Override
	public void updateProduct(ProductVO f) {
		this.productDao.updateProduct(f);
		
	}

	@Override
	public List<ProductVO> getProductListByKind2(String kind) {
		// TODO Auto-generated method stub
		return this.productDao.getProductListByKind2(kind);
	}

	@Override
	public List<ProductVO> getProductListByKind3(String kind) {
		// TODO Auto-generated method stub
		return this.productDao.getProductListByKind3(kind);
	}

	@Override
	public List<ProductVO> getProductListByKind4(String kind) {
		// TODO Auto-generated method stub
		return this.productDao.getProductListByKind4(kind);
	}
	@Override
	public List<ProductVO> getProductListByKind5(String kind) {
		// TODO Auto-generated method stub
		return this.productDao.getProductListByKind5(kind);
	}

	@Override
	public int getListCount(ProductVO b) {
		// TODO Auto-generated method stub
		return this.productDao.getListCount(b);
	}
	
	

	@Override
	public List<ProductVO> getProductList(ProductVO b) {
		// TODO Auto-generated method stub
		return this.productDao.getProductList(b);
	}

	@Override
	public int getListCount1(String kind) {
		// TODO Auto-generated method stub
		return this.productDao.getListCount1(kind);
	}

	@Override
	public List<ProductVO> getProductList1(ProductVO b) {
		// TODO Auto-generated method stub
		return this.productDao.getProductList1(b);
	}
	
	@Override
	public List<ProductVO> getProductList2(ProductVO b) {
		// TODO Auto-generated method stub
		return this.productDao.getProductList2(b);
	}
	
	@Override
	public List<ProductVO> getProductList3(ProductVO b) {
		// TODO Auto-generated method stub
		return this.productDao.getProductList3(b);
	}
	
	@Override
	public List<ProductVO> getProductList4(ProductVO b) {
		// TODO Auto-generated method stub
		return this.productDao.getProductList4(b);
	}
	
	@Override
	public List<ProductVO> getProductList5(ProductVO b) {
		// TODO Auto-generated method stub
		return this.productDao.getProductList5(b);
	}
	
	@Override
	public List<ProductVO> searchProductList(ProductVO f) {
		return this.productDao.searchProductList(f);
	}
	
	

	@Override
	public List<ProductVO2> getReviewList(int product_no) {
		// TODO Auto-generated method stub
		return this.productDao.getReviewList(product_no);
	}

	@Override
	public void insertQna(ProductVO2 f) {
		// TODO Auto-generated method stub
		this.productDao.insertQna(f);
	}

	@Override
	public void insertLike(LikeVO f) {
		this.productDao.insertLike(f);
		
	}

	@Override
	public void deleteLike(LikeVO f) {
		this.productDao.deldteLike(f);
		
	}

	@Override
	public LikeVO getLikeList(LikeVO f) {
		// TODO Auto-generated method stub
		return this.productDao.getLikeList(f);
	}

	@Override
	public void insertCart(CartVO c ) {
		this.productDao.insertCart(c);
		
	}

	@Override
	public void insertOrderDetail(OrderDetailVO o) {
		this.productDao.insertOrderDetail(o);
		
	}
	
}

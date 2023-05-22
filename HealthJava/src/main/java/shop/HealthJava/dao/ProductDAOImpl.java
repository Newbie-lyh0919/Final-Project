package shop.HealthJava.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.HealthJava.vo.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ProductVO> getProductListByKind(String kind) {
		
		return sqlSession.selectList("product_list",kind);	
	
	
	}
	
	@Override
	public List<ProductVO> getProductListByKind1(String kind) {
		
		return sqlSession.selectList("product_list1",kind);	
	
	
	}

	@Override
	public ProductVO getProductContent(int product_no) {
		
		return sqlSession.selectOne("product_content",product_no);
	}

	@Override
	public void insertProduct(ProductVO f) {
		
		sqlSession.insert("product_insert",f);
	}

	@Override
	public void deleteProduct(int product_no) {
		sqlSession.delete("product_delete", product_no);
		
	}

	@Override
	public void updateProduct(ProductVO f) {
		sqlSession.update("product_update",f);
		
	}

	@Override
	public List<ProductVO> getProductListByKind2(String kind) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_list2",kind);
	}
	
	@Override
	public List<ProductVO> getProductListByKind3(String kind) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_list3",kind);
	}
	
	@Override
	public List<ProductVO> getProductListByKind4(String kind) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_list4",kind);
	}
	
	@Override
	public List<ProductVO> getProductListByKind5(String kind) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_list5",kind);
	}

	
	@Override
	public int getListCount(ProductVO b) {
		return this.sqlSession.selectOne("product_count_all",b);
		//selectOne() 메서드는 단 한개의 레코드만 반환. board_row는
		//select 아이디명		
	}//총레코드 개수
	
	@Override
	public int getListCount1(String kind) {
		return this.sqlSession.selectOne("product_count1",kind);
		//selectOne() 메서드는 단 한개의 레코드만 반환. board_row는
		//select 아이디명		
	}//총레코드 개수
	
	@Override
	public List<ProductVO> getProductList(ProductVO b) {
		return this.sqlSession.selectList("product_list_test",b);
		//selectList()메서드는 복수개의 레코드를 검색해서 컬렉션 List로
		//반환한다. select 아이디명 board_li		
	}//게시판 목록
	
	@Override
	public List<ProductVO> getProductList1(ProductVO b) {
		return this.sqlSession.selectList("product_list_test1",b);
		//selectList()메서드는 복수개의 레코드를 검색해서 컬렉션 List로
		//반환한다. select 아이디명 board_li		
	}//게시판 목록
	
	@Override
	public List<ProductVO> searchProductList(ProductVO f) {
		return this.sqlSession.selectList("searchProductList", f);
	}

	@Override
	public List<ProductVO> getProductList2(ProductVO b) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_list_test2",b);
	}

	@Override
	public List<ProductVO> getProductList3(ProductVO b) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_list_test3",b);
	}

	@Override
	public List<ProductVO> getProductList4(ProductVO b) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_list_test4",b);
	}

	@Override
	public List<ProductVO> getProductList5(ProductVO b) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_list_test5",b);
	}
	
	
	@Override
	public int count(ProductVO f) {
		return this.sqlSession.selectOne("count", f);
	}
	
}

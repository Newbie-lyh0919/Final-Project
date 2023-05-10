package shop.HealthJava.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Mypage2DAOImpl implements Mypage2DAO {
	
	@Autowired
	private SqlSession sqlSession;

}

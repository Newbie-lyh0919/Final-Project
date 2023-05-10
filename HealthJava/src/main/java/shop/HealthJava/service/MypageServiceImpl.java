package shop.HealthJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.HealthJava.dao.Mypage2DAO;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	private Mypage2DAO mypage2Dao;
}

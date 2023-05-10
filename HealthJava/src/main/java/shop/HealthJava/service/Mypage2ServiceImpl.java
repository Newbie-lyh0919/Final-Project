package shop.HealthJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.HealthJava.dao.MypageDAO;

@Service
public class Mypage2ServiceImpl implements Mypage2Service {
	
	@Autowired
	private MypageDAO mypageDao;
}

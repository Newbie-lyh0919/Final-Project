package shop.HealthJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.HealthJava.dao.MemberDAO;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDao;
}

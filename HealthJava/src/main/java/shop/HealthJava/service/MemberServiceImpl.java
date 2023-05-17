package shop.HealthJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.HealthJava.dao.MemberDAO;
import shop.HealthJava.vo.MemberVO;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDao;

	//회원저장
	@Override
	public void insertMember(MemberVO m) {
		this.memberDao.insertMember(m);
	}

	//아이디중복 검색
	@Override
	public MemberVO idCheck(String id) {
		return this.memberDao.idCheck(id);
	}

	//로그인 인증
	@Override
	public MemberVO loginCheck(String login_id) {
		return this.memberDao.loginCheck(login_id);
	}

	//id찾기
	@Override
	public MemberVO idMember(MemberVO m) {
		return this.memberDao.findId(m);
	}

	//회원정보 불러오기
	@Override
	public MemberVO getMember(String id) {
		return this.memberDao.getMember(id);
	}

	
}

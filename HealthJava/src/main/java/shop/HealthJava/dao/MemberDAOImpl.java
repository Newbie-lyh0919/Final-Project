package shop.HealthJava.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.HealthJava.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	//회원가입
	@Override
	public void insertMember(MemberVO m) {
		this.sqlSession.insert("m_insert", m);
	}

	//아이디중복체크
	@Override
	public MemberVO idCheck(String id) {
		return this.sqlSession.selectOne("m_idCheck", id);
	}

	//로그인
	@Override
	public MemberVO loginCheck(String login_id) {
		return this.sqlSession.selectOne("m_loginCheck", login_id);
	}

	//id찾기
	@Override
	public MemberVO findId(MemberVO m) {
		return this.sqlSession.selectOne("m_findId", m);
	}

	//회원정보 불러오기
	@Override
	public MemberVO getMember(String id) {
		return this.sqlSession.selectOne("m_info", id);
	}

	//회원정보수정
	@Override
	public void updateMember(MemberVO m) {
		this.sqlSession.update("edit_ok", m);
	}

	//회원탈퇴
	@Override
	public void delMem(MemberVO dm) {
		this.sqlSession.update("m_del_ok", dm);
	}

	//비밀번호 수정
	@Override
	public void updatePwd(MemberVO m) {
		this.sqlSession.update("change_pwd", m);
	}


}

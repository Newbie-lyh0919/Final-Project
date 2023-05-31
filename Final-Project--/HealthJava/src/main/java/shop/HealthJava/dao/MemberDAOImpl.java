package shop.HealthJava.dao;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import shop.HealthJava.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

   @Autowired
   private SqlSession sqlSession;
   //회원가입
   @Override
   public void insertMember(MemberVO m) {
      System.out.println("db전까지 성공");
      this.sqlSession.insert("m_insert", m);
      System.out.println("db후까지 성공");
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
      this.sqlSession.update("update_pwd", m);
   }

   @Override
   public int updateMailAuth(MemberVO memberVo) {
      return this.sqlSession.update("updateMailAuth", memberVo);
   }


   @Override
   public int updateMailKey(MemberVO memberVo) {
      return this.sqlSession.update("updateMailKey", memberVo);
   }

    @Override
    public MemberVO getMemberByEmail(String user_email) {
        return sqlSession.selectOne("getMemberByEmail", user_email);
    }
 
   @Override
   public int searchEmail(Object user_email) {
      String user_mail = (String) user_email;
      return this.sqlSession.selectOne("searchEmail", user_email);
   }

   //이메일 기준으로 카카오 회원 아이디 가져오기
   @Override
   public String getIdKakao(Object user_email) {
      String user_mail = (String) user_email;
      return this.sqlSession.selectOne("getIdKakao", user_email);
   }

   @Override
   public MemberVO emailCheck(String user_email) {
      return this.sqlSession.selectOne("emailCheck", user_email);
   }

}
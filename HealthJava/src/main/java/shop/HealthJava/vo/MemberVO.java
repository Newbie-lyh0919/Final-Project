package shop.HealthJava.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO { /* 되도록이면 member 테이블 컬럼명과 일치하는 빈클래스 변수명을 정의, 데이터 저장빈 클래스 */

	private String user_id; // 회원아이디
	private String user_pwd; // 비번
	private String user_token; // null:일반회원, not null:카카오회원
	private String user_name; // 회원이름
	private String user_birth; // 회원생년월일
	private String user_gender; // 회원성별
	private String postcode; // 우편번호
	private String roadAddr; // 도로명주소
	private String detailAddr; // 상세주소
	private String user_email; // 회원이메일
	//private String mail_domain;//메일 도메인 !!!!추가할지 고민중
	private String user_phone; // 폰번호
	private int user_state = 0; // 가입회원이면 0, 블랙리스트 1, 탈퇴회원이면 2
	private int user_grade = 0; // 사용자등급(일반0, 관리자1)
	private String join_date; // 가입날짜
	private String del_date; // 탈퇴날짜
	private String del_cont; // 탈퇴사유
/*
	// 관리자 회원목록에서 페이징(쪽나누기) 관련변수
	private int startrow; // 시작행 번호
	private int endrow; // 끝행번호

	// 관리자 회원목록에서 검색기능 관련변수->검색필드와 검색어
	private String find_name; // 검색어
	private String find_field; // 검색 필드
*/
}

/*
    user_no number(38)  PRIMARY KEY -- 회원 수(unique)
    , user_id varchar2(100) -- 회원 아이디
    , user_pwd varchar2(100) -- 회원 비밀번호
    , user_token varchar2(100) -- null: 일반회원 not null: 카카오회원
    , user_name varchar2(100) -- 회원 이름
    , user_birth varchar2(100) -- 회원 생년월일
    , user_gender varchar2(50) -- 회원 성별
    , postcode varchar2(100) -- 회원 우편번호
    , roadAddr varchar2(100) -- 회원 도로명 주소
    , detailAddr varchar2(100) -- 회원 상세 주소
    , user_email varchar2(100) -- 회원 이메일
    , user_phone varchar2(100) -- 회원 휴대폰번호
    , user_state number(38) default 0 -- 회원 0, 블랙리스트 1, 탈퇴회원 2
    , user_grade number(38) default 0 -- 사용자 등급(일반 사용자 0, 관리자 1)
    , join_date date -- 가입 날짜(sysdate)
    , del_date date -- 탈퇴 날짜(sysdate)
    , del_cont varchar2(2000) -- 탈퇴사유

*/
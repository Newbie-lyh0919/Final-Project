-- 회원 table 
CREATE TABLE tbl_member(
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
);

-- 삭제 DROP table tbl_member;

-- 멤버 시퀀스
create sequence user_no_seq
    start with 1
    increment by 1
    nocache;

-- 시퀀스 삭제 DROP SEQUENCE user_no_seq;   
 
-- 멤버 테이블 조회
select * from tbl_member;

-- 저장
commit;

-- 상품 table
CREATE TABLE tbl_product(
    product_no   number(38) primary key , -- 상품 글 번호
    product_title varchar2(100) NOT NULL ,-- 상품 명
    product_price number(38) NOT NULL , -- 상품 가격
    product_maker varchar2(100) NOT NULL , -- 제조사
    product_type varchar2(100) NOT NULL ,-- 분류1
    product_type2 varchar2(100) NOT NULL ,-- 분류2
    product_cont1 varchar2(4000) NOT NULL , -- 상품사진
    product_cont2 varchar2(4000) , -- 상품사진
    product_cont3 varchar2(4000) , -- 상품사진
    product_cont4 varchar2(4000) , -- 상품사진
    product_cont5 varchar2(4000) NOT NULL , -- 상품내용사진
    product_cont6 varchar2(4000) , -- 상품내용사진
    product_cont7 varchar2(4000) ,-- 상품내용사진
    product_cont8 varchar2(4000) ,  -- 상품내용사진
    product_score number(38) default 0 , -- 상품 평점 ( 리뷰 평균값 가져옴 )
    product_count number(38) , -- 상품 재고
    product_date date -- 상품 등록 날짜(sysdate)
);

--더미데이터
insert into tbl_product values(1, '상품명01','1000', '제조사01', '분류a','분류aa', '사진', '사진', '사진', '사진', '사진', '사진', '사진', '사진',  5, 1, sysdate);
insert into tbl_product values(2, '상품명02','2000', '제조사02', '분류b','분류b', '사진', '사진', '사진', '사진', '사진', '사진', '사진', '사진',  2, 3, sysdate);
insert into tbl_product values(3, '상품명03','3030', '제조사03', '분류b','분류bb', '사진', '사진', '사진', '사진', '사진', '사진', '사진', '사진',  3, 5, sysdate);
insert into tbl_product values(4, '상품명04','4200', '제조사04', '분류c','분류cc', '사진', '사진', '사진', '사진', '사진', '사진', '사진', '사진',  4, 51, sysdate);
insert into tbl_product values(5, '상품명05','5400', '제조사05', '분류d','분류dd', '사진', '사진', '사진', '사진', '사진', '사진', '사진', '사진',  5, 23, sysdate);
insert into tbl_product values(6, '상품명06','19384', '제조사06', '분류e','분류ee', '사진', '사진', '사진', '사진', '사진', '사진', '사진', '사진',  1, 541, sysdate);
insert into tbl_product values(7, '상품명07','36497', '제조사07', '분류f','분류ff', '사진', '사진', '사진', '사진', '사진', '사진', '사진', '사진',  2, 231, sysdate);
insert into tbl_product values(8, '상품명08','12538', '제조사08', '분류g','분류gg', '사진', '사진', '사진', '사진', '사진', '사진', '사진', '사진',  3, 651, sysdate);
insert into tbl_product values(9, '상품명09','2376', '제조사09', '분류h','분류hh', '사진', '사진', '사진', '사진', '사진', '사진', '사진', '사진',  4, 46, sysdate);
insert into tbl_product values(10, '상품명10','3586', '제조사10', '분류i','분류ii', '사진', '사진', '사진', '사진', '사진', '사진', '사진', '사진',  2, 13, sysdate);
insert into tbl_product values(11, '상품명11','3553533', '제조사11', '분류j','분류jj', '사진', '사진', '사진', '사진', '사진', '사진', '사진', '사진',  5, 341, sysdate);


-- 삭제 DROP table tbl_product;

-- 상품 시퀀스 
create sequence product_no_seq
start with 1 --1부터 시작
increment by 1 --1씩 증가옵션
nocache;

-- 시퀀스 삭제 DROP SEQUENCE product_no_seq;

--상품 조회 
select * from tbl_product;

-- 저장 
commit;

-- 상품 후기 table 
create table tbl_reviews (
    re_no NUMBER PRIMARY KEY , -- 후기 no
    --re_pro_no VARCHAR2(10) , --제품no : F
    re_pro_no NUMBER(38) REFERENCES tbl_product(product_no) , --제품no : F
    re_mem_id VARCHAR2(100) , -- 회원 아이디 
    re_title VARCHAR2(100) , -- 리뷰 제목
    re_content VARCHAR2(4000) ,  --리뷰 내용
    re_image1 VARCHAR2(4000)  , --사진 등록1
    re_image2 VARCHAR2(4000)  , -- 사진등록2
    re_image3 VARCHAR2(4000)  , -- 사진등록3
    re_score NUMBER(38) , --별점 score
    re_date DATE --등록일
);

--삭제 drop table tbl_reviews;

-- 상품 후기 시퀀스
create sequence re_no_seq
    start with 1
    increment by 1
    nocache;

-- 시퀀스 삭제 DROP SEQUENCE re_no_seq;

-- 조회 
select * from tbl_reviews;

-- 저장 
commit;

-- 장바구니 table
create table tbl_cart (
   cart_no NUMBER PRIMARY KEY , -- 장바구니 no
   cart_mem_id VARCHAR(100) , -- 회원 아이디 , 비회원 아이디 :랜덤값 
   cart_pro_id NUMBER(38) REFERENCES tbl_product(product_no)  , -- 제품 고유번호 : F 상품no
   cart_cnt  NUMBER(38)  -- 구매 수량
);

--삭제 drop table tbl_cart;

-- 장바구니 시퀀스
create sequence cart_no_seq
    start with 1
    increment by 1
    nocache;

-- 시퀀스 삭제 DROP SEQUENCE cart_no_seq;

-- 조회 
select * from tbl_cart;

-- 저장 
commit;

--  찜 목록 table 
create table tbl_like (
    like_no NUMBER PRIMARY KEY , -- 찜 no
    like_mem_id VARCHAR(100) ,  --REFERENCES tbl_member(user_id)  , -- 회원ID : F
    like_pro_id  NUMBER(38) REFERENCES tbl_product(product_no)  -- 제품 고유번호 : F = 상품no
);

--삭제 drop table tbl_like;

-- 찜목록 시퀀스
create sequence like_no_seq
    start with 1
    increment by 1
    nocache;

-- 시퀀스 삭제 DROP SEQUENCE like_no_seq;

-- 조회 
select * from tbl_like;

-- 저장 
commit;

-- 결제 table 
create table tbl_order (
    order_no NUMBER PRIMARY KEY , -- 주문번호 no
    order_id VARCHAR2(100) , -- 회원 1, 비회원 2
    order_date DATE , -- 주문일자 
    order_name VARCHAR2(100) , -- 수령자 
    order_phone VARCHAR2(100) ,-- 수령자 연락처 
    order_post VARCHAR2(100) , -- 수령자 우편번호 
    order_road VARCHAR2(100) , -- 수령자 주소 
    order_detail VARCHAR2(100) , -- 수령자 상세주소
    order_total NUMBER(38) , -- 총 금액
    order_type VARCHAR2(100) -- 결제 수단 : 1 무통장금액_메일발송안내, 2 카드결제 3. 카카오페이/네이버페이 
);

--삭제 drop table tbl_order;

-- 결제 시퀀스
create sequence order_no_seq
    start with 1
    increment by 1
    nocache;

-- 시퀀스 삭제 DROP SEQUENCE order_no_seq;

-- 조회 
select * from tbl_order;

-- 저장 
commit;

-- 주문상세내역 table 
create table tbl_order_detail (
    order_detail_no NUMBER PRIMARY KEY , -- 주문 no
    order_detail_fno NUMBER(38)  REFERENCES tbl_product(product_no) , -- 주문번호 no  : F = 상품no
    order_detail_pname VARCHAR2(100) , -- REFERENCES tbl_product(product_title)  , --제품명 = 상품명F
    order_detail_cnt VARCHAR2(100) , -- 수량 
    order_detail_price VARCHAR2(100) -- 가격
);

--삭제 drop table tbl_order_detail;

-- 주문상세내역 시퀀스
create sequence order_detail_no_seq
    start with 1
    increment by 1
    nocache;
    
-- 시퀀스 삭제 DROP SEQUENCE order_detail_no_seq;

-- 조회 
select * from tbl_order_detail;

-- 저장 
commit;

-- 교환, 환불 table : 신청용
create table tbl_refund (
    refund_no NUMBER PRIMARY KEY , -- 교환, 환불 no
    refund_order_no NUMBER(38) REFERENCES tbl_product(product_no) , -- 주문번호 no : F = 상품no
    refund_category VARCHAR2(100) , -- 카테고리 : 1.교환, 2. 환불, 3.기타
    refund_cont VARCHAR2(4000) , -- 사유(내용) 
    refund_image varchar2(1000) , --사진
    refund_state varchar2(100) , -- 상태 : 1대기, 2접수중, 3접수완료 
    refund_date DATE -- 등록일자
);

--삭제 drop table tbl_refund;

-- 교환,환불 시퀀스
create sequence refund_no_seq
    start with 1
    increment by 1
    nocache;

-- 시퀀스 삭제 DROP SEQUENCE refund_no_seq;

-- 조회 
select * from tbl_refund;

-- 저장 
commit;

-- 쿠폰 table 
create table tbl_coupon (
    coupon_no NUMBER PRIMARY KEY , -- 쿠폰 no
    coupon_name VARCHAR2(100) , --쿠폰명
    coupon_dc NUMBER(38) ,-- 쿠폰
    coupon_mem_id VARCHAR(100) --REFERENCES tbl_member(user_id)  -- 회원 아이디 , 비회원 아이디 :랜덤값  : F
);

-- 삭제 DROP table tbl_coupon;

-- 쿠폰 시퀀스
create sequence coupon_no_seq
    start with 1
    increment by 1
    nocache;

-- 시퀀스 삭제 DROP SEQUENCE coupon_no_seq;
    
-- 조회 
select * from tbl_coupon;

-- 저장 
commit;


-- 고객 게시판 테이블
CREATE TABLE tbl_client (
   client_no number(38) primary key -- 고객 문의 글 번호
    , client_title varchar2(100) NOT NULL -- 고객 문의 글 제목
    , client_cont varchar2(4000) NOT NULL -- 고객 문의 글 내용
    , client_cont_reply varchar2(4000) default ' ' -- 고객 문의 글 답변 내용
    , client_category varchar2(50) NOT NULL -- 회원정보, 상품확인, 주문/결제, 배송, 교환/취소/반품, 서비스
    , client_date date -- 고객 문의 글 작성 날짜(sysdate)
    , user_id varchar2(100) not null -- 회원아이디(fk)
);

insert into tbl_client values(1122, '비번좀', '뭐죠대체?', ' ', '로그인/정보', sysdate, 'test01');
insert into tbl_client values(3123, '상품이말이죠', '왜이래요?', ' ', '상품', sysdate, 'test02');
insert into tbl_client values(3232, '이게말이에요', '참나?', ' ', '주문/결제', sysdate, 'test03');
insert into tbl_client values(3232, '야미야미', '잘오네', ' ', '배송문의', sysdate, 'test04');
insert into tbl_client values(4232, '호롤롤로', '그대여', ' ', '교환/취소(반품)', sysdate, 'test05');
insert into tbl_client values(42332, '호롤롤로', '그대여', '답변이다', '교환/취소(반품)', sysdate, 'test05');

commit;

select * from tbl_client;

-- 고객 게시판 시퀀스
create sequence client_no_seq
    start with 1
    increment by 1
    nocache;
    
create table tbl_client_reply(
    client_no number(38) not null
    ,client_cont_reply varchar2(4000) not null
    ,CONSTRAINT tbl_client_reply_client_no_fk foreign key(client_no) REFERENCES tbl_client(client_no)
);


    
    
create table tbl_faq(
    faq_no number(38) primary key
    ,faq_category varchar2(100) not null
    ,faq_title varchar2(1000) not null
    ,faq_cont varchar2(4000) not null
);

insert into tbl_faq values(1, '로그인/정보', '뭐죠대체?', '하놔 시부렝');
insert into tbl_faq values(2, '상품', '박진영이라니!', '아니 나는 말이야');
insert into tbl_faq values(3, '주문/결제', '저기요', '어케된거에요');
insert into tbl_faq values(4, '배송문의', '헤헤헤', '잘왔어염');
insert into tbl_faq values(5, '교환/취소(반품)', '이거 취소되나여', '미친거같은데;');

commit;

create sequence faq_no_seq
    start with 1
    increment by 1
    nocache;
    
select * from tbl_faq;


create table tbl_notice(
    notice_no number(38) primary key
    , notice_title varchar2(1000) NOT NULL 
    , notice_cont varchar2(4000) NOT NULL
    , notice_date date
);

insert into tbl_notice values(11211, '공지사항1', '공지사항 1번에 대한 내용입니다', sysdate);
insert into tbl_notice values(22232, '공지사항2', '공지사항 2번에 대한 내용입니다', sysdate);
insert into tbl_notice values(6368, '공지사항3', '공지사항 3번에 대한 내용입니다', sysdate);


commit;

select * from tbl_notice;

select count(notice_no) from tbl_notice;

delete from tbl_notice where notice_no=1;

commit;

create sequence notice_no_seq
    start with 1
    increment by 1
    nocache;
    
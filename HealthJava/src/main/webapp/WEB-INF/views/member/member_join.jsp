<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script> <%-- CDN 절대링크 --%>
<script src="<%=request.getContextPath()%>/js/join.js"></script>
<!-- <script type="text/javascript" src="./js/jquery.js"></script> -->

<title>HealthJava회원가입</title>

<%--<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico?ver1" type="image/x-icon">  파비콘 --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/include/css/header.css"> <%-- header.css --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/include/css/footer.css"> <%-- footer.css --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/fontium/css/fontium.css" /> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/member/css/join.css" /> 
<style type="text/css">
	/* 폰트 CSS */
	@font-face {
		font-family: 'KIMM_Bold';
		src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2212@1.0/KIMM_Bold.woff2') format('woff2'); /* CDN 절대링크  */
		font-weight: 700;
		font-style: normal;
	}
	/* 되도록 안건드리는 영역 */
	* {
		box-sizing: border-box;
		-webkit-box-sizing: border-box;
		-moz-box-sizing: border-box;
	}
	html {
		height: 100%;
	}
	body1 {
		margin: 0px;
		height: 100%;
		padding: 0px;
	}
	header {
		width: 100%;
	    position: fixed;
		z-index: 2;
	}
	.wrap {
		margin-top: -110px;
	}
	.main { 
		width: 1400px;
		position : relative;
		top: 105px;
		left: 50%;
        transform: translateX( -50% );
		background-color: rgb(179, 255, 213);  /* 영역 보기 편하라고 배경색 지정함 : 연초록 */
		margin: 0px;
	}
	section {
		height: 100%;
		background-color: rgb(236, 226, 202); /* 영역 보기 편하라고 배경색 지정함 : 연주황 */
	}
	/* 클리어 */
	.clear {
		clear: both;
	}
	/* 밑의 영역부터 css시작 */
	.container {
		width: 100%;
		height: 935px;
	}
	/* 캐러셀 */
	#carouselExampleControls {
		width: 1100px;
		position : relative;
		left: 50%;
        transform: translateX( -50% );
	}
	
	
	
	/* Google web font CDN*/


.signup-form {
	background-color: #f2f2f2;
	padding: 20px;
	width: 450px;
	margin: 0 auto;
	margin-top:200px;
	margin-bottom:100px;
	text-align:left;
	border-radius: 5px;
	box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.3);
}

.-form label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
	
}


.field select {
	
	width: 190px;
	padding: 5px;
	margin-bottom: 20px;
	border: none;
	border-radius: 5px;
	background-color: #fff;
	box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.3);
	border: 1px solid #dadada;
   
    margin-bottom: 5px;
}

.signup-form input[type="email"] {
	width: 100%;
	padding: 5px;
	margin-bottom: 20px;
	border: none;
	border-radius: 5px;
	background-color: #fff;
	box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.3);
	border: 1px solid #dadada;
   
    margin-bottom: 5px;
}

.signup-form input[type="text"],
.signup-form input[type="password"],
.signup-form input[type="tel"],
.signup-form input[type="number"]
 {
	width: 410px;
	padding: 5px;
	margin-bottom: 20px;
	border: none;
	border-radius: 5px;
	background-color: #fff;
	box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.3);
	border: 1px solid #dadada;
    width: 100%;
    margin-bottom: 5px;
}

.signup-form input[type="button"],
.signup-form input[type="submit"] {
	background-color: #FC5400;
	color: #fff;
	border: none;
	padding: 5px 20px;
	border-radius: 5px;
	cursor: pointer;
	border: 1px solid #dadada;
    
    width: 100%;
    margin-bottom: 5px;
}

*{
    box-sizing: border-box; /*�쟾泥댁뿉 諛뺤뒪�궗�씠吏�*/
    outline: none; /*focus �뻽�쓣�븣 �뀒�몢由� �굹�삤寃� */
}

a{
    text-decoration: none;
    color: #222;
}

/*member sign in*/

.member h1{
	text-align: center;
	
}


.member .logo{
    /*濡쒓퀬�뒗 �씠誘몄��씪 �씤�씪�씤 釉붾줉�씠�땲源� 留덉쭊 �삤�넗 �븞�맖 釉붾줉�슂�냼留� �맖 */
    display: block;
    margin :50px auto;
}

.member .field{
    margin :5px 0; /*�긽�븯濡� 醫� �쓣�썙二쇨린*/
}

.member b{
    /* border: 1px solid #000; */
    display: block; /*�닔吏� �젙�젹�븯湲� */
    margin-bottom: 5px;
}

/*input 以� radio �뒗 width 媛� 100%硫� �븞�릺�땲源� */




.member input[type=button],
.member input[type=submit]{
background-color: #FC5400;
color:#fff
}

.member input:focus, .member select:focus{
    border: 1px solid #2db400;
}

.field_id div {
    display: flex;
}

.field_id div input:nth-child(1){
    flex:2;
}

.field_id div input:nth-child(2){
    flex:1;
}

.field.birth div{ /*field �씠硫댁꽌 birth*/
    display: flex;
    gap:10px; /*媛꾧꺽 踰뚮젮以꾨븣 怨듭떇泥섎읆 �궗�슜�븶�굹 */
}

/* .field.birth div > * {  gap �궗�슜�븳嫄곕옉 媛숈� �슚怨쇰�� 以� 
    flex:1;
} */

.field.tel-number div {
    display: flex;
}

.field.tel-number div input:nth-child(1){
    flex:2;
}

.field.tel-number div input:nth-child(2){
    flex:1;
}


.field.address div {
    display: flex;
}

.field.address div input:nth-child(1){
    flex:2;
}

.field.address div input:nth-child(2){
    flex:1;
}






	
</style>
</head>

<body>
<%-- 전체 영역 --%>
	<div class="wrap">
		<%-- 헤더 영역 --%>
		<header>
			<%-- header include --%>
			<jsp:include page="../include/header.jsp"/>
		</header>
<div class="member" >
<form name="m" method="post" action="member_join_ok"  onsubmit="return join_check();">
        <!-- 1. 로고 -->
        <div class="signup-form">
        <h1>회원가입</h1>

        <!-- 2. 필드 -->
        <div class="field_id">
            <b>아이디</b>
            <div>
            	<input type="text" placeholder="" name="user_id" id="user_id">
            	
                <input type="button" value="아이디 중복검사" onclick="id_check();" >
                
            </div>
            <div>
            <span id="idcheck"></span>
            </div>
        </div>
        <div class="field">
            <b>비밀번호</b>
            <input class="userpw" type="password" name="user_pwd" id="user_pwd">
        </div>
        <div class="field">
            <b>비밀번호 재확인</b>
            <input class="userpw-confirm" type="password" name="user_pwd2" id="user_pwd2"  >
        </div>
        <div class="field">
            <b>이름</b>
            <input type="text" name="user_name" id="user_name">
        </div>

        <!-- 3. 필드(생년월일) -->
        <div class="field birth" >
            <b>생년월일</b>
    
                <input type="text" placeholder="ex) 990101" name="user_birth" id="user_birth">                
              
        </div>
        <!-- 3. 필드(성별) -->
        <div class="field gender" >
            <b>성별</b>
    
                <input type="text" placeholder="ex) 990101" name="user_gender" id="user_gender">                
              
        </div>

        <!-- 4. 필드(성별) -->
        <div class="field address">
            <b>주소</b>
            
            <div>
                <input type="text" placeholder="우편번호" name="postCode" id="postCode">
                <input type="button" onclick="post()" value="우편번호 찾기">
            </div>
            <input type="text" placeholder="주소" name="roadAddr" id="roadAddr">
            <input type="text" placeholder="상세주소" name="detailAddr" id="detailAddr">
        </div>

        <!-- 5. 이메일_전화번호 -->
        <div class="field">
            <b>이메일</b>
            <input type="email" placeholder="ex) abc123@naver.com" name="user_email" id="user_email">
            
        </div>
        
        <div class="field tel-number">
            <b>휴대전화</b>
            
            <div>
                <input type="tel" placeholder="ex) 01011112222" name="user_phone" id="user_phone">
                
            </div>
            
        </div>

        <!-- 6. 가입하기 버튼 -->
        <input type="submit" value="가입하기">

        
        
    </div>
    </form>
    </div>
	<%-- top버튼 삭제 X --%>
			<div id="topBtn">
				<span class="fonti um-arrow-circle-up um-3x icon"></span>TOP
			</div>
	<%-- 푸터 영역 --%>
	<footer>
	
			<%-- header include --%>
			<jsp:include page="../include/footer.jsp"/>
		
	</footer>
	
	</div>
	<script type="text/javascript">
	
		<%-- top버튼 부분 --%>
		// 클릭 이벤트 핸들러
		$("#topBtn").click(function(e) {
			e.stopPropagation();
			$("html, body").animate({
				scrollTop : 0
			}, 'fast', 'easeOutCubic');
		});

		// 스크롤 이벤트 핸들러
		$(window).scroll(function() {
			if ($(window).scrollTop() == 0) {
				$("#topBtn").css("opacity", 0); // TOP 버튼 숨기기
			} else {
				$("#topBtn").css("opacity", 1); // TOP 버튼 나타내기
			}
		});
		
		<%-- footer 부분 --%>
		// 서비스 이용약관 텍스트 클릭시 새창 열기
		function openPopup_service() {
	        var page_width = '525';
	        var page_height = '650';
	    
	        // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
	        var page_left = Math.ceil((window.screen.width - page_width)/2);
	        var page_top = Math.ceil((window.screen.height - page_height)/2);
	
	    window.open("http://localhost:8046/Shopping_Mall/util/service.jsp", "service",'width='+ page_width +', height='+ page_height +', left=' + page_left + ', top='+ page_top);
	    
	    }
	    
		// 개인정보 처리 텍스트 클릭시 새창 열기
		function openPopup_privacy() {
	        var page_width = '525';
	        var page_height = '555';
	    
	        // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
	        var page_left = Math.ceil((window.screen.width - page_width)/2);
	        var page_top = Math.ceil((window.screen.height - page_height)/2);
	
	    window.open("http://localhost:8046/Shopping_Mall/util/privacy.jsp", "privacy",'width='+ page_width +', height='+ page_height +', left=' + page_left + ', top='+ page_top);
	    
	    }
		
		// 입점/제휴 문의 텍스트 클릭시 새창 열기
		function openPopup_inquiry() {
	        var page_width = '525';
	        var page_height = '555';
	    
	        // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
	        var page_left = Math.ceil((window.screen.width - page_width)/2);
	        var page_top = Math.ceil((window.screen.height - page_height)/2);
	
	    window.open("http://localhost:8046/Shopping_Mall/util/inquiry.jsp", "inquiry",'width='+ page_width +', height='+ page_height +', left=' + page_left + ', top='+ page_top);
	    
	    }
		
		// 인증 마크 클릭시 새창 열기
	    function openPopup_certificate() {
	        var page_width = '460';
	        var page_height = '380';
	    
	        // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
	        var page_left = Math.ceil((window.screen.width - page_width)/2);
	        var page_top = Math.ceil((window.screen.height - page_height)/2);
	
	    window.open("http://localhost:8046/Shopping_Mall/util/certificate.jsp", "certificate",'width='+ page_width +', height='+ page_height +', left=' + page_left + ', top='+ page_top);
	    
	    }
	</script>
</body>
</html>
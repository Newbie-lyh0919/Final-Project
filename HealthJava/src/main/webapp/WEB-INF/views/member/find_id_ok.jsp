<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> <%-- CDN 절대링크 --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script> <%-- CDN 절대링크 --%>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script> <%-- CDN 절대링크 --%>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script> <%-- CDN 절대링크 --%>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script defer src="<%=request.getContextPath()%>/js/kakao.js"></script>
<script>Kakao.init('31d2f9dc79f327146c781ff55e8f8b76');</script>
<title>PuppyHome 메인</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/page/include/css/header.css"> <%-- header.css --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/page/include/css/footer.css"> <%-- footer.css --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/fontium/css/fontium.css"/>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" type="image/x-icon"> <%-- 파비콘 --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/page/member/css/login.css"> <%-- login.css --%>

<style type="text/css">
	
	.social-login b {
		background-color: #FC5400;
		color: #fff;
		border: none;
		padding: 10px 20px;
		border-radius: 5px;
		cursor: pointer;
	}
	
	.login-form {
		margin-top: 200px;
	}
	
	/* 메인 컨텐츠 부분 */
	#wrap {
		width: 100%;
		height: 100%;
		text-align: center;
	}
	
	/* 폰트 CSS */
	@font-face {
		font-family: 'KIMM_Bold';
		src:
			url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2212@1.0/KIMM_Bold.woff2')
			format('woff2'); /* CDN 절대링크  */
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
	
	body {
		font-family: 'KIMM_Bold';
		margin: 0px;
		height: 100%;
		padding: 0px;
	}
	
	header {
		width: 100%;
		position: fixed;
		z-index: 2;
	}
	
	footer {
		bottom: 0;
		z-index: 5;
		position: relative;
	}
	
	.wrap {
		font-family: 'KIMM_Bold';
		margin-top: -110px;
		min-height: 100%;
		position: relative;
	}
	
	.main {
		width: 1600px;
		height: auto;
		/* UI 개발할 때 각 페이지에 맡게 해당 영역 px수치 수정해야함 / section이랑 px 맞춰야함 */
		position: relative;
		top: 105px;
		left: 50%;
		transform: translateX(-50%);
	}
	
	section {
		height: 1200px;
	}
	
	/* 클리어 */
	.clear {
		clear: both;
	}
	/* 밑의 영역부터 css시작 */
	.container {
		width: 100%;
		margin: 20px 0px;
	}
	
	.social-login b {
		background-color: #FC5400;
		color: #fff;
		border: none;
		padding: 10px 20px;
		border-radius: 5px;
		cursor: pointer;
	}
	
	.find-form {
		background-color: #f2f2f2;
		padding: 20px;
		width: 450px;
		margin: 0 auto;
		margin-top: 200px;
		margin-bottom: 100px;
		text-align: left;
		border-radius: 5px;
		box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.3);
	}
	
	.find-form h1 {
		text-align: center;
		margin-top: 0;
	}
	
	.find-form label {
		display: block;
		font-weight: bold;
		margin-bottom: 5px;
	}
	
	.find-form input[type="text"] {
		width: 410px;
		padding: 5px;
		margin-bottom: 20px;
		border: none;
		border-radius: 5px;
		background-color: #fff;
		box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.3);
	}
	
	.find-form button[type="submit"] {
		background-color: #b21949;
		color: #fff;
		border: none;
		padding: 10px 20px;
		border-radius: 5px;
		cursor: pointer;
	}
	
	.find_button {
		text-align: center;
		margin-top: 20px;
	}
	
	.find_button button {
		width: 410px;
		display: inline-block;
		background-color: #FC5400;
		color: #fff;
		padding: 10px 20px;
		border-radius: 5px;
		text-decoration: none;
		margin-right: 10px;
	}
	
	.forgot-userphone, .forgot-username {
		margin-top: 10px;
		text-align: right;
	}
	
	.forgot-userphone a, .forgot-username a {
		color: #999;
		text-decoration: none;
		font-size: 12px;
	}
	
	.social-find {
		margin-top: 20px;
		text-align: center;
	}
	
	.social-find p {
		margin-bottom: 10px;
	}
	
	.social-find a {
		display: inline-block;
		background-color: #FC5400;
		color: #fff;
		padding: 10px 20px;
		border-radius: 5px;
		text-decoration: none;
		margin-right: 10px;
	}
	
	* {
		box-sizing: border-box; /*��泥댁�� 諛��ㅼ�ъ�댁�*/
		outline: none; /*focus ������ ����由� ���ㅺ� */
	}
	
	body {
		font-family: 'Noto Sans KR', sans-serif;
		font-size: 10px;
		background-color: #f5f6f7;
		line-height: 1.5em;
		color: #222;
		margin: 0;
	}
	
	a {
		text-decoration: none;
		color: #222;
	}
</style>
</head>
<body>
	<%-- 전체 영역 --%>
	<div class="wrap">
		<%-- 헤더 영역 --%>
		<header>
			<%-- header include --%>
			<jsp:include page="../include/header.jsp" />
		</header>
		<div class="main">
		<div class="find-form">

			<h2 class="pOK_title">아이디찾기</h2>
			<table id="pOK_t">
				<tr>
					<th>아이디 :</th>
					<td>${findId}</td>
				</tr>
			</table>
			<div id="pOK_menu">
				<input type="button" value="로그인하기" onclick="location='member_login';" /> 
				<input type="button" value="비밀번호 찾기" onclick="location='find_pw';" />
				<%-- 자바스크립트에서 self.close();는 내자신 공지창을 닫는다. --%>
			</div>

		</div>
		<%-- top버튼 삭제 X --%>
		<div id="topBtn">
			<span class="fonti um-arrow-circle-up um-3x icon"></span>TOP
		</div>
		<%-- 푸터 영역 --%>
		<footer>
			<%-- header include --%>
			<jsp:include page="../include/footer.jsp" />
		</footer>
	</div>
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
		
	</script>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> <%-- CDN 절대링크 --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script> <%-- CDN 절대링크 --%>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script> <%-- CDN 절대링크 --%>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script> <%-- CDN 절대링크 --%>
<script type="text/javascript" src = "./js/jquery.js"></script>
<script defer src="<%=request.getContextPath()%>/js/post.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="<%=request.getContextPath()%>/js/orderInfo.js"></script>
<script src="<%=request.getContextPath()%>/js/post2.js"></script>
<script>Kakao.init('31d2f9dc79f327146c781ff55e8f8b76');</script>

<title>HealthJava 주문지</title>

<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" type="image/x-icon"> <%-- 파비콘 --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/page/include/css/header.css"> <%-- header.css --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/page/include/css/footer.css"> <%-- footer.css --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/fontium/css/fontium.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/page/mypage/css/mypage.css">
<%-- <link rel="stylesheet" href="./shop/puppyhome/controller_mypage/css/mypage.css">--%>

<%--결제api <!-- jQuery --> --%> 
<script type="text/javascript"src="https://code.jquery.com/jquery-1.12.4.min.js"></script> <!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>

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
   body {
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
      margin-top: -110px;
      min-height: 100%;
       position: relative;
   }
   .main { 
      width: 1400px;
      height: 2000px; /* UI 개발할 때 각 페이지에 맡게 해당 영역 px수치 수정해야함 / section이랑 px 맞춰야함 */
      position : relative;
      top: 105px;
      left: 50%;
        transform: translateX( -50% );
      background-color: rgb(179, 255, 213);  /* 영역 보기 편하라고 배경색 지정함 : 연초록 */
   }
/*   section {
      height: 2000px;  UI 개발할 때 각 페이지에 맡게 해당 영역 px수치 수정해야함 / .main이랑 px 맞춰야함 
      background-color: rgb(236, 226, 202);  영역 보기 편하라고 배경색 지정함 : 연주황 
   }
      */ 
   /* 클리어 */

   .clear {
      clear: both;
   }
   /* 밑의 영역부터 css시작 */
   .container {
      width: 100%;
   }
   /* 캐러셀 */
   #carouselExampleControls {
      width: 1100px;
      position : relative;
      left: 50%;
        transform: translateX( -50% );
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
	<%-- 본문 영역(ui깨질시 본인이 ui 수정바람..) --%>
	<div class="innerWrap" style="margin-left: 400px;">
		<section class="notice" align="center">
			<!-- board list area -->
			<div class="page-title">
			<b style="text-align: left; font-size: 20px; margin-left:50px;">주문/결제</b>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<b style="font-size: 13px; ">* 필수 입력사항</b>
			</div>
			<br>
			<div class="page-title" style="margin-left: 50px;">
			<form method="post" action="payment_ok.shop" method="post" onsubmit="return order_check();" width="800px" margin="0px">
				<table>


					<!--이름-->
					<tr>
						<th rowspan="2" class="th-list"width="170px"
							style="border-top-color: black; border-top-style: solid; border-top-width: 3px;">
							수령인 *</th>
						<td class="td-inputInfo"style="border-top-color: black; border-top-style: solid; border-top-width: 3px;">
						<input type="text" name="order_rec" id="order_rec"  size="70" placeholder="ex) 홍길동"></td>
					</tr>
										
					<tr>
						<td class="td-infoPs"></td>
					</tr>


							<!--주소-->
					<tr>
						<th rowspan="4" class="th-list">수령인 주소 *</th>
						<td class="td-inputInfo"><input type="text" name="postCode" id="postCode"  size="20" placeholder="우편번호"/>&nbsp;&nbsp;
						<input type="button" value="주소검색" onclick="post()" style="font-weight: bold; padding: 2px;"/>
						</td>
					</tr>

					<tr>
						<td class="td-inputInfo"><input type="text" name="roadAddr" id="roadAddr" size="70" placeholder="주소"></td>
					</tr>

					<tr>
						<td class="td-inputInfo"><input type="text" name="detailAddr" id="detailAddr"  size="70" placeholder="상세주소"></td>
					</tr>
					
					<tr>
						<td class="td-infoPs"></td>
					</tr>

					
					<!--휴대전화-->
					<tr>
						<th rowspan="2" class="th-list">수령인 핸드폰번호*</th>
						<td class="td-inputInfo">
								<input type="text" name="user_phone" id="user_phone" size="70" placeholder="ex) 01012345678">
						</td>
							
					</tr>
					
					<tr>
						<td class="td-infoPs"></td>
					</tr>

				</table>
				
				<table>

					<!--주문 정보-->
					<tr>
						<th rowspan="2" class="th-list"width="170px" style="border-top-color: black; border-top-style: solid; border-top-width: 3px;">
							결제 정보 </th>
						<td class="td-inputInfo"style="border-top-color: black; border-top-style: solid; border-top-width: 3px;">
						상품명 : <input type="text" name="product_title" id="product_title" value="${product_title}" readonly="readonly"> <br>
						상품 가격 : <input type="text" name="product_price" id="product_price" value="${product_price}" readonly="readonly"><br>
						상품 수량 : <input type="text" name="product_cnt" id="product_cnt" value="${product_cnt}" readonly="readonly"></td>
					</tr>
										
					<tr>
						<td class="td-infoPs"></td>
					</tr>

					<!--주문금액-->
					<tr>
						<th class="th-list" rowspan="2" >주문금액 </th>
						<td class="td-inputInfo">
						<input type="text" name="total_price" value="${total_price}" id="total_price" size="70" readonly></td>
					</tr>
					
					<tr>
						<td class="td-infoPs"></td>
					</tr>
					
				</table>
				
			<br><br>
			
				<div class="submitBtn">
				<input id="updateBtn" type="submit" value="결제하기">
				<input id="resetBtn" type="reset" value="취소">
				</div>
				</form>
			</div>
			         <%-- top버튼 삭제 X --%>
         <div id="topBtn">
            <span class="fonti um-arrow-circle-up um-3x icon"></span>TOP
         </div>
		</section>
		
			</div>
		<div class="clear"></div>
		<%-- 푸터 영역 --%>
		<footer>
			<!-- footer -->
			<jsp:include page="../include/footer.jsp"/>
			<!-- footer 끝 -->
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
		
	
	</script>
</body>
</html>
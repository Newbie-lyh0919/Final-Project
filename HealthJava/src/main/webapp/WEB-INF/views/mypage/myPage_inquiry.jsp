<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> <%-- CDN 절대링크 --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script> <%-- CDN 절대링크 --%>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script> <%-- CDN 절대링크 --%>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script> <%-- CDN 절대링크 --%>
<script type="text/javascript" src="./js/jquery.js"></script>

<title>HealthJava 문의내역</title>

<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" type="image/x-icon"> <%-- 파비콘 --%>
<link rel="stylesheet" type="text/css" 	href="<%=request.getContextPath()%>/page/include/css/header.css"> <%-- header.css --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/page/include/css/footer.css"> <%-- footer.css --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/fontium/css/fontium.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/page/mypage/css/mypage.css?ver=1">
<%-- <link rel="stylesheet" href="./shop/puppyhome/controller_mypage/css/mypage.css">--%>

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
		font-family: 'KIMM_Bold', sans-serif;
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
		width: 1600px;
		height: auto;
		position: relative;
		top: 105px;
		left: 50%;
		transform: translateX(-50%);
	}
	
	/* 클리어 */
	.clear {
		clear: both;
	}
	/* 밑의 영역부터 css시작 */
	.container {
		width: 100%;
	}
	/*MyPage CSS*/
	table {
		border-collapse: collapse;
		border-spacing: 0;
	}
	section.notice {
		padding: 20px 0;
		/*추가*/
		width: 1200px;
		min-height: 200px;
	}
	
	.aside_left {
		margin-top: 45px;
		margin-left: 60px;
		width: 180px;
		min-height: 700px;
		float: left;
		text-align: left;
	}
	
	.aside_left nav {
		min-height: 600px;
		margin-bottom: 50px;
	}
	
	.aside_left li {
		padding-top: 8.2px;
		padding-bottom: 2px;
		list-style: none;
	}
	
	li{
		padding-top: 10px;
	}
	
	nav {
		min-height: 600px;
		margin-bottom: 50px;
	}
	
	#subspan {
		color: #808080;
	}
	
	div.page-title {
		width: 1000px;
		min-height: 10px;
		padding: 0px 10px;
		text-align: left;
	}
	
	h3.page-title {
		font-size: 25px;
		color: black;
		font-weight: 400;
		text-align: left;
	}
	
	.memBasicInfo {
		height: 120px;
		padding: 20px;
		float: left;
	}
	
	#board-search .search-window {
		width: 1000px;
		min-height: 80px;
		padding: 15px 0;
		text-align: left;
	}
	
	.board-table {
		font-size: 13px;
		width: 100%;
		border-top: 1px solid #ccc;
		border-bottom: 1px solid #ccc;
	}
	
	.board-table th {
		text-align: center;
		border-top-style: solid;
		border-top-color: black;
		border-top-width: 2px;
	}
	
	.board-table .th-num {
		width: 100px;
		text-align: center;
	}
	
	table th.th-title {
		font-size: 15px;
		width: 200px;
	}
	
	table td.td-title {
		font-size: 13px;
	}
	
	table th.th-date {
		font-size: 15px;
		width: 80px;
	}
	
	table th.th-date1 {
		font-size: 15px;
		width: 50px;
	}
	
	table th.th-date2 {
		font-size: 15px;
		width: 150px;
	}
	
	.board-table .th-inputInfo {
		
	}
	
	.board-table th, .board-table td {
		padding-top: 14px;
		padding-bottom: 14px;
	}
	
	.board-table tbody td {
		border-top: 1px solid #e7e7e7;
		text-align: center;
		font-size: 15px;
	}
	
	.board-table tbody th {
		font-size: 15px;
		border-top: 1px solid #e7e7e7;
		text-align: center;
	    padding: 140px 0 36px;
	    background: url(../images/bg_no_list.png) no-repeat 50% 40px;
	}
	
	.board-table tbody th p {
		display: none;
	}
	
	.th-list{
		text-align:center;
		margin-top : 20px;
		margin-bottom: 20px;
		padding: 10px;
		background-color: #F4A460;
		border-bottom-color: white;
		border-bottom-width: 0.2px;
		border-bottom-style: solid;
		
	}
	
	.td-inputInfo{
		text-align:left;
		padding-left: 20px;
		padding-top: 20px;
	}
	
	.td-infoPs{
		text-align : left;
		padding-left: 20px;
		padding-top: 5px;
		padding-bottom: 15px;
		border-bottom-color: gray;
		border-bottom-width: 0.2px;
		border-bottom-style: solid;
		font-size: 12px; 
		font-weight: bold;
		color: red; 
	}
	
	div.submitBtn{
		float: left;
		margin-left: 100px;
	}
	
	#updateBtn{
		padding: 20px 80px; 
		background-color: #FC5400; 
		border: 1px solid white; 
		color: white; 
		font-size: 20px; 
		font-weight: bold
	}
	
	#resetBtn{
		padding: 20px 120px;
		background-color: white;
		border: 1px solid lightgray;
		font-size: 20px; 
		font-weight: bold;
	}
	
	#withdrawalBtn{
		padding: 20px 100px; 
		background-color: #FC5400; 
		border: 1px solid white; 
		color: white; 
		font-size: 20px; 
		font-weight: bold
	}
	
	#changePwdBtn{
		padding: 20px 120px; 
		background-color: #FC5400; 
		border: 1px solid white; 
		color: white; 
		font-size: 20px; 
		font-weight: bold
	}
	
	/* reset */
	* {
		list-style: none;
		text-decoration: none;
		padding: 0;
		margin: 0;
		box-sizing: border-box;
	} 
	
	.clearfix:after {
		content: '';
		display: block;
		clear: both;
	}
	
	div.myPageTitle {
		width: 1100px;
		margin: 0 auto;
		border: 1px solid red;
	}
	
	div.container {
		width: 1200px;
		margin: 20px 0px;
	}
	
	.innerWrap {
		width: 1000px;
		min-height: 700px;
		padding: 20px;
		float: left;
		margin-top: 100px;
		margin-left: 100px;
	}
	
	.blind {
		position: absolute;
		overflow: hidden;
		clip: rect(0, 0, 0, 0);
		margin: -1px;
		width: 1px;
		height: 1px;
	}
	
	.clear {
		clear: both; /*float 속성을 제거함으로써 잘못 된 ui 적용을 막아줌 */
	}
	
		/* a 링크 : 메뉴바 */	
	a:link.liList {
		text-decoration: none;
		color: #a399a2;
	}
	
	a:visited.liList {
		text-decoration: none;
		color: #a399a2;
	}
	
	a:hover.liList{
		text-decoration: underline;
		color: #B21948;
	}
	
	a:active.liList {
		text-decoration: none;
		color: #B21948;
	}
	
	table a:link.orderList {
		text-decoration: none; 
		color: black;
	}
	
	table a:visited.orderList {
		text-decoration: none;
		color: black;
	}
	
	table a:hover.orderList{
		text-decoration: underline;
		color: #FC5400;
		cursor: pointer;
	}
	
	table a:active.orderList {
		text-decoration: none;
		color: #FC5400;
	}
	/* 페이징 처리 */
	/* 페이징 전체 틀 */
	.pagination-container {
		margin: 10px auto;
		display: flex;
	    justify-content: center;
	}
	
	.pagination {
		position: relative;
	}
	/* 'PREV' 전체 틀 */
	#pagination a {
		position: relative;
		display: inline-block;
		color: #B21948; /* 글자색상 */
		text-decoration: none;
		font-size: 1.2rem;
		padding: 8px 16px 10px;
	}
	/* 'PREV' 부분 */
	#pagination a:before {
		z-index: -1;
		position: absolute;
		height: 100%;
		width: 100%;
		content: "";
		top: 0;
		left: 0;
		background-color: #B21948;
		border-radius: 24px;
		-webkit-transform: scale(0);
		transform: scale(0);
		transition: all 0.2s;
	}
	#pagination a:hover, #pagination a #pagination-active {
		color: #fff;
	}
	
	#pagination a:hover:before, #pagination a #pagination-active:before {
		-webkit-transform: scale(1);
		transform: scale(1);
	}
	
	#pagination #pagination-active {
		color: #fff;
	}
	
	#pagination #pagination-active:before {
		-webkit-transform: scale(1);
		transform: scale(1);
	}
	/*'NEXT' 전체 틀 */
	#pagination-newer {
		margin-right: 50px;
	}
	
	#pagination-older {
		margin-left: 50px;
	}
	.productList tr{
		border-bottom: 1px solid #B21948;
	}
	.meau {
		padding-top: 30px;
		padding-left: 800px;
		font-family: 'KIMM_Bold';
	}
	
	.meau a {
		color: white;
		text-decoration: none;
	}
	select {
		padding : 5px 5px;
	}
</style>

<script type="text/javascript">
function cancel_btn() {
	var answer;
	var cancel_Form = document.getElementById('cancel_Form');
	answer=confirm("주문을 취소하시겠습니까?");
	
	if(answer == true){
		alert("주문 취소가 완료되었습니다.");
		cancel_Form.submit();
		lcation.reload(true);
		return true;
	} else if (answer == false){
		return false;
	}
}

</script>
</head>
<body>
	<%-- 전체 영역 --%>
	<div class="wrap">
		<%-- 헤더 영역 --%>
		<header>
			<%-- header include --%>
			<jsp:include page="../include/header.jsp" />
		</header>
		
		<%-- 메뉴바 --%>
		<section>
			<div class="main">
			<%-- main 화면 상단 캐러셀 (캐러셀 필요 없는 페이지는 삭제 바람!)--%>
			<aside class="aside_left">
				<nav>
					<ul>
						<li style="font-weight: bold; font-size: 20px; border-bottom-width: 3px; border-bottom-style: solid; border-bottom-color: black;"><a href="myPage_Main" style="text-decoration: none; color: black;">나의 쇼핑</a></li>
						<li><a href="myPage_orderCancel" class="liList">주문ㆍ배송</a></li>
						<li><a href="myPage_orderDetails" class="liList">교환/반품/환불</a></li>
						<li><a href="myPage_like" class="liList">찜 목록</a></li>
						<li><a href="myPage_basket" class="liList">장바구니</a></li>
						<li style="margin-bottom: 30px;"><a href="myPage_inquiry" class="liList" style="color: #B21948;">문의 내역</a></li>

						<li style="font-weight: bold; font-size: 20px; border-bottom-width: 3px; border-bottom-style: solid; border-bottom-color: black;"> 회원 정보</li>
						<li><a href="myPage_updateInfo" class="liList">회원정보 변경</a></li>
						<li><a href="myPage_changePwd" class="liList">비밀번호 변경</a></li>
						<li><a href="myPage_user_Withdrawal" class="liList">회원탈퇴</a></li>
						<li style="margin-bottom: 30px;"><a href="myPage_updateAddress" class="liList">배송지 관리</a></li>
						
						<li style="font-weight: bold; font-size: 20px; border-bottom-width: 3px; border-bottom-style: solid; border-bottom-color: black;"> 나의 상품후기</li>
						<li><a href="myPage_review" class="liList">나의 상품후기</a></li>
					</ul>
				</nav>
			</aside>


		<%-- 본문 영역 --%>
		<div class="innerWrap">
			<%-- board seach area --%>
			<section class="notice">
				<div class="page-title">
					<b style="text-align: left; font-size: 20px;">문의 내역</b><br>
				</div>
				<!-- board list area -->
				<div id="board-list">
					<div class="container">
					<form method="post" id="cancel_Form" action="order_cancel_ok.shop">
						<table class="board-table">
							<thead>
								<tr>
									<th scope="col" class="th-date1">No</th>
									<th scope="col" class="th-title">문의 유형</th>
									<th scope="col" class="th-date">제목</th>
									<th scope="col" class="th-date">작성일</th>
									<th scope="col" class="th-date">처리 현황</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${empty olist }">
									<tr>
										<th colspan="5" class="nonList">현재 문의한 내역이 없습니다.</th>
									</tr>
								</c:if>
								
							</tbody>
						</table>
						</form>
					</div>
				</div>
				<%-- 페이징 처리 --%>
				<div id="pagination" style="width: 1200px;">
					<!-- 검색 칸 공백 시 페이징 사라지지 않게 -->
	               <c:if test="${find_name == ''}"> <%--검색필드와 검색어가 없는 경우 --%>
	                 <c:if test="${page <= 1}">
	                  PREV&nbsp;
	                 </c:if>
	                 <c:if test="${page>1}">
	                  <a href="like?page=${page-1}">PREV</a>&nbsp;
	                 </c:if>
	                 
	                 <%--현재 쪽번호 출력 --%>
	                 <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
	                   <c:if test="${a == page}"> <%-- 현재 페이지가 선택된 경우 --%>
	                      [&nbsp;${a}&nbsp;]
	                   </c:if>
	                   <c:if test="${a != page}"> <%--현재 쪽번호가 선택 안 된 경우--%>
	                    <a href="like?page=${a}">[&nbsp;${a}&nbsp;]</a>&nbsp;
	                   </c:if>
	                 </c:forEach>
	                   
	                
	                <c:if test="${page >= maxpage}">
	                  &nbsp;NEXT
	                </c:if>
	                <c:if test="${page < maxpage}">
	                 <a href="like?page=${page+1}">NEXT</a>
	                </c:if>
	               </c:if>
	               <!-- 검색 칸 공백 시 페이징 사라지지 않게 -->
				    <%--검색 전 페이징 --%>
				    <c:if test="${(empty find_field) && (empty find_name)}"> <%--검색필드와 검색어가 없는 경우 --%>
				     <c:if test="${page <= 1}">
				      PREV&nbsp;
				     </c:if>
				     <c:if test="${page>1}">
				      <a href="like?page=${page-1}">PREV</a>&nbsp;
				     </c:if>
				     
				     <%--현재 쪽번호 출력 --%>
				     <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
				       <c:if test="${a == page}"> <%-- 현재 페이지가 선택된 경우 --%>
				       	[&nbsp;${a}&nbsp;]
				       </c:if>
				       <c:if test="${a != page}"> <%--현재 쪽번호가 선택 안 된 경우--%>
				        <a href="like?page=${a}">[&nbsp;${a}&nbsp;]</a>&nbsp;
				       </c:if>
				     </c:forEach>
				       
				    
				    <c:if test="${page >= maxpage}">
				      &nbsp;NEXT
				    </c:if>
				    <c:if test="${page < maxpage}">
				     <a href="like?page=${page+1}">NEXT</a>
				    </c:if>
				   </c:if>
				    
				    <%--검색이후 페이징(쪽나누기) --%>
				    <c:if test="${(!empty find_field) && (!empty find_name)}"> <%--검색필드와 검색어가 있는 경우 --%>
				     <c:if test="${page <= 1}">
				      PREV&nbsp;
				     </c:if>
				     <c:if test="${page>1}">
				      <a href="like?page=${page-1}&find_field=${find_field}&find_name=${find_name}">PREV</a>&nbsp;
				      <%-- &(엠퍼센트) 구분기호로 구분하면서 find_field=검색필드&find_name= 검색어를 get방식으로 전달해야 검색 이후 페이징 목록을 유지한다.그렇지 않으면 검색전 전체 페이징 목록으로 이동해서 검색 효과가 사라진다. --%>
				     </c:if>
				     
				     <%--현재 쪽번호 출력 --%>
				     <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
				       <c:if test="${a == page}"> <%-- 현재 페이지가 선택된 경우 --%>
				        [&nbsp;${a}&nbsp;]
				       </c:if>
				       <c:if test="${a != page}"> <%--현재 쪽번호가 선택 안 된 경우--%>
				        <a href="like?page=${a}&find_field=${find_field}&find_name=${find_name}">[&nbsp;${a}&nbsp;]</a>&nbsp;
				       </c:if>
				     </c:forEach>      
				    
				    <c:if test="${page >= maxpage}">
				      &nbsp;NEXT
				    </c:if>
				    <c:if test="${page < maxpage}">
				     <a href="like?page=${page+1}&find_field=${find_field}&find_name=${find_name}">NEXT</a>
				    </c:if>
				   </c:if> 
				   </div> <%-- end 페이징처리 --%>
				</section>
				</div></div>
				<%-- top버튼 삭제 X --%>
				<div id="topBtn">
					<span class="fonti um-arrow-circle-up um-3x icon"></span>TOP
				</div>				
							
		</section>
		
		<div class="clear"></div>
		
		<%-- 푸터 영역 --%>
		<footer>
			<!-- footer -->
			<jsp:include page="../include/footer.jsp" />
			<!-- footer 끝 -->
		</footer>
	</div>
	<script type="text/javascript">
	<td><input type="button" value="주문취소"></td>
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
		
		<%-- 장바구니 부분 --%>
		/* Set values + misc */
		var promoCode;
		var promoPrice;
		var fadeTime = 300;

		/* Assign actions */
		$('.quantity input').change(function() {
			updateQuantity(this);
		});

		$('.remove button').click(function() {
			removeItem(this);
		});

		$(document).ready(function() {
			updateSumItems();
		});

		$('.promo-code-cta').click(function() {

			promoCode = $('#promo-code').val();

			if (promoCode == '10off' || promoCode == '10OFF') {
				//If promoPrice has no value, set it as 10 for the 10OFF promocode
				if (!promoPrice) {
					promoPrice = 10;
				} else if (promoCode) {
					promoPrice = promoPrice * 1;
				}
			} else if (promoCode != '') {
				alert("Invalid Promo Code");
				promoPrice = 0;
			}
			//If there is a promoPrice that has been set (it means there is a valid promoCode input) show promo
			if (promoPrice) {
				$('.summary-promo').removeClass('hide');
				$('.promo-value').text(promoPrice.toFixed(0) + "원");
				recalculateCart(true);
			}
		});

		/* Recalculate cart */
		function recalculateCart(onlyTotal) {
			var subtotal = 0;

			/* Sum up row totals */
			$('.basket-product').each(function() {
				subtotal += parseFloat($(this).children('.subtotal').text());
			});

			/* Calculate totals */
			var total = subtotal;

			//If there is a valid promoCode, and subtotal < 10 subtract from total
			var promoPrice = parseFloat($('.promo-value').text());
			if (promoPrice) {
				if (subtotal >= 10) {
					total -= promoPrice;
				} else {
					alert('Order must be more than £10 for Promo code to apply.');
					$('.summary-promo').addClass('hide');
				}
			}

			/*If switch for update only total, update only total display*/
			if (onlyTotal) {
				/* Update total display */
				$('.total-value').fadeOut(fadeTime, function() {
					$('#basket-total').html(total.toFixed(0) + "원");
					$('.total-value').fadeIn(fadeTime);
				});
			} else {
				/* Update summary display. */
				$('.final-value').fadeOut(fadeTime, function() {
					$('#basket-subtotal').html(subtotal.toFixed(0) + "원");
					$('#basket-total').html(total.toFixed(0) + "원");
					if (total == 0) {
						$('.checkout-cta').fadeOut(fadeTime);
					} else {
						$('.checkout-cta').fadeIn(fadeTime);
					}
					$('.final-value').fadeIn(fadeTime);
				});
			}
		}

		/* Update quantity */
		function updateQuantity(quantityInput) {
			/* Calculate line price */
			var productRow = $(quantityInput).parent().parent();
			var price = parseFloat(productRow.children('.price').text());
			var quantity = $(quantityInput).val();
			var linePrice = price * quantity;

			/* Update line price display and recalc cart totals */
			productRow.children('.subtotal').each(function() {
				$(this).fadeOut(fadeTime, function() {
					$(this).text(linePrice.toFixed(0) + "원");
					recalculateCart();
					$(this).fadeIn(fadeTime);
				});
			});

			productRow.find('.item-quantity').text(quantity);
			updateSumItems();
		}

		function updateSumItems() {
			var sumItems = 0;
			$('.quantity input').each(function() {
				sumItems += parseInt($(this).val());
			});
			$('.total-items').text(sumItems);
		}

		/* Remove item from cart */
		function removeItem(removeButton) {
			/* Remove row from DOM and recalc cart total */
			var productRow = $(removeButton).parent().parent();
			productRow.slideUp(fadeTime, function() {
				productRow.remove();
				recalculateCart();
				updateSumItems();
			});
		}
		
		<%-- 리뷰 작성 페이지 부분 --%>
		// 왼쪽 사이드바의 '나의 후기' 텍스트 클릭시 새창 열기
		function openPopup_review_write() {
	        var page_width = '490';
	        var page_height = '900';
	    
	        // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
	        var page_left = Math.ceil((window.screen.width - page_width)/2);
	        var page_top = Math.ceil((window.screen.height - page_height)/2);
	
	    window.open("http://localhost:8046/MVC/page/mypage2/review_write.jsp", "review_write",'width='+ page_width +', height='+ page_height +', left=' + page_left + ', top='+ page_top);
	    
	    }
		
	</script>
</body>
</html>
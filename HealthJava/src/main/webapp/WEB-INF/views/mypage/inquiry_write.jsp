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

<title>HealthJava 문의글</title>
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
	.page-title {
		width: 1000px;
		min-height: 10px;
		padding: 0px 10px;
		text-align: left;
	}
	
	.innerWrap {
		width: 1000px;
		min-height: 700px;
		padding: 20px;
		float: left;
		margin-top: 100px;
		margin-left: 100px;
	}
	
	section.notice {
		padding: 20px 0;
		/*추가*/
		width: 1200px;
		min-height: 200px;
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
		
		<%-- 메뉴바 --%>
		<section>
			<div class="main">
			<%-- main 화면 상단 캐러셀 (캐러셀 필요 없는 페이지는 삭제 바람!)--%>
			<aside class="aside_left">
				<nav>
					<ul>
						<li style="font-weight: bold; font-size: 20px; border-bottom-width: 3px; border-bottom-style: solid; border-bottom-color: black;"><a href="myPage_Main" style="text-decoration: none; color: black;">나의 쇼핑</a></li>
						<li><a href="myPage_order" class="liList">주문ㆍ배송</a></li>
						<li><a href="myPage_orderDetails" class="liList">교환/반품/환불</a></li>
						<li><a href="myPage_like" class="liList">찜 목록</a></li>
						<li><a href="myPage_cart" class="liList">장바구니</a></li>
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
					<b style="text-align: left; font-size: 20px;">문의글</b><br>
				</div>
				<!-- 작성 테이블 -->
				<form action="inquiry_write_ok" method="post">
				<div class="c_title">
					<div class="c_typeA"><!-- 카테고리 선택 -->
						<div class="client_type">유형을 선택해 주세요.</div>
						<div class="client_chocie">주문내역을 선택하세요.</div>
						<div class="client_btn"><input type="button" value="주문 상품 선택" onclick="" /></div>
					</div>
					<div class="client_cont">
					<textarea rows="12px" cols="100px" class="clicent_text"
						placeholder="의견을 남겨주세요
		
		※ 추가적인 문의 내용 확인이 필용한 경우 전화로 연락 드릴 수 있습니다. 
		
		※ Customer service is available in Korean and English. For support in other languages, machine translation is used. Machine-translated answers may not necessarily be accurate. In this case, please make inquiries again and we will try to provide more accurate answers."></textarea>
					<div class="client_photo">
						<span>이미지첨부</span>
						<span>20MB 이내 / jpg, png, gif 만 가능</span>
						<span>0개 / 최대 3개</span>
						<div>
						"※ "
						"내용 본문과 첨부된 파일, 이미지에 고객님의 개인 정보(계좌, 카드, 주민번호 등)가  포함되지 않도록 주의해주세요."
						</div>
					</div>
					<div class="c_photo">"이미지를 여기로 끌어다 놓거나, 여기를 눌러 파일을 선택하세요."</div>
					<input type="file" accept="image/*" multiple class="multiple" />
				</div>
				<div class="client_btn_send">
					<button width="180px" class="c_btn_send">보내기</button>
				</div>
				</div>
				</form>
								
			</section>
		</div>
		</div>
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
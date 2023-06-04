<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src = "./js/jquery.js"></script>
<script src="./js/post2.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Health자바 배송지 추가</title>
<script type="text/javascript">
function closePopup() {
	var popup = window.self;
	popup.close();
}
</script>

<style type="text/css">
	/* 폰트 CSS */
	@font-face {
		font-family: 'KIMM_Bold';
		src:
			url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2212@1.0/KIMM_Bold.woff2')
			format('woff2'); /* CDN 절대링크  */
		font-weight: 700;
		font-style: normal;
	}
	.popup-content {
		width: 700px;
		height: 300px;
	}
	table {
		font-family: 'KIMM_Bold';
	}
	.btn{
		font-family: 'KIMM_Bold';
		background-color: #B21948;
		color: white;
		border: 1px solid white;
		padding : 10px 50px;
		font-weight: bold; 
	}
	.page-title {
		width: 550px;
		height: auto;
		margin-left: 10px;
	}
	.th-list {
	    text-align: center;
	    margin-top: 20px;
	    margin-bottom: 20px;
	    padding: 30px;
	    background-color: #B21948;;
	    border-bottom-color: white;
	    border-bottom-width: 0.2px;
	    border-bottom-style: solid;
	    color: white;
	}
	.td-inputInfo{
		text-align:left;
		padding-left: 20px;
		padding-top: 20px;
	}
	.td-inputInfoD {
		text-align:left;
		padding-left: 20px;
		padding-top: 20px;
		padding-bottom: 15px;
	    border-bottom-color: gray;
	    border-bottom-width: 0.2px;
	    border-bottom-style: solid;
	    font-size: 12px;
	    font-weight: bold;
	    color: red;
	}
	.popup-buttons {
		font: left;
		margin-left: 250px;
	}
</style>
</head>
<body>
	<!-- 배송지 추가 팝업 -->
	<div id="addAddressPopup" class="popup">
		<div class="popup-content">
			<h2 style="font-family: 'KIMM_Bold';">배송지 추가</h2>
			<form method="post" action="addAddress_ok">
				<div class="page-title">
				<table>
					<!--주소-->
					<tr>
						<th rowspan="5" class="th-list" width="170px" style="border-top-color: black; border-top-style: solid; border-top-width: 3px;">배송지 주소</th>
						<th width="170px" style="border-top-color: black; border-top-style: solid; border-top-width: 3px;"></th>
					</tr>
					<tr>
						<td class="td-inputInfo">
						<input type="text" name="postCode" id="postCode" size="20" placeholder="우편번호"/>&nbsp;&nbsp;
						<input type="button" class="btn" value="주소검색" onclick="post()" />
						</td>
					</tr>
					<tr>
						<td class="td-inputInfo">
							<input type="text" name="roadAddr" id="roadAddr" size="70" placeholder="주소">
						</td>
					</tr>

					<tr>
						<td class="td-inputInfoD">
							<input type="text" name="detailAddr" id="detailAddr" size="70" placeholder="상세주소">
						</td>
					</tr>
					
					<tr>
						<td class="td-infoPs"></td>
					</tr>
					
					<tr>
						<td></td>
					</tr>
				</table>
				</div>
				<br>
				<div class="popup-buttons">
					<input type="submit" class="btn" value="추가"> 
					<input type="button" class="btn" value="취소" onclick="closePopup()">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
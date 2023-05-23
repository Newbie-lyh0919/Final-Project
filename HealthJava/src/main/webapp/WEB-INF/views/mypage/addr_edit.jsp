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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="./js/updateInfo.js"></script>
<script src="./js/addr_edit.js"></script>
<script src="./js/post2.js"></script>

<title>Health자바 배송지 수정</title>

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
         <form method="post" id="editForm" action="addr_edit_ok" onsubmit="return addr_edit();">
         
         <input type="hidden" name="addr_no" id="addr_no" value="${alist.addr_no }" />
            <div class="page-title">
            <table>
               <!--주소-->
               <tr>
                  <th rowspan="5" class="th-list" width="170px" style="border-top-color: black; border-top-style: solid; border-top-width: 3px;">배송지 주소</th>
                  <th width="170px" style="border-top-color: black; border-top-style: solid; border-top-width: 3px;"></th>
               </tr>
               <tr>                  
                  <td class="td-inputInfo">
                  <input type="text" name="addr_name" id="addr_name" size="20" placeholder="배송지 닉네임" value="${alist.addr_name }" />&nbsp;&nbsp;
                  </td>                  
               </tr>
               <tr>
                  <td class="td-inputInfo">
                  <input type="text" name="postCode" id="postCode" size="20" value="${alist.postCode }" placeholder="우편번호"/>&nbsp;&nbsp;
                  <input type="button" class="btn" value="주소검색" onclick="post()" />
                  </td>
               </tr>
               <tr>
                  <td class="td-inputInfo">
                     <input type="text" name="roadAddr" id="roadAddr" value="${alist.roadAddr }" size="70" placeholder="주소">
                  </td>
               </tr>

               <tr>
                  <td class="td-inputInfoD">
                     <input type="text" name="detailAddr" id="detailAddr" value="${alist.detailAddr }" size="70" placeholder="상세주소">
                  </td>
               </tr>
               <tr>
                  <td></td>
               </tr>
            </table>
            </div>
            <br>
            <div class="popup-buttons">
               <input type="submit" class="btn" value="수정" onclick="edit_check();"> 
               <input type="button" class="btn" value="취소">
            </div>
         </form>
         <script type="text/javascript">
         /*수정 버튼 클릭*/
         function edit_check(){
            var answer;
            var editForm = document.getElementById('editForm');
            auswer = confirm("수정하시겠습니까?");
            
            if(answer == true){
               alert("수정 완료되었습니다.");
               editForm.submit();
               location.href='myPage_updateAddress';
               return true;
            } else if (answer == false) {
               return false;
            }
         }
         </script>
      </div>
   </div>
</body>
</html>
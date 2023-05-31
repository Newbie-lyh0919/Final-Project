
//관리자 문의게시판 관리페이지

//문의게시판 검색
function CSBoard_search(){
	   var searchType =  $('#search_type').val();
	   var searchField =  $('#search_field').val();
      
	  var adminTab = $('#adminTab2').attr('value');
	  console.log(adminTab);
   $.ajax({//$는 jQuery란 뜻. $.ajax 뜻은 jQuery 내의 아작스 실행
      url:"/admin_list", //url 패턴 매핑주소 경로
      type:"POST",//데이터를 서버로 보내는 방법
      data: {
      	"search_field" : searchField,
      	"search_type" : searchType,
		"adminTab" : adminTab
      },  //좌측 id 피라미터 이름에 우측 $mem_id변수값을 저장
      datatype: "json",//서버의 실행된 결과값을 사용자로 받아오는 자료형
		traditional : true,
      success: function (res) {	
		var clist = res.clist;
 		$('#ajaxHead').empty();
 		$('#ajaxTh').empty();
 		$('#ajaxTable').empty();
        var CSBoardCountHtml = "<div align='right'>총 문의글 수: " + res.CSBoard_count + "개</div>";
        $('#ajaxHead').append(CSBoardCountHtml);

        var table_head = `
          <h3 align="center">&nbsp;문의 게시판&nbsp;관리</h3>
          <table align="center">
            <tr>
              <td align="center">
                <select name="search_type" id="search_type">
                  <option value="All" ${searchType == 'All' ? 'selected' : ''}>전체</option>
                  <option value="client_title" ${searchType == 'client_title' ? 'selected' : ''}>제목</option>
                  <option value="client_category" ${searchType == 'client_category' ? 'selected' : ''}>문의 유형</option>
                  <option value="user_id" ${searchType == 'user_id' ? 'selected' : ''}>작성자</option>
                </select> 
                <input id="search_field" name="search_field" size="20"> &nbsp;&nbsp;&nbsp;
                <input type="button" id="btn" name="search" value="검색" onclick="CSBoard_search();" />
              </td>
            </tr>
          </table>
          <p>
          <p>
          `
          $('#ajaxHead').append(table_head);
          
          $('#ajaxTh').empty();
          
          var table_th = `
					<tr>
						<th width="100">No</th>
						<th width="100">답변 유무</th>
						<th width="200">문의 유형</th>
						<th width="200">제목</th>
						<th width="200">작성자</th>
						<th width="200">작성일</th>
					</tr>
        `;

        $('#ajaxTh').append(table_th);
        
		$('#ajaxTable').empty();
		 for(let i = 0; i < clist.length; i++){
		 var clientContReply = clist[i].client_cont_reply;
			 const html = `
				<tr>
  			 <td>${clist[i].client_no}</td>
             ${clientContReply !== ' ' ? '<td>답변완료</td>' : '<td>대기</td>'}
			 <td>${clist[i].client_category}</td>
			 <td><a href= 'admin_CSBoard_cont?client_no=${clist[i].client_no}&state=cont&user_id=${clist[i].user_id}';>${clist[i].client_title}</a> </td>
			 <td>${clist[i].user_id}</td>
			 <td>${clist[i].client_date.substring(0,10)}</td>
			 </tr>
			 `
             //통신 성공시 탭 내용담는 div를 읽어들인 값으로 채운다.
             $('#ajaxTable').append(html); 
  		 }
	  }
    });//$.ajax

}

//관리자 상품관리페이지

//상품검색

function product_search(){
	   var searchType =  $('#search_type').val();
	   var searchField =  $('#search_field').val();
     
	  var adminTab = $('#adminTab3').attr('value');
	  console.log(adminTab);
   $.ajax({//$는 jQuery란 뜻. $.ajax 뜻은 jQuery 내의 아작스 실행
      url:"/admin_list", //url 패턴 매핑주소 경로
      type:"POST",//데이터를 서버로 보내는 방법
      data: {
      	"search_field" : searchField,
      	"search_type" : searchType,
		"adminTab" : adminTab
      },  //좌측 id 피라미터 이름에 우측 $mem_id변수값을 저장
      datatype: "json",//서버의 실행된 결과값을 사용자로 받아오는 자료형
		traditional : true,
      success: function (res) {	
		var plist = res.plist;
 		$('#ajaxHead').empty();
 		$('#ajaxTh').empty();
 		$('#ajaxTable').empty();
        var ProductCountHtml = "<div align='right'>총 상품 수: " + res.product_count + "개</div>";
        $('#ajaxHead').append(ProductCountHtml);

        var table_head = `
          <h3 align="center">&nbsp;상품 목록&nbsp;관리</h3>
          <table align="center">
            <tr>
              <td align="center">
                <select name="search_type" id="search_type">
                  <option value="All" ${searchType == 'All' ? 'selected' : ''}>전체</option>
                  <option value="product_title" ${searchType == 'product_title' ? 'selected' : ''}>상품명</option>
                  <option value="product_maker" ${searchType == 'product_maker' ? 'selected' : ''}>제조사</option>
                  <option value="product_type" ${searchType == 'product_type' ? 'selected' : ''}>대분류</option>
                  <option value="product_type2" ${searchType == 'product_type2' ? 'selected' : ''}>소분류</option>
                </select> 
                <input id="search_field" name="search_field" size="20"> &nbsp;&nbsp;&nbsp;
                <input type="button" id="btn" name="search" value="검색" onclick="product_search();" />
              </td>
            </tr>
          </table>
          <p>
          <p>
          `
          $('#ajaxHead').append(table_head);
          
          $('#ajaxTh').empty();
          
          var table_th = `
					<tr>
					<th width="50" height="50">&nbsp;</th>
					<th width="50">No</th> 
					<th width="400">상품명</th>  
					<th width="200">제조사</th>  
					<th width="300">대분류</th> 
					<th width="300">소분류</th> 
					<th width="200">가격</th>
					<th width="200">등록날짜</th> 
					<th width="100">비고</th> 
					</tr>
        `;

        $('#ajaxTh').append(table_th);
        
function numberWithCommas(x) {
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
			 $('#ajaxTable').empty();
		 for(let i = 0; i < plist.length; i++){
			 const html = `
				<tr>
				<td></td>
  			 <td>${plist[i].product_no}</td>
			 <td>${plist[i].product_title}</td>
			 <td>${plist[i].product_maker}</td>
			 <td>${plist[i].product_type}</td>
			 <td>${plist[i].product_type2}</td>
			 <td>${numberWithCommas(plist[i].product_price)} 원</td>
			 <td>${plist[i].product_date.substring(0,10)}</td>
			 <td align="center">
			 <input id="btn" type="button" value="수정" > 
			 </td>						 
			 
			 </tr>
			 `
             //통신 성공시 탭 내용담는 div를 읽어들인 값으로 채운다.
             $('#ajaxTable').append(html); 
  		 }
	  }
    });//$.ajax

}

/*상품 QNA 목록 조회*/
function GsQNA_search(){
	   var searchType =  $('#search_type').val();
	   var searchField =  $('#search_field').val();
   
	  var adminTab = $('#adminTab4').attr('value');
	  console.log(adminTab);

  $.ajax({//$는 jQuery란 뜻. $.ajax 뜻은 jQuery 내의 아작스 실행
      url:"/admin_list", //url 패턴 매핑주소 경로
      type:"POST",//데이터를 서버로 보내는 방법
      data: {
      	"search_field" : searchField,
      	"search_type" : searchType,
      	"adminTab" : adminTab
      },  //좌측 id 피라미터 이름에 우측 $mem_id변수값을 저장
      datatype: "json",//서버의 실행된 결과값을 사용자로 받아오는 자료형
		traditional : true,
      success: function (res) {	
        		var qlist = res.qlist;
 		$('#ajaxHead').empty();
 		$('#ajaxTh').empty();
 		$('#ajaxTable').empty();
        var GsQNACountHtml = "<div align='right'>총 문의글 수: " + res.GsQNA_count + "개</div>";
        $('#ajaxHead').append(GsQNACountHtml);

        var table_head = `
          <h3 align="center">&nbsp;상품 QNA&nbsp;목록 관리</h3>
          <table align="center">
            <tr>
              <td align="center">
                <select name="search_type" id="search_type">
                  <option value="All" ${searchType == 'All' ? 'selected' : ''}>전체</option>
                  <option value="qna_title" ${searchType == 'qna_title' ? 'selected' : ''}>제목</option>
                  <option value="qna_mem_id" ${searchType == 'qna_mem_id' ? 'selected' : ''}>작성자</option>
                </select> 
                <input id="search_field" name="search_field" size="20"> &nbsp;&nbsp;&nbsp;
                <input type="button" id="btn" name="search" value="검색" onclick="GsQNA_search();" />
              </td>
            </tr>
          </table>
          <p>
          <p>
          `
          $('#ajaxHead').append(table_head);
          
          $('#ajaxTh').empty();
          
          var table_th = `
					<tr>
							<th width="100;" height="50">No</th> 
							<th width="100">답변 유무</th>
							<th width="200;">상품 NO</th> 
							<th width="200;">제목</th> 
							<th width="200">작성자</th> 
							<th width="200;">작성일</th> 
						</tr> 
        `;

        $('#ajaxTh').append(table_th);

		   $('#ajaxTable').empty();	
		 for(let i = 0; i < qlist.length; i++){
		 var QNAReply = qlist[i].qna_reply;
			 const html = `
				<tr>
  			 <td>${qlist[i].qna_no}</td>
             ${QNAReply !== ' ' ? '<td>답변완료</td>' : '<td>대기</td>'}
			 <td>${qlist[i].qna_product_no}</td>
			 <td><a href='admin_GsQNA_cont?qna_no=${qlist[i].qna_no}&qna_mem_id=${qlist[i].qna_mem_id}';>${qlist[i].qna_title}</a> </td>
			 <td>${qlist[i].qna_mem_id}</td>
			 <td>${qlist[i].qna_date.substring(0,10)}</td>
			 </tr>
			 `
             //통신 성공시 탭 내용담는 div를 읽어들인 값으로 채운다.
             $('#ajaxTable').append(html); 
  		 }
	  }
    });//$.ajax
}


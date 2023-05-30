/* 검색필드 검색목록 */    
function search_FoodList(){
	//$('#searchBtn').click(function(e) {
	   var searchField =  $('#search_field').val();
	   var searchType =  $('#search_type').val();

  $.ajax({//$는 jQuery란 뜻. $.ajax 뜻은 jQuery 내의 아작스 실행
      url:"/search_FoodList", //url 패턴 매핑주소 경로
      type:"POST",//데이터를 서버로 보내는 방법
      data: {
      	"search_field" : searchField,
      	"search_type" : searchType
      },  
      datatype: "json",//서버의 실행된 결과값을 사용자로 받아오는 자료형
		traditional : true,
      success: function (res) {	
                $('#product_grid').empty();
					
					for(let i =0; i<res.length; ++i){
    				
					
					const html = `
					<div class="a" style="width:200px; float:left; margin: 100px 100px;">
   						
    						<a href="/product/detail/${res[i].product_no}"><img src="../upload${res[i].product_cont1}" width="400" height="200" /></a>
   						
   						<br>
  					 	
    				
    				 <span>상품명 : </span>${res[i].product_title}<br />
    				 <span>가격 : </span>${res[i].product_price} 원<br />             
    				<span>제조사 : </span>${res[i].product_maker}<br /> 
   						
  					   </div>
					`
					
					
					$('#product_grid').append(html);
               }   
	  }
    });//$.ajax
}
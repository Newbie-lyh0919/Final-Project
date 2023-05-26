/**
 * 
 */
$(function() {
		// tab operation
		$('.function').click(function(e) { // <- e는 클릭 당한(사용자가 클릭한) 객체의 이벤트
			
			//$('li').css('background-color', 'white');
			//$(this).css('background-color', 'green');
			
		
			
			// 나중에 console.log(e)찍어보기
			// 나중에 console.log(e.target) 찍어보기
			// e.target -> 사용자가 클릭한 li 를 가리킨다
			var kind2 =  $(e.target).attr('data-tab');
			
			//alert(kind2);
			
			$.ajax({
				// 데이터 준비단계 1
				type : 'POST',                 //get방식으로 통신
				
				//contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				url : "/product/list",     //탭의 data-tab속성의 값 컨트롤러 주소
				data : {
					"kind2":kind2
				},
				 //data: JSON.stringify({"kind":kind}),
				//dataType : "json",  //json 형식으로 값 읽기
				dataType:"json",
				//contentType: 'application/json',
				
				
				// 성공했을 때 -> 200번
				success : function(res) {    //<- 여기서  data 는 board/ajax의 return, data는 jsp 코드
					
					console.log(res);
					
					
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
					
					//통신 성공시 탭 내용담는 div를 읽어들인 값으로 채운다.
					//$('#tabcontent').append(res); 
					
					//document.getElementById('tabcontent').innerHTML = html;
					//console.log(document.getElementById('tabcontent'));
					//innerhtml 
				}
				// 데이터 받는 단계
				// 에러났을 때 -> 400, 500번대 에러
				//error : function() {          //통신 실패시
					//alert('통신실패!');
				//},
			});
		});
		//$('#default').click();          
	});
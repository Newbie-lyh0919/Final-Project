// 탭 클릭 이벤트 핸들러
$('.menuCategory').click(function(e) {
  var kind = $(e.target).attr('data-tab');
  
  // 서버로 kind 값을 전달하여 리스트 갯수를 받아옴
  $.ajax({
    type: 'POST',
    url: '/product/list2',
    data: {
      "kind": kind
    },
    dataType: 'json',
    success: function(res) {
      //alert(res.page_count);
      $('#product_grid2').empty();

      for (let i = 1; i <= res.page_count; i++) {
  const html = `<span class="page-link" data-page="${i}" style="display: inline-block; margin: 0 5px;">[${i}]</span>`;
  $('#product_grid2').append(html);
}
      // 페이지 번호를 클릭했을 때의 이벤트 핸들러 추가
      $('.page-link').click(function() {
        const page = $(this).data('page');
        // 컨트롤러로 페이지 번호와 kind 값을 전달
        $.ajax({
          type: 'POST',
          url: '/product/list',
          data: {
            "page": page,
            "kind": kind
          },
          dataType: 'json',
          success: function(res) {
            console.log(res);
            // 데이터를 받아와서 화면을 갱신하는 로직 추가
            $('#product_grid').empty();

            for (let i = 0; i < res.length; ++i) {
              const html = `
                <div class="a" style="width:200px; float:left; margin: 100px 100px;">
                  <a href="/product/detail/${res[i].product_no}"><img src="../upload${res[i].product_cont1}" width="400" height="200" /></a>
                  <br>
                  <span>상품명 : </span>${res[i].product_title}<br />
                  <span>가격 : </span>${res[i].product_price} 원<br />
                  <span>제조사 : </span>${res[i].product_maker}<br /> 
                </div>
              `;

              $('#product_grid').append(html);
            }
          },
          error: function(xhr, status, error) {
            // 에러 처리
            console.log('Error:', error);
          }
        });
      });
    },
    error: function(xhr, status, error) {
      // 에러 처리
      console.log('Error:', error);
    }
  });
});
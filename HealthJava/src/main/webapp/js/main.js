$(document).on('click', '.page-link', function() {
  const page = $(this).data('page');
  
 
  $.ajax({
    type: 'POST',
    url: '/new/list',
    data: {
      "page": page,
      "kind": $(this).data('kind'),
      "kind2": $(this).data('kind2'),
      "search_field": $('#search_field').val(),
      "search_type": $('#search_type').val()
    },
    dataType: 'json',
    success: function (res) {
			var flist = res.flist; // flist 가져오기
    var totalPages = res.totalPages; // totalPages 가
		
      $('#product_grid2').empty();

	

      for (let i = 1; i <= totalPages; i++) {
        const html = `<span class="page-link" data-page="${i}" style="display: inline-block; margin: 0 5px;">[${i}]</span>`;
        $('#product_grid2').append(html);
      }
      
      $('#product_grid').empty();

      for (let i = 0; i < flist.length; ++i) {
        const html = `
          <div class="a" style="width:200px; float:left; margin: 100px 100px;">
            <a href="/product/detail/${flist[i].product_no}"><img src="../upload${flist[i].product_cont1}" width="400" height="200" /></a>
            <br>
            <span>상품명 : </span>${flist[i].product_title}<br />
            <span>가격 : </span>${flist[i].product_price} 원<br />             
            <span>제조사 : </span>${flist[i].product_maker}<br /> 
          </div>
        `;

        $('#product_grid').append(html);
      }
    },
    error: function(xhr, status, error) {
      console.log('Error:', error);
    }
  });
});

function search_ProductList(kind, kind2) {
  var searchField = $('#search_field').val();
  var searchType = $('#search_type').val();

  $.ajax({
    url: "/new/list",
    type: "POST",
    data: {
      "search_field": searchField,
      "search_type": searchType,
      "kind": kind,
      "kind2": kind2
    },
    dataType: "json",
    success: function (res) {
		
		var flist = res.flist; // flist 가져오기
    var totalPages = res.totalPages; // totalPages 가
		
      $('#product_grid2').empty();
		
      for (let i = 1; i <= totalPages; i++) {
        const html = `<span class="page-link" data-page="${i}" style="display: inline-block; margin: 0 5px;">[${i}]</span>`;
        $('#product_grid2').append(html);
      }

      $('#product_grid').empty();

      for (let i = 0; i < flist.length; ++i) {
        const html = `
          <div class="a" style="width:200px; float:left; margin: 100px 100px;">
            <a href="/product/detail/${flist[i].product_no}"><img src="../upload${flist[i].product_cont1}" width="400" height="200" /></a>
            <br>
            <span>상품명 : </span>${flist[i].product_title}<br />
            <span>가격 : </span>${flist[i].product_price} 원<br />             
            <span>제조사 : </span>${flist[i].product_maker}<br /> 
          </div>
        `;

        $('#product_grid').append(html);
      }
    },
    error: function (xhr, status, error) {
      console.log('Error:', error);
    }
  });
}

$(function () {
  $('.menuCategory, .function').click(function (e) {
    var kind;
    var kind2;

    if ($(this).hasClass('menuCategory')) {
      kind = $(e.target).attr('data-tab');
    }
    if ($(this).hasClass('function')) {
      kind2 = $(e.target).attr('data-tab');
    }

    search_ProductList(kind, kind2);
  });
  $('#default').click();
});
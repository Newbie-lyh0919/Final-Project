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

        search_ProductList(kind, kind2); // search_ProductList 함수 호출
    });
    $('#default').click();
});
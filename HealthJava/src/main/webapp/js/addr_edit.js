/**
 * 배송지 수정 유효성 검사
 * addr_edit.js
 */
function addr_edit() {
    if($.trim($('#addr_name').val())==""){
        alert("배송지 이름을 입력해 주세요.");
        $('#addr_name').val("").focus();
        return false;
    }
    if($.trim($('#postCode').val())==""){
        alert("우편 번호를 등록해 주세요.");
        $('#postCode').val("").focus();
        return false;
    }
    if($.trim($('#detailAddr').val())==""){
        alert("상세 주소를 입력해주세요.");
        $('#detailAddr').val("").focus();
        return false;
    }
}
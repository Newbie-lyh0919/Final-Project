
function update_check(){
	
	if($.trim($("#user_name").val())==""){
		alert("회원이름을 입력하세요!");
		$("#user_name").val("").focus();
		return false;
	}
	if($.trim($("#user_birth").val())==""){
		alert("생년월일 입력하세요!");		
		return false;
	}
	if($.trim($("#postCode").val())==""){
		alert("우편번호를 입력하세요!");		
		return false;
	}
	if($.trim($("#roadAddr").val())==""){
		alert("주소를 입력하세요!");		
		return false;
	}

	if($.trim($("#user_email").val())==""){
		alert("이메일 입력하세요!");
		$("#user_email").val("").focus();
		return false;
	}
	if($.trim($("#user_phone").val())==""){
		alert("폰번호를 입력하세요!");
		$("#user_phone").val("").focus();
		return false;
	}
	
	alert("정보 수정 성공!");
}


function pwd_check(){
	$user_pwd=$.trim($("#user_pwd").val());
	$new_pwd=$.trim($("#new_pwd").val());
	
	if($.trim($("#user_pwd").val())==""){
		alert("현재 비밀번호를 입력하세요!");
		$("#user_pwd").val("").focus();
		return false;
	}
	 
	if($.trim($("#new_pwd").val())==""){
		alert("새 비밀번호를 입력하세요!");
		$("#new_pwd").val("").focus();
		return false;
	}

}

function withdrawal_check(){
	$user_id=$.trim($("#user_id").val());
	$user_pwd=$.trim($("#user_pwd").val());
	$user_pwd_check=$.trim($("#user_pwd_check").val());
	
	if($.trim($("#user_id").val())==""){
		alert("아이디를 입력하세요!");
		$("#user_id").val("").focus();
		return false;
	}
	
	if($.trim($("#user_pwd").val())==""){
		alert("비밀번호를 입력하세요!");
		$("#user_pwd").val("").focus();
		return false;
	}
	 
	if($.trim($("#user_pwd_check").val())==""){
		alert("비밀번호 확인을 입력하세요!");
		$("#user_pwd_check").val("").focus();
		return false;
	}

	if($user_pwd != $user_pwd_check){
		alert("비번이 다릅니다!");
		$("#user_pwd").val("");
		$("#user_pwd_check").val("");
		$("#user_pwd").focus();
		return false;
	}

}































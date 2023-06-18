$(document).ready(function(){

	/* 윈도우 창 */
	$("#findIdBtn").click(function(){
		window.open("login_idFind.do", "_blank", "width=1000, height=550");
	}); // findIdBtn
	
	$("#findPwBtn").click(function(){
		window.open("login_pwFind.do", "_blank", "width=1000, height=550");
	}); // findPwBtn


	/* 아이디 찾기 입력 */
	$("#btnFindId").click(function(){
		var name = $("#name").val();
		var birth = $("#birth").val();
		var phone = $("#phone").val();
		
		if (name == ""){
			alert("이름을 입력해주세요.");
			$("#name").focus();
			return false;
		} else if (birth == ""){
			alert("생년월일을 입력해주세요.");
			$("#birth").focus();
			return false;
		} else if (phone == ""){
			alert("번호를 입력해주세요. '-' 제외");
			$("#phone").focus();
			return false;
		} else {
			$.ajax({
				url : "login_idFind_proc.do?name=" + name + "&birth=" + birth + "&phone=" + phone ,
				success : function(result){
					if (result == ""){
						alert("존재하지 않는 정보입니다.");
						location.href="login_idFind.do";
					} else {
						location.href="login_idSelect.do?id=" + result;
					}
				}
				
			}); // ajax
			
		}
	}); // btnFindId
	
	/* 비밀번호 찾기 입력 */
	$("#btnFindPw").click(function(){
		if ($("#id").val() == ""){
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		} else if ($("#name").val() == ""){
			alert("이름을 입력해주세요.");
			$("#name").focus();
			return false;
		} else if ($("#birth").val() == ""){
			alert("생년월일을 입력해주세요.");
			$("#birth").focus();
			return false;
		} else if ($("#phone").val() == ""){
			alert("번호를 입력해주세요. '-' 제외");
			$("#phone").focus();
			return false;
		} else {
			var id = $("#id").val();
			var name = $("#name").val();
			var birth = $("#birth").val();
			var phone = $("#phone").val();
			
			$.ajax({
				url : "login_pwFind_proc.do?id=" + id + "&name=" + name + "&birth=" + birth + "&phone=" + phone ,
				success : function(result){
					if (result == ""){
						alert("존재하지 않는 정보입니다.");
						location.href="login_pwFind.do";
					} else {
						location.href="login_pwSelect.do?pass=" + result;
					}
				}
			}); // ajax
		}
					
	}); // btnFindPw
	
	/**
	 * 회원가입
	 */
	$("#updatebtn").click(function(){
		if ($("#pass").val() == ""){
			alert("비밀번호를 입력해주세요.");
			$("#pass").focus();
			return false;
		} else if ($("#cpass").val() == ""){
			alert("비밀번호 확인을 입력해주세요.");
			$("#cpass").focus();
			return false;
		} else if ($("input[name = 'gender']:checked").length == 0){
			alert("성별을 선택해주세요.");
			return false;
		} else if ($("input[name = 'tel']:checked").length == 0){
			alert("통신사를 선택해주세요.");
			return false;
		} else if ($("#phone").val() == ""){
			alert("번호를 입력해주세요.");
			$("#phone").focus();
			return false;
		} else if ($("#email1").val() == ""){
			alert("이메일을 입력해주세요.");
			$("#email1").focus();
			return false;
		} else if ($("#email2").val() == ""){
			alert("주소를 입력 또는 선택해주세요.");
			$("#email3").focus();
			return false;
		} else if ($("#car1").val() == ""){
			alert("차량번호를 입력해주세요.");
			$("#car1").focus();
			return false;
		} else if ($("#car2").val() == ""){
			alert("차량번호를 입력해주세요.");
			$("#car2").focus();
			return false;
		} else{
			
			mp_updateForm.submit();
		}
	}); // btnJoin
	
	
	
}); // ready
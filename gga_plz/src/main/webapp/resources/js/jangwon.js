$(document).ready(function(){

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
						alert(result);
						location.href="login.do";
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
						alert(result);
						location.href="login.do";
					}
				}
			}); // ajax
		}
					
	}); // btnFindPw
	
}); // ready
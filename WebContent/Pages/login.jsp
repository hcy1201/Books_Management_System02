<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="../Image/logo.jpg"
	type="image/x-icon">
<script src="../JS/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../CSS/login.css"/>
</head>
<body>

<div class="loginDiv">
			<div class="accLogin">
				<input type="text" placeholder=" 账 号" id="txtAcc" /><img id="imgAcc" hidden="hidden"/>
			</div>
			<div class="pwdLogin">
				<input type="password" placeholder=" 密 码" id="txtPwd" /><img id="imgPwd" hidden="hidden"/>
			</div>
			<div class="rememLogin">
				<input type="checkbox" value="记住密码" id="rememPwd" />
				<label for="rememPwd"> 记住密码</label>
			</div>
			<div class="findLogin">
				<label id="findPwd">找回密码</label>
			</div>
			<div class="userLog">
				<input type="button" value="LOGIN" id="log" onclick="userLogin()"/>
			</div>
			<div class="userSign">
				<input type="button" value="REGISTER" id="reg" />
			</div>
			
		</div>

</body>
<script type="text/javascript">
	function userLogin() {
		var uname=$("#txtAcc").val();
		var upwd=$("#txtPwd").val();
		$.ajax({
			url:"../action/user_loginCheck",
			type:"post",
			dataType:"json",
			data:{
				"clientUser.u_name":uname,
				"clientUser.u_pwd":upwd,
			},
		success:function(data){
			if(data=="success"){
				location.href="../Pages/index.jsp";
			}else if (data=="fail") {
				$("#txtPwd").val("");
				alert("登录失败，请重新登录");
			}
			
		}
			
		})
	}
	
</script>
</html>
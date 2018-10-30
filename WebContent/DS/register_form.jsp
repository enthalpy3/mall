<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회원가입</title>

<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function() {
		
		var good = $("#success");
		var id = $("#id");
		var pw = $("#pw");
		var pw2 = $("#pw2");
		var nick = $("#nick");
		var name = $("#name");
		var phone = $("#phone");
		var email = $("#email");
	});

	function check() {
		
		/* 영어, 숫자만 허용 특수문자 제외  */
		var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
		if (!idReg.test($("input[name=id]").val())) {
			alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
			return false;
		}

		/* 비밀번호는 영문 숫자 특수문자만 허용 */
		var pwReg = /^[a-zA-Z`~!@#$%^&*|\\\'\";:\/?0-9]{8,20}$/g;
		if (!pwReg.test($("input[name=pass]").val())) {
			alert("8~20자 영문자 또는 숫자이어야 합니다. 특수문자가능");
			return false;
		} else if (user.pass.value != user.pass2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}

		/* 한글 영어 숫자 만 가능 */
		var nickReg = /^[가-힣a-zA-Z0-9]{2,20}$/g;
		if (!nickReg.test($("input[name=nick]").val())) {
			alert("2~20자 영문,한글 또는 숫자이어야 합니다.");
			return false;
		}

		/* 한글 영어만 가능 */
		var nameReg = /^[가-힣a-zA-Z]{2,30}$/g;
		if (!nameReg.test($("input[name=name]").val())) {
			alert("2~30자 영문,한글 또는 숫자이어야 합니다.");
			return false;
		}
		/* 숫자만 가능 */
		var phoneReg = /^[0-9]{11}$/g;
		if (!phoneReg.test($("input[name=phone]").val())) {
			alert("-를 제외한 숫자이어야 합니다.");
			return false;
		}
		/* @ 이를 포함 영어와 숫자만 가능 */
		var emailReg = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/g;
		if (!emailReg.test($("input[name=email]").val())) {
			alert("올바른 형식이 아닙니다.");
			return false;
		}
	}
</script>
</head>
<body>
	<div>
		<form action="<%=request.getContextPath()%>/DS/register.jsp"
			name="user" method="post" onSubmit="return check();">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" id="id"
						placeholder="insert id MAX20자" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pass" id="pw"
						placeholder="insert password 8~20자" /></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="pass2" id="pw2"
						placeholder="check password" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" id="name"
						placeholder="insert 이름" /></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" id="phone"
						placeholder="-없이 숫자만 입력하세요" /></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" id="email"
						placeholder="@포함한 이메일 주소" /></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" id="address"
						placeholder="주소를 입력해주세요" /></td>
				</tr>
				<tr>
					<td colspan=2><input type="submit" value="가입" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
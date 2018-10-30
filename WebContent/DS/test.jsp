<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String rPath = request.getContextPath();
		out.print("<h3><a href=\"" + rPath + "/DS/member_info.jsp\">정보수정하기</a></h3>");
	%>
	<h2>로그인이 완료 되었나?</h2>
</body>
</html>
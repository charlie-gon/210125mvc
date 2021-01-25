<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
컨텍스트 패스: <%= request.getContextPath() %> <br />
URL 주소: <%= request.getRequestURL() %> <br />
요청 URI: <%= request.getRequestURI() %> <br />
세션값: <%= request.getSession() %> <br />
호스트: <%= request.getRemoteHost() %>

<h3><a href="../../index.jsp">홈 가기</a></h3>
</body>
</html>
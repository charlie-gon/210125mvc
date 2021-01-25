<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
tr.row:hover{
	background: turquoise;
	cursor: pointer;
}
</style>

</head>


<body>

<div align="center">
<jsp:include page="../common/menu.jsp" />
	<h1>게시글 목록</h1>
	<div>
		<table border="1">
			<tr>
				<th width="100">글번호</th>
				<th width="100">제 목</th>
				<th width="100">작성자</th>
				<th width="100">작성일</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr class="row" onclick="location.href='/210125mvc/BoarderRowSelect.do?row='+${vo.boardNo}">
					<td align="center">${vo.boardNo }</td>
					<td>&nbsp;${vo.title }</td>
					<td>&nbsp;${vo.writer }</td>
					<td align="center">${vo.creationDate }</td>
				</tr>
			</c:forEach>
		</table>
	</div><br />
	<div>
		<button type="button" onclick="location.href='views/board/boardInputForm.jsp'">글쓰기</button>
	</div>
</div>

</body>
</html>
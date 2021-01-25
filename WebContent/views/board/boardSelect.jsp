<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#textarea{
		background-color:yellow;
	}
</style>

</head>
<body>
	
	<div align="center">
<jsp:include page="../common/menu.jsp" />
		<div><h1>게시글 상세보기</h1></div>
			<div>
				<table border="1">
					<tr>
						<th width="80">글번호</th>
						<td width="100" align="center">${vo.boardNo }</td>
						<th width="80">작성자</th>
						<td width="100" align="center">${vo.writer }</td>
						<th width="80">작성일자</th>
						<td width="100" align="center">${vo.creationDate }</td>
					</tr>
					<tr>
						<th width="80">제목</th>
						<td align="center" colspan="5">${vo.title }</td>
					</tr>
					<tr>
						<th width="80">내용</th>
						<td align="center" colspan="5"><textarea id="textarea" rows="7" cols="60">${vo.content }</textarea></td>
					</tr>
				</table>
			</div>
			<p />
			<button type="button" onclick="location.href='/210125mvc/BoardList.do'">목록보기</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='/210125mvc/BoardDelete.do?row='+${vo.boardNo }">글삭제</button>
	</div>

</body>
</html>
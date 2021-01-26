<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#title, #content{
		background-color: turquoise;
		cursor: pointer;
	}
</style>

</head>
<body>

	<div align="center">
<jsp:include page="../common/menu.jsp" />
		<div><h1>게시글 수정화면</h1></div>
			<div>
			<form id="frm" name="frm" action="/210125mvc/BoardUpdateSave.do" method="post">
				<table border="1">
					<tr>
						<th width="80">글번호</th>
						<td width="100" align="center"><input type="text" id="no" name="no" value="${vo.boardNo }" readonly></td>
						<th width="80">작성자</th>
						<td width="100" align="center">${vo.writer }</td>
						<th width="80">작성일자</th>
						<td width="100" align="center">${vo.creationDate }</td>
					</tr>
					<tr>
						<th width="80">제목</th>
						<td colspan="5"><input type="text" id="title" name="title" value="${vo.title }" size="50"></td>
					</tr>
					<tr>
						<th width="80">내용</th>
						<td colspan="5"><textarea id="content" name="content" rows="10" cols="60">${vo.content }</textarea></td>
					</tr>
				</table>
					<p />
					<input type="submit" value="수정"> &nbsp;&nbsp;&nbsp;
					<input type="button" value="목록가기" onclick="location.href='/210125mvc/BoardList.do'">
				</form>
			</div>
			<p />
			
	</div>

</body>
</html>
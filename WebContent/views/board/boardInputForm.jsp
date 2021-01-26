<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center">
		<jsp:include page="../common/menu.jsp" />
		<div><h1>게시글 작성</h1></div>
			<div>
			<form id="frm" name="frm" action="/210125mvc/BoardInput.do" method="post">
				<table border="1">
					<tr>
						<th width="80">글번호</th>
						<td width="100" align="center">
							<input type="text" id="boardNo" name="boardNo">
						</td>
						
						<th width="80">작성자</th>
						<td width="100" align="center">
							<input type="text" id="writer" name="writer">
						</td>
						<th width="80">작성일자</th>
						<td width="100" align="center">
							<input type="date" id="creationDate" name="creationDate">
						</td>
					</tr>
					<tr>
						<th width="80">제목</th>
						<td colspan="5">
							<input type="text" id="title" name="title" size="90">
						</td>
					</tr>
					<tr>
						<th width="80">내용</th>
						<td colspan="5">
							<textarea id="content" name="content" rows="7" cols="85"></textarea>
						</td>
					</tr>
				</table>
				<p />
				
				<!-- form 안에 있어야 정상작동 가능 -->
				<div>
				<button type="submit" onclick="location.href='/210125mvc/BoardInput.do'">저장하기</button> 
				<button type="reset" onclick="location.href='/210125mvc/BoardList.do'">취소</button>
				</div>
				
			</form>	
			</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="kr.itedu.test1.*"%>
<%
	ArrayList<BoardVO> result = (ArrayList<BoardVO>) request.getAttribute("boardList");
	//result.clear();
%>
<%@ page errorPage="error.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/boardList.css?ver=3">
</head>

<body>
	<div class="container">
	<h1><jsp:include page="top.jsp"/></h1>
	<jsp:include page="menu.jsp"/>
		

		<%
			if (result.size() > 0) {
		%>
		<table>
			<tr>
				<td id="one">번호</td>
				<td id="two">제목</td>
				<td id="three">등록일시</td>
			</tr>
			<%
				for (BoardVO vo : result) {
			%>
			<tr>

				<td><%=vo.getBid()%></td>
				<td><a href="boardDetail?bid=<%=vo.getBid()%>"><%=vo.getBtitle()%></a>
				</td>
				<td><%=vo.getBregdate()%> <%
 	}
 %></td>
			</tr>
		</table>
		<form action="boardRegMod" method="get">
		<input type="hidden" name="bid" value="0">
		<input type="submit" value="글쓰기" >
		</form>
		<%
			} else {
		%>
		게시글이 없습니다.
		<%
			}
		%>
	</div>
</body>
</html>